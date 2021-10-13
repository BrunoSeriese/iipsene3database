package nl.hsleiden.iipsene2database.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question implements Content {
    @Id
    private final int id;
    private final String value;
    private final Answer[] answers;

    public Question(int id,
                       String value,
                       Answer[] answers) {
        this.id = id;
        this.value = value;
        this.answers = answers;
    }

    @Override
    public int getId() {
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
