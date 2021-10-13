package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.model.Explanation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ExplanationDAO implements DAO<Explanation> {

    public ExplanationDAO() {
    }

    @Override
    public ArrayList<Explanation> getAll() {
        return null;
    }

    @Override
    public Explanation get(int id) {
        return null;
    }

    @Override
    public void post() {
    }

    @Override
    public void put(int id) {
    }

    @Override
    public void delete(int id) {
    }
}
