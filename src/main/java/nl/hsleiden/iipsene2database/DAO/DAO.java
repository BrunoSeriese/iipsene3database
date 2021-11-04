package nl.hsleiden.iipsene2database.DAO;

import java.util.List;

/**
 * Methods all Content DAOs should contain.
 * @param <T> A Content type
 * @author Vincent Severin
 */
public interface DAO<T> {
    /**
     * Gets all Things from the Database.
     * @return returns a List of Things
     * @author Vincent Severin
     */
    List<T> getAll();

    /**
     * Gets a Thing from the Database based on the id.
     * @param id The id of Thing it is trying to find
     * @return The Thing with the same id as the id param
     * @author Vincent Severin
     */
    T get(Long id);

    /**
     * Creates a Thing in the Database.
     * @param t The Thing that will be created
     * @return The Thing that has been created
     * @author Vincent Severin
     */
    T create(T t);

    /**
     * Deletes a Thing from the Database.
     * @param t The Thing that will be deleted
     * @author Vincent Severin
     */
    void delete(T t);
}
