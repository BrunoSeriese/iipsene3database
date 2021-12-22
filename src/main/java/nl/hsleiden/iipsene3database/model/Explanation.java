package nl.hsleiden.iipsene3database.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * The Explanation entity as a Class.
 * @author Vincent Severin
 */
@Entity
@Table(name = "content")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Explanation implements Content {
    @Id
    private Long id;
    private String value;
    private final String type = "EXPLANATION";
    @Transient
    private Answer answer;

    public Explanation(){

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getValue() {
        return value;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
