package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.model.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class QuestionDAO implements DAO<Question> {

    public QuestionDAO() {
    }

    @Override
    public ArrayList<Question> getAll() {
        return null;
    }

    @Override
    public Optional<Question> get(Long id) {
        return null;
    }

    public ArrayList<Question> getList(Long listId) {
        return null;
    }

    @Override
    public void create() {
    }

    public void postList(Long listId) {
    }

    @Override
    public void update(Long id) {
    }

    @Override
    public void delete(Long id) {
    }

    public void deleteList(Long listId) {
    }

    public void patchList(Long listId) {
    }
}
