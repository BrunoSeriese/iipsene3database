package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.AnswerRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Content;
import org.springframework.objenesis.instantiator.android.AndroidSerializationInstantiator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AnswerDAO implements DAO<Answer> {

    private AnswerRepository answerRepository;

    public AnswerDAO(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public ArrayList<Answer> getAll() {
        ArrayList<Answer> answers = (ArrayList<Answer>) this.answerRepository.findAll();
        return answers;
    }

    @Override
    public Answer get(int id) {
        return null;
    }

    public ArrayList<Answer> getByQuestionId(int questionId) {
        return null;
    }

    public Content getNextContentById(int id) {
        return null;
    }

    @Override
    public void create() {
    }

    @Override
    public void update(int id) {
    }

    @Override
    public void delete(int id) {
    }

    public void patchList(int questionId) {
    }

}
