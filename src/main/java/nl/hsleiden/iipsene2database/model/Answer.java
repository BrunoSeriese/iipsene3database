package nl.hsleiden.iipsene2database.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer  {
    @Id
    private final int id;
    private final String value;
    private final int currentContentId;
    private final int nextContentId;

    public Answer(int id,
                  String value,
                  int currentContentId,
                  int nextContentId) {
        this.id = id;
        this.value = value;
        this.currentContentId = currentContentId;
        this.nextContentId = nextContentId;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public int getCurrentContentId() {
        return currentContentId;
    }

    public int getNextContentId() {
        return nextContentId;
    }
}
