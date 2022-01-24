package nl.hsleiden.iipsene3database.model;

import javax.persistence.*;

@Entity
@Table(name = "node")
public class Node {
    @Id
    private Long id;
    private Long contentId;
    private Long parentNode;

    public Node() {
    }

    public Node(Long id, Long contentId, Long parentNodeId) {
        this.id = id;
        this.contentId = contentId;
        this.parentNode = parentNodeId;
    }

    public Long getId() {
        return id;
    }

    public Long getContentId() {
        return contentId;
    }

    public Long getParentNode() {
        return parentNode;
    }
}
