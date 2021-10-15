package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.model.Answer;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
    T get(Long id);
    T create(T t);
    T update(Long id);
    T delete(Long id);
}
