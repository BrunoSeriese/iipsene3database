package nl.hsleiden.iipsene2database.model;

public class Explanation implements Content {
    private final int id;
    private final String value;
    private final Answer answer;

    public Explanation(int id,
                       String value,
                       Answer answer) {
        this.id = id;
        this.value = value;
        this.answer = answer;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public Answer getAnswer() {
        return answer;
    }
}
