package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.ResultRepository;
import nl.hsleiden.iipsene2database.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ResultDAO implements DAO<Result> {
    private final ResultRepository resultRepository;

    @Autowired
    public ResultDAO(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<Result> getAll() {
        List<Result> results = this.resultRepository.findAll();
        results.removeIf(r -> !Objects.equals(r.getType(), "RESULT"));
        return results;
    }

    @Override
    public Result get(Long id) {
        return this.resultRepository.getById(id);
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
}
