package nl.hsleiden.iipsene2database.service;

import nl.hsleiden.iipsene2database.DAO.ResultDAO;
import nl.hsleiden.iipsene2database.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles the communication between some controller/dao methods.
 * @author Vincent Seviner
 */
@Service
public class ResultService {
    @Autowired
    private ResultDAO resultDAO;
    @Autowired
    private AnswerService answerService;

    public List<Result> getAll() {
        List<Result> results = this.resultDAO.getAll();
        results.forEach(result -> {
            result.setAnswer(answerService.getAnswer(result.getId()));
        });
        return results;
    }

    public Result get(Long id) {
        Result result = this.resultDAO.get(id);
        result.setAnswer(answerService.getAnswer(id));
        return result;
    }

    public Result update(Result result) {
        return this.resultDAO.update(result.getId(), result.getValue());
    }
}
