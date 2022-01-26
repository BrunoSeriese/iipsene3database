package nl.hsleiden.iipsene3database.model;

import javax.persistence.*;

@Entity
@Table(name = "path")
public class Path {
    private Long nodeId;
    @Id
    private Integer answerId;

    public Path() {

    }

    public Path(Long nodeId, Integer answerId) {
        this.nodeId = nodeId;
        this.answerId = answerId;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public Integer getAnswerId() {
        return answerId;
    }
}
