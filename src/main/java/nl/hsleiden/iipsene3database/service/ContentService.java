package nl.hsleiden.iipsene3database.service;

import nl.hsleiden.iipsene3database.DAO.AnswerDAO;
import nl.hsleiden.iipsene3database.DAO.ContentDAO;
import nl.hsleiden.iipsene3database.model.Answer;
import nl.hsleiden.iipsene3database.model.Content;

import nl.hsleiden.iipsene3database.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Handles the communication between some controller/dao methods.
 * @author Vincent Severin
 */
@Service
public class ContentService {
    @Autowired
    private ContentDAO contentDAO;
    @Autowired
    private AnswerDAO answerDAO;

    public List<Content> getAll() {
        List<Map<String, Object>> contentMaps = this.contentDAO.getAll();
        return getContentsFromResultSets(contentMaps);
    }

    @Transactional
    public void create(Content content, Long parentContentId) {
        this.contentDAO.create(content, parentContentId);
    }

    @Transactional
    public void createAnswers(Content content) {
        for(Answer answer : content.getAnswers()) {
            this.answerDAO.create(answer, content.getId());
        }
    }

    public void update(Content content, Long parentNodeId) {
        Node node = this.contentDAO.update(content, parentNodeId);
        List<Answer> answers = content.getAnswers();
        for (Answer answer : answers) {
            if(answer.getId() == null) {
                this.answerDAO.create(answer, node.getId());
            }
            this.answerDAO.update(answer);
        }
    }

    public void delete(Content content) {
        this.contentDAO.delete(content);
    }

    public void delete() {
        this.contentDAO.delete();
        this.answerDAO.delete();
    }

    /**
     * Loops through the list of contentMaps.
     * @param contentMaps A list containing information of a content
     * @return A list of Content
     * @author Vincent Severin
     */
    private List<Content> getContentsFromResultSets(List<Map<String, Object>> contentMaps) {
        List<Content> contents = new ArrayList<>();
        for(Map<String, Object> contentMap : contentMaps) {
            Content content = getContentFromResultSet(contentMap);
            contents.add(content);
        }
        return contents;
    }

    /**
     * Convserts the ContentMap to a Content.
     * @param contentMap Contains information of a content
     * @return A content
     * @author Vincent Severin
     */
    private Content getContentFromResultSet(Map<String, Object> contentMap) {
        Long contentId = (Long) contentMap.get("contentId");
        String contentValue = (String) contentMap.get("contentValue");
        String contentType = (String) contentMap.get("contentType");
        Integer[] answerIds = (Integer[]) contentMap.get("answerIds");
        String[] answerValues = (String[]) contentMap.get("answerValues");
        List<Answer> answer = getAnswers(answerIds, answerValues);
        return new Content(contentId, contentValue, contentType, answer);
    }

    /**
     * Gets the Answers out of the id & value arrays.
     * @param ids Contains all the ids of the answers
     * @param values Contains all the values of the answers
     * @return A list of Answers
     * @author Vincent Severin
     */
    private List<Answer> getAnswers(Integer[] ids, String[] values) {
        List<Answer> answers = new ArrayList<>();
        for(int i = 0; i < ids.length; i++) {
            Answer answer = new Answer(ids[i], values[i]);
            answers.add(answer);
        }
        return answers;
    }
}
