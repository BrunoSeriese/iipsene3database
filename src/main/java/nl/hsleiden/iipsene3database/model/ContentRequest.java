package nl.hsleiden.iipsene3database.model;

import javax.persistence.Transient;
import java.util.List;

public class ContentRequest {
    private Long id;
    private String value;
    private String type;
    private List<Answer> answers;
    private Long parentNodeId;

    public ContentRequest() {

    }

    public ContentRequest(Long id, String value, String type, List<Answer> answers, Long parentNodeId) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.answers = answers;
        this.parentNodeId = parentNodeId;
    }

    public Long getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(Long parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
