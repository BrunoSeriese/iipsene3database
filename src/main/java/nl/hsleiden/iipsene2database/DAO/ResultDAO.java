package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.ResultRepository;
import nl.hsleiden.iipsene2database.model.Result;
import nl.hsleiden.iipsene2database.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The DAO, Data Access Object, that handles all the Result related requests to the Database.
 * @author Vincent Severin
 */
@Component
public class ResultDAO implements DAO<Result> {
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private AnswerService answerService;

    /**
     * Gets all the Results in the Database.
     * @return All Results
     * @author Vincent Severin
     */
    @Override
    public List<Result> getAll() {
        return this.resultRepository.findAll();
    }

    /**
     * Gets a Result based of the id param out of the Database.
     * @param id The id of Result it is trying to find
     * @return The Result with the same id as that of the id param
     * @author Vincent Severin
     */
    @Override
    public Result get(Long id) {
        return this.resultRepository.getById(id);
    }

    /**
     * Creates a new Result in the Database.
     * @param result a Result
     * @return The Result created.
     * @author Vincent Severin
     */
    @Override
    public Result create(Result result) {
        return this.resultRepository.save(result);
    }

    /**
     * Updates a Result in the Database.
     * @param id The id of the Result
     * @param value The value of the Result
     * @author Vincent Severin
     */
    public void update(Long id, String value) {
        this.resultRepository.update(id, value);
    }

    /**
     * Deletes a Result from the Database.
     * @param result a Result
     * @author Vincent Severin
     */
    @Override
    public void delete(Result result) {
        this.resultRepository.delete(result);
    }
}
