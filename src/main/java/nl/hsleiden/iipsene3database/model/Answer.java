package nl.hsleiden.iipsene3database.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Answer entity as a Class.
 * @author Vincent Severin
 */
@Entity
@Table(name = "answer")
public class Answer  {
    @Id
    private Long id;
    private String value;
    private Long currentContentId;
    private Long nextContentId;

    public Answer(){

    }

    public Long getId() {
        return this.id;
    }

    public String getValue() {
        return this.value;
    }

    public Long getCurrentContentId() {
        return this.currentContentId;
    }

    public Long getNextContentId() {
        return this.nextContentId;
    }
}
