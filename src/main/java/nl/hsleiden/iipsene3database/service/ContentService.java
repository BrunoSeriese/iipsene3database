package nl.hsleiden.iipsene3database.service;

import nl.hsleiden.iipsene3database.DAO.ContentDAO;
import nl.hsleiden.iipsene3database.model.Answer;
import nl.hsleiden.iipsene3database.model.Content;

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

    private List<Content> getContentsFromResultSets(List<Map<String, Object>> contentMaps) {
        List<Content> contents = new ArrayList<>();
        for(Map<String, Object> contentMap : contentMaps) {
            Content content = getContentFromResultSet(contentMap);
            contents.add(content);
        }
        return contents;
    }

    private Content getContentFromResultSet(Map<String, Object> contentMap) {
        Long contentId = (Long) contentMap.get("contentId");
        String contentValue = (String) contentMap.get("contentValue");
        String contentType = (String) contentMap.get("contentType");
        Integer[] answerIds = (Integer[]) contentMap.get("answerIds");
        String[] answerValues = (String[]) contentMap.get("answerValues");
        List<Answer> answer = getAnswers(answerIds, answerValues);
        return new Content(contentId, contentValue, contentType, answer);
    }

    private List<Answer> getAnswers(Integer[] ids, String[] values) {
        List<Answer> answers = new ArrayList<>();
        for(int i = 0; i < ids.length; i++) {
            Answer answer = new Answer(ids[i], values[i]);
            answers.add(answer);
        }
        return answers;
    }
}
