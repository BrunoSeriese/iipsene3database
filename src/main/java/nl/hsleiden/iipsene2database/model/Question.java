package nl.hsleiden.iipsene2database.model;

import javax.persistence.*;

@Entity
@Table(name = "content")
public class Question implements Content {
    @Id
    @GeneratedValue
    private Long id;
    private String value;
    private String type;
    @Transient
    private Answer[] answers;

    public Question(){
    }

    public Question(String value,
                    String type) {

        this.value = value;
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

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
    }
}
