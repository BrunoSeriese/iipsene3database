package nl.hsleiden.iipsene2database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Explanation implements Content {
    @Id
    @GeneratedValue
    private Long id;
    private String value;
    private String type;
    @Transient
    private Answer answer;

    public Explanation(){

    }

    public Explanation(
                       String value,
                       Answer answer,
                       String type) {

        this.value = value;
        this.answer = answer;
        this.type = type;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getType() {
        return type;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
