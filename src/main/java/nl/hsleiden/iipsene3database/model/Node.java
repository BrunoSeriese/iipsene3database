package nl.hsleiden.iipsene3database.model;

import javax.persistence.*;

@Entity
@Table(name = "node")
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long parentNodeId;

    public Node() {
    }

    public Long getId() {
        return id;
    }

    public Long getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(Long parentNodeId) {
        this.parentNodeId = parentNodeId;
    }
}
