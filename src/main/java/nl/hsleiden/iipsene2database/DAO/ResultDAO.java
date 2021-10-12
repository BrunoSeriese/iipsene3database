package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.ResultRepository;
import nl.hsleiden.iipsene2database.model.Result;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ResultDAO implements DAO<Result> {
    private final ResultRepository resultRepository;

    public ResultDAO(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public ArrayList<Result> getAll() {
        return null;
    }
}
