package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.QuestionRepository;
import nl.hsleiden.iipsene2database.model.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class QuestionDAO implements DAO<Question> {
    private final QuestionRepository questionRepository;

    public QuestionDAO(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public ArrayList<Question> getAll() {
        return null;
    }

    public Question get() {
        return null;
    }

    public ArrayList<Question> getList() {
        return null;
    }

    public void post() {
    }

    public void postList() {
    }

    public void put() {
    }

    public void delete() {
    }

    public void deleteList() {
    }

    public void patchList() {
    }
}
