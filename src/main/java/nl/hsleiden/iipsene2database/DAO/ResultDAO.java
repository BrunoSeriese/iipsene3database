package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.model.Result;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class ResultDAO implements DAO<Result> {

    public ResultDAO() {
    }

    @Override
    public ArrayList<Result> getAll() {
        return null;
    }

    @Override
    public Optional<Result> get(Long id) {
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
}
