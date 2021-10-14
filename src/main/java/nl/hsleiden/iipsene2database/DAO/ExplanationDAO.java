package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.model.Explanation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class ExplanationDAO implements DAO<Explanation> {

    public ExplanationDAO() {
    }

    @Override
    public ArrayList<Explanation> getAll() {
        return null;
    }

    @Override
    public Optional<Explanation> get(Long id) {
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
