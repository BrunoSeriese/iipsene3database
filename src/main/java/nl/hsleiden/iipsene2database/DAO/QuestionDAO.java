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

    @Override
    public Question create(Question question) {
        return this.questionRepository.save(question);
    }

    public Question update(Long id, String value) {
        return this.questionRepository.update(id, value);
    }

    @Override
    public void delete(Question question) {
        this.questionRepository.delete(question);
    }
}
