package nl.hsleiden.iipsene3database.model;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    private Integer id;
    private String value;

    public Answer() {
    }

    public Answer(Integer id,
                  String value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
