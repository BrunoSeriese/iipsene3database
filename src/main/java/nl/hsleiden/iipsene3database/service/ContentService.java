package nl.hsleiden.iipsene3database.service;

import nl.hsleiden.iipsene3database.DAO.ContentDAO;
import nl.hsleiden.iipsene3database.model.Answer;
import nl.hsleiden.iipsene3database.model.Content;

import nl.hsleiden.iipsene3database.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Content> getAll() {
        List<Map<String, Object>> contentMaps = this.contentDAO.getAll();
        return getContentsFromResultSets(contentMaps);
    }

    public Content create(Content content, Long parentContentId) {
        this.contentDAO.create(content, new Node(), parentContentId);
        return content;
    }

    public void update(Content content) {
        this.contentDAO.update(content);
    }

    public void delete(Content content) {
        this.contentDAO.delete(content);
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
        Long[] answerIds = (Long[]) contentMap.get("answerIds");
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
    private List<Answer> getAnswers(Long[] ids, String[] values) {
        List<Answer> answers = new ArrayList<>();
        for(int i = 0; i < ids.length; i++) {
            Answer answer = new Answer(ids[i], values[i]);
            answers.add(answer);
        }
        return answers;
    }
}
