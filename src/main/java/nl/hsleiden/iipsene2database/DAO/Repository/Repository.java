package nl.hsleiden.iipsene2database.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository<T> extends JpaRepository<T, Long> {
}
