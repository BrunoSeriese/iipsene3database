package nl.hsleiden.iipsene2database.DAO;

import java.util.ArrayList;

public interface DAO<T> {
    ArrayList<T> getAll();
}
