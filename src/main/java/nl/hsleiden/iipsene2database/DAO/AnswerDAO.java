package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.AnswerRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnswerDAO implements DAO<Answer> {
    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerDAO(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> getAll() {
        return this.answerRepository.findAll();
    }

    @Override
    public Answer get(Long id) {
        return this.answerRepository.getById(id);
    }

    public List<Answer> getByCurrentContentId(Long currentContentId) {
        List<Answer> answers = this.answerRepository.findAll();
        answers.removeIf(a -> a.getCurrentContentId() != currentContentId);
        return answers;
    }

    public Content getNextContentById(Long id) {
        return null;
    }

    @Override
    public Answer create(Answer answer) {
        return this.answerRepository.save(answer);
    }

    @Override
    public Answer update(Long id) {
        return null;
    }

    @Override
    public void delete(Answer answer) {
        this.answerRepository.delete(answer);
    }

    public List<Answer> patchList(Long contentId) {
        return null;
    }

}
