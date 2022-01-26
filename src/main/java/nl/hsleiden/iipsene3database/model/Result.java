package nl.hsleiden.iipsene3database.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_results")
public class Result {
    @Id
    private Long id;
    private String dateAdded;
    private String result;

    public Result() {

    }

    public Result(Long id, String dateAdded, String result) {
        this.id = id;
        this.dateAdded = dateAdded;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
