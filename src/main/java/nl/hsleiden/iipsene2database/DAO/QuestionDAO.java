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
}
