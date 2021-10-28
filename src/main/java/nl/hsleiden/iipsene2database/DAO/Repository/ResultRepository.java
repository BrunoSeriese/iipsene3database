package nl.hsleiden.iipsene2database.DAO.Repository;

import nl.hsleiden.iipsene2database.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    @Override
    @Query(value = "SELECT * FROM content WHERE type = 'RESULT'",
            nativeQuery = true)
    List<Result> findAll();

    @Query(value = "UPDATE content SET value = :value WHERE id = :id AND type = RESULT",
            nativeQuery = true)
    Result update(@Param("id") Long id,
                  @Param("value") String value);
}
