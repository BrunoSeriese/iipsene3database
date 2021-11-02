package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.AnswerRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnswerDAO implements DAO<Answer> {
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<Answer> getAll() {
        return this.answerRepository.findAll();
    }

    @Override
    public Answer get(Long id) {
        return this.answerRepository.getById(id);
    }

    public List<Answer> getByCurrentContentId(Long currentContentId) {
        return this.answerRepository.getByCurrentContentId(currentContentId);
    }

    @Override
    public Answer create(Answer answer) {
        return this.answerRepository.save(answer);
    }

    public Answer update(Long id, String value, Long currentContentId, Long nextContentId) {
        return this.answerRepository.update(id, value, nextContentId, currentContentId);
    }

    @Override
    public void delete(Answer answer) {
        this.answerRepository.delete(answer);
    }
}
