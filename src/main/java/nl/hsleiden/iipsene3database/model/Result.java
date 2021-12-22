package nl.hsleiden.iipsene3database.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * The Result entity as a Class.
 * @author Vincent Severin
 */
@Entity
@Table(name = "content")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Result implements Content {
    @Id
    private Long id;
    private String value;
    private final String type = "RESULT";
    @Transient
    private Answer answer;

    public Result(){

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
