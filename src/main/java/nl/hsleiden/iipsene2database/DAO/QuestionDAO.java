package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.QuestionRepository;
import nl.hsleiden.iipsene2database.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class QuestionDAO implements DAO<Question> {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionDAO(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAll() {
        List<Question> questions = this.questionRepository.findAll();
        questions.removeIf(q -> !Objects.equals(q.getType(), "QUESTION"));
        return questions;
    }

    @Override
    public Question get(Long id) {
        List<Question> questions = this.questionRepository.findAll();
        questions.removeIf(q -> !Objects.equals(q.getId(), id));
        return questions.get(0);
    }

    public List<Question> getList(Long listId) {
        return null;
    }

    @Override
    public Question create(Question question) {
        return this.questionRepository.save(question);
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
