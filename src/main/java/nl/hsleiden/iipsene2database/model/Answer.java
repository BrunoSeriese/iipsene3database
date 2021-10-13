package nl.hsleiden.iipsene2database.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "content_answer")
public class Answer {
    @Id
    private final int id;
    private final int content_value_id;
    private final int current_content_id;
    private final int next_content_id;
    /*@Transient
    private final String value;
    @Transient
    private final int currentContentId;
    @Transient
    private final int nextContentId;*/

    /*public Answer(int id,
                  String value,
                  int currentContentId,
                  int nextContentId) {
        this.id = id;
        this.value = value;
        this.currentContentId = currentContentId;
        this.nextContentId = nextContentId;
    }*/

    public Answer(int id, int content_value_id, int current_content_id, int next_content_id) {
        this.id = id;
        this.content_value_id = content_value_id;
        this.current_content_id = current_content_id;
        this.next_content_id = next_content_id;
    }

    public int getId() {
        return id;
    }

    public int getContent_value_id() {
        return content_value_id;
    }

    public int getCurrent_content_id() {
        return current_content_id;
    }

    public int getNext_content_id() {
        return next_content_id;
    }
}
