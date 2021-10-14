package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.AnswerRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Content;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

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
    public Optional<Answer> get(Long id) {

        return this.answerRepository.findById(id);
    }

    public ArrayList<Answer> getByQuestionId(Long questionId) {
        return null;
    }

    public Content getNextContentById(Long id) {
        return null;
    }

    @Override
    public void create() {
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
