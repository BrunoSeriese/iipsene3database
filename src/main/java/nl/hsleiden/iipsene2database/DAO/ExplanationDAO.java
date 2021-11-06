package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.ExplanationRepository;
import nl.hsleiden.iipsene2database.model.Explanation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The DAO, Data Access Object, that handles all the Explanation related requests to the Database.
 * @author Vincent Severin
 */
@Component
public class ExplanationDAO implements DAO<Explanation> {
    @Autowired
    private ExplanationRepository explanationRepository;
    @Autowired
    private AnswerDAO answerDAO;

    /**
     * Gets all the Explanations in the Database.
     * @return All Explanations
     * @author Vincent Severin
     */
    @Override
    public List<Explanation> getAll() {
        return this.explanationRepository.findAll();
    }

    /**
     * Gets an Explanation based of the id param out of the Database.
     * @param id The id of Explanation it is trying to find
     * @return The Explanation with the same id as that of the id param
     * @author Vincent Severin
     */
    @Override
    public Explanation get(Long id) {
        return this.explanationRepository.getById(id);
    }

    /**
     * Creates a new Explanation in the Database.
     * @param explanation an Explanation
     * @return The Explanation created
     * @author Vincent Severin
     */
    @Override
    public Explanation create(Explanation explanation) {
        return this.explanationRepository.save(explanation);
    }

    /**
     * Updates an Explanation in the Database.
     * @param id The id of the Explanation
     * @param value The value of the Explanation
     * @author Vincent Severin
     */
    public void update(Long id, String value) {
        this.explanationRepository.update(id, value);
    }

    /**
     * Deletes an Explanation from the Database.
     * @param explanation an Explanation
     * @author Vincent Severin
     */
    @Override
    public void delete(Explanation explanation) {
        this.explanationRepository.delete(explanation);
    }
}
