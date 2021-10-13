package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.model.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class QuestionDAO implements DAO<Question> {

    public QuestionDAO() {
    }

    @Override
    public ArrayList<Question> getAll() {
        return null;
    }

    @Override
    public Question get(int id) {
        return null;
    }

    public ArrayList<Question> getList(int listId) {
        return null;
    }

    @Override
    public void create() {
    }

    public void postList(int listId) {
    }

    @Override
    public void update(int id) {
    }

    @Override
    public void delete(int id) {
    }

    public void deleteList(int listId) {
    }

    public void patchList(int listId) {
    }
}
