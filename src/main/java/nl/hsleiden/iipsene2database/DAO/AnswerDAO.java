package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Content;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AnswerDAO implements DAO<Answer> {

    public AnswerDAO() {
    }

    @Override
    public ArrayList<Answer> getAll() {
        return null;
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
    public void post() {
    }

    @Override
    public void put(int id) {
    }

    @Override
    public void delete(int id) {
    }

    public void patchList(int questionId) {
    }
}
