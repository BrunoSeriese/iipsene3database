package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.AnswerRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The DAO, Data Access Object, that handles all the Answer related requests to the Database.
 * @author Vincent Severin
 */
@Component
public class AnswerDAO implements DAO<Answer> {
    @Autowired
    private AnswerRepository answerRepository;

    /**
     * Gets all the Answer in the Database and returns them.
     * @return All Answers
     * @author Vincent Severin
     */
    @Override
    public List<Answer> getAll() {
        return this.answerRepository.findAll();
    }

    /**
     * Gets an Answer based of the id param out of the database.
     * @param id The id of Answer it is trying to find
     * @return The Answer with the same id as the id param
     * @author Vincent Severin
     */
    @Override
    public Answer get(Long id) {
        return this.answerRepository.getById(id);
    }

    /**
     * Gets all Answer(s) based of the currentContentId param out of the Database.
     * @param currentContentId The currentContentId of the Answer(s)
     * @return All Answer(s) with the same currentContentId as the currentContentId param
     * @author Vincent Severin
     */
    public List<Answer> getByCurrentContentId(Long currentContentId) {
        return this.answerRepository.getByCurrentContentId(currentContentId);
    }

    /**
     * Creates a new Answer in the Database.
     * @param answer an Answer
     * @return The answer created
     * @author Vincent Severin
     */
    @Override
    public Answer create(Answer answer) {
        return this.answerRepository.save(answer);
    }

    /**
     * Updates an Answer in the Database
     * @param id The id of the Answer
     * @param value The value of the Answer
     * @param currentContentId The currentContentId of the Answer
     * @param nextContentId The nextContentId of the Answer
     * @author Vincent Severin
     */
    public void update(Long id, String value, Long currentContentId, Long nextContentId) {
        this.answerRepository.update(id, value, currentContentId, nextContentId);
    }

    /**
     * Deletes an Answer from the Database.
     * @param answer an Answer
     * @author Vincent Severin
     */
    @Override
    public void delete(Answer answer) {
        this.answerRepository.delete(answer);
    }
}
