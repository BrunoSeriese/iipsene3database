package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.model.Result;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ResultDAO implements DAO<Result> {

    public ResultDAO() {
    }

    @Override
    public ArrayList<Result> getAll() {
        return null;
    }

    @Override
    public Result get(int id) {
        return null;
    }

    @Override
    public void create() {
    }

    @Override
    public void update(int id) {
    }

    @Override
    public void delete(int id) {
    }
}
