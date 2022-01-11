package nl.hsleiden.iipsene3database.model;

import javax.persistence.*;

@Entity
@Table(name = "path")
public class Path {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long nodeId;
    private Integer answerId;

    public Path() {

    }

    public Path(Long nodeId, Integer answerId) {
        this.nodeId = nodeId;
        this.answerId = answerId;
    }

    public Long getId() {
        return id;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public Integer getAnswerId() {
        return answerId;
    }
}
