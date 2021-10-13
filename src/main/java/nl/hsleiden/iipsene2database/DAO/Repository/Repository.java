package nl.hsleiden.iipsene2database.DAO.Repository;

import org.springframework.data.repository.CrudRepository;

public interface Repository<T> extends CrudRepository<T, Long> {
}
