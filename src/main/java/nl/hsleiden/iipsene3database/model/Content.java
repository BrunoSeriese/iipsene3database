package nl.hsleiden.iipsene3database.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;
    private String type;
    @Transient
    private List<Answer> answers;

    public Content() {
    }

    public Content(Long id,
                   String value,
                   String type,
                   List<Answer> answers) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
