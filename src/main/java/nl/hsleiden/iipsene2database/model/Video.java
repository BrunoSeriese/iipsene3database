package nl.hsleiden.iipsene2database.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Video implements Content {
    @Id
    private Long id;
    private String value;
    @Transient
    private Answer answer;

    public Video(){

    }

    public Video(String value, Answer answer) {
        this.value = value;
        this.answer = answer;
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
}
