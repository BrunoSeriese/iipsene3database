package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.AnswerRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Content;
import nl.hsleiden.iipsene2database.model.Question;
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

    public Answer get(int id) {
        return null;
    }

    public ArrayList<Answer> getByQuestionId(int questionId) {
        return null;
    }

    public Content getNextContentById(int id) {
        return null;
    }

    public void post() {
    }

    public void put(int id) {
    }

    public void delete(int id) {
    }

    public void patchList(int questionId) {
    }
}
