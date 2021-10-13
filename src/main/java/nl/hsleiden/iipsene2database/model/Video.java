package nl.hsleiden.iipsene2database.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Video implements Content {
    @Id
    private final int id;
    private final String value;
    private final Answer answer;

    public Video(int id,
                       String value,
                       Answer answer) {
        this.id = id;
        this.value = value;
        this.answer = answer;
    }

    @Override
    public int getId() {
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
