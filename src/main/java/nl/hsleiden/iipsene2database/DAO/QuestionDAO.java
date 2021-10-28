package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.QuestionRepository;
import nl.hsleiden.iipsene2database.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionDAO implements DAO<Question> {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerDAO answerDAO;

    @Override
    public List<Question> getAll() {
        return this.questionRepository.findAll();
    }

    @Override
    public Question get(Long id) {
        return this.questionRepository.getById(id);
    }

    public List<Question> getList(Long listId) {
        return null;
    }

    @Override
    public Question create(Question question) {
        return this.questionRepository.save(question);
    }

    public List<Question> createList(Long listId) {
        return null;
    }

    public Question update(Long id, String value) {
        return this.questionRepository.update(id, value);
    }

    @Override
    public void delete(Question question) {
        this.questionRepository.delete(question);
    }

    public void deleteList(List<Question> questions) {
    }

    public List<Question> patchList(Long listId) {
        return null;
    }
}
