package nl.hsleiden.iipsene2database.DAO;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
    T get(Long id);
    T create(T t);
    T update(Long id);
    void delete(T t);
}
