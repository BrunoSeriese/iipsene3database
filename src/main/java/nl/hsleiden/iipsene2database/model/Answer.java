package nl.hsleiden.iipsene2database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer  {



    @Id
    @GeneratedValue
    private Long id;
    private String value;
    private int currentContentId;
    private int nextContentId;


    public Answer(){

    }

    public Answer(
                  String value,
                  int currentContentId,
                  int nextContentId) {
        this.value = value;
        this.currentContentId = currentContentId;
        this.nextContentId = nextContentId;
    }


    public Long getId() {
        return this.id;
    }

    public String getValue() {
        return this.value;
    }

    public int getCurrentContentId() {
        return this.currentContentId;
    }

    public int getNextContentId() {
        return this.nextContentId;
    }
}
