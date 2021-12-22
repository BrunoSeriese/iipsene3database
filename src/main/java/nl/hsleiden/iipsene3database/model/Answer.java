package nl.hsleiden.iipsene3database.model;

public class Answer {
    private Integer id;
    private String value;

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
}
