package nl.hsleiden.iipsene2database.DAO.Repository;

import nl.hsleiden.iipsene2database.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Handles the queries of the content with type RESULT
 * @author Vincent Severin
 */
public interface ResultRepository extends JpaRepository<Result, Long> {
    /**
     * Gets all the Results
     * @return All Results
     * @author Vincent Severin
     */
    @Override
    @NonNull
    @Query(value = "SELECT * FROM content WHERE type = 'RESULT'",
            nativeQuery = true)
    List<Result> findAll();

    /**
     * Updates a Result
     * @param id The if of the Result
     * @param value The value of the Result
     * @return The updated Result
     * @author Vincent Severin
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE content SET value = :value WHERE id = :id AND type = 'RESULT'",
            nativeQuery = true)
    Result update(@Param("id") Long id,
                  @Param("value") String value);
}
