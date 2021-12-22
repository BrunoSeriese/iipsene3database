package nl.hsleiden.iipsene3database.model;

import java.util.ArrayList;
import java.util.List;

public class Content {
    private Long id;
    private String value;
    private String type;
    private List<Answer> answers;

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
