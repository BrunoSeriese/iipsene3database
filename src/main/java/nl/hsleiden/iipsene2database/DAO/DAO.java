package nl.hsleiden.iipsene2database.DAO;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    List<T> getAll();
    T get(Long id);
    void create();
    void update(Long id);
    void delete(Long id);
}
