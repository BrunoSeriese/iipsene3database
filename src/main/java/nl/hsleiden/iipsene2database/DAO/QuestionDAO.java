package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.QuestionRepository;
import nl.hsleiden.iipsene2database.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The DAO, Data Access Object, that handles all the Question related requests to the Database.
 * @author Vincent Severin
 */
@Component
public class QuestionDAO implements DAO<Question> {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerDAO answerDAO;

    /**
     * Gets all the Questions in the Database.
     * @return All Questions
     * @author Vincent Severin
     */
    @Override
    public List<Question> getAll() {
        return this.questionRepository.findAll();
    }

    /**
     * Gets a question based of the id param out of the Database.
     * @param id The id of Question it is trying to find
     * @return The question with the same id as that of the id param.
     * @author Vincent Severin
     */
    @Override
    public Question get(Long id) {
        return this.questionRepository.getById(id);
    }

    /**
     * Creates a new Question in the Database.
     * @param question a Question
     * @return The Question created
     * @author Vincnent Severin
     */
    @Override
    public Question create(Question question) {
        return this.questionRepository.save(question);
    }

    /**
     * Updates a Question in the Database.
     * @param id The id of the Question
     * @param value The value of the Question
     * @author Vincent Severin
     */
    public void update(Long id, String value) {
        this.questionRepository.update(id, value);
    }

    /**
     * Deletes a Question from the Database.
     * @param question a Question
     * @author Vincent Severin
     */
    @Override
    public void delete(Question question) {
        this.questionRepository.delete(question);
    }
}
