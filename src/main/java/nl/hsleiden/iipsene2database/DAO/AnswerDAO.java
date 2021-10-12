package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.AnswerRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AnswerDAO implements DAO<Answer> {
    private final AnswerRepository answerRepository;

    public AnswerDAO(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public ArrayList<Answer> getAll() {
        return null;
    }
}
