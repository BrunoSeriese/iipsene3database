package nl.hsleiden.iipsene2database.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "content")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question implements Content {
    @Id
    @GeneratedValue
    private Long id;
    private String value;
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
