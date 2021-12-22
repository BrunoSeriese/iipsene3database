package nl.hsleiden.iipsene3database.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * The Question entity as a Class.
 * @author Vincent Severin
 */
@Entity
@Table(name = "content")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question implements Content {
    @Id
    private Long id;
    private String value;
    private final String type = "QUESTION";
    @Transient
    private List<Answer> answers;

    public Question(){
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getValue() {
        return value;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


}
