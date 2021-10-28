package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.ResultRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Result;
import nl.hsleiden.iipsene2database.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ResultDAO implements DAO<Result> {
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private AnswerService answerService;

    @Override
    public List<Result> getAll() {
        List<Result> results = this.resultRepository.findAll();
        results.forEach(r -> r.setAnswer(answerService.getAnswer(r.getId())));
        return results;
    }

    @Override
    public Result get(Long id) {
        Result result = this.resultRepository.getById(id);
        result.setAnswer(answerService.getAnswer(id));
        return result;
    }

    @Override
    public Result create(Result result) {
        return this.resultRepository.save(result);
    }

    @Override
    public Result update(Long id) {
        return null;
    }

    @Override
    public void delete(Result result) {
        this.resultRepository.delete(result);
    }
}
