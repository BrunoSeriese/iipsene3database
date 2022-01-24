package nl.hsleiden.iipsene3database.model;

public class ContentRequest {
    private Content content;
    private Long parentNodeId;

    public ContentRequest() {

    }

    public ContentRequest(Content content, Long parentNodeId) {
        this.content = content;
        this.parentNodeId = parentNodeId;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Long getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(Long parentNodeId) {
        this.parentNodeId = parentNodeId;
    }
}
