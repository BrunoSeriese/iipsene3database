package nl.hsleiden.iipsene2database.DAO;

import java.util.ArrayList;
import java.util.Optional;

public interface DAO<T> {
    ArrayList<T> getAll();
    Optional<T> get(Long id);
    void create();
    void update(Long id);
    void delete(Long id);
}
