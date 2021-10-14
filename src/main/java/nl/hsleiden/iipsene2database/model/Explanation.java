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
    @Transient
    private Answer answer;

    public Explanation(){

    }

    public Explanation(
                       String value,
                       Answer answer) {

        this.value = value;
        this.answer = answer;
    }


    @Override
    public Long getId() {
        return null;
    }

    @Override
    public String getValue() {
        return value;
    }

    public Answer getAnswer() {
        return answer;
    }
}
