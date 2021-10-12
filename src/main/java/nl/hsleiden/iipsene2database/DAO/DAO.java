package nl.hsleiden.iipsene2database.DAO;

import java.util.ArrayList;

public interface DAO<T> {
    ArrayList<T> getAll();
    T get(int id);
    void post();
    void put(int id);
    void delete(int id);
}
