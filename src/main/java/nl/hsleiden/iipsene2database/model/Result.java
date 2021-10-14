package nl.hsleiden.iipsene2database.model;

import javax.persistence.*;

@Entity
@Table(name = "content")
public class Result implements Content {
    @Id
    @GeneratedValue
    private Long id;
    private String value;
    private String type;
    @Transient
    private Answer answer;

    public Result(){

    }

    public Result(String value,
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

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
