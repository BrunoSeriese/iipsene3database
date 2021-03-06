package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.AnswerRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Content;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class AnswerDAO implements DAO<Answer> {
    private final AnswerRepository answerRepository;

    public AnswerDAO(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> getAll() {
        return this.answerRepository.findAll();
    }

    @Override
    public Answer get(Long id) {
        List<Answer> answers = this.answerRepository.findAll();
        answers.removeIf(a -> !Objects.equals(a.getId(), id));
        return answers.get(0);
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
    public void update(Long id) {
    }

    @Override
    public void delete(Long id) {
    }

    public void patchList(Long questionId) {
    }

}
