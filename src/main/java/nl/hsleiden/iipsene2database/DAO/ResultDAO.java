package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.ResultRepository;
import nl.hsleiden.iipsene2database.model.Result;
import nl.hsleiden.iipsene2database.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultDAO implements DAO<Result> {
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private AnswerService answerService;

    @Override
    public List<Result> getAll() {
        return this.resultRepository.findAll();
    }

    @Override
    public Result get(Long id) {
        return this.resultRepository.getById(id);
    }

    @Override
    public Result create(Result result) {
        return this.resultRepository.save(result);
    }

    public Result update(Long id, String value) {
        return this.resultRepository.update(id, value);
    }

    @Override
    public void delete(Result result) {
        this.resultRepository.delete(result);
    }
}
