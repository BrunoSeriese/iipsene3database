package nl.hsleiden.iipsene2database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Question implements Content {

    @Id
    @GeneratedValue
    private Long id;
    private String value;
    @Transient
    private Answer[] answers;

    public Question(){
    }

    public Question(String value,
                       Answer[] answers) {

        this.value = value;
        this.answers = answers;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getValue() {
        return value;
    }

    public Answer[] getAnswers() {
        return answers;
    }
}
