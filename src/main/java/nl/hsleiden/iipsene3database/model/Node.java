package nl.hsleiden.iipsene3database.model;

import javax.persistence.*;

@Entity
@Table(name = "node")
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long contentId;
    private Long parentNodeId;

    public Node() {
    }

    public Node(Long contentId, Long parentNodeId) {
        this.contentId = contentId;
        this.parentNodeId = parentNodeId;
    }

    public Long getId() {
        return id;
    }

    public Long getContentId() {
        return contentId;
    }

    public Long getParentNodeId() {
        return parentNodeId;
    }
}
