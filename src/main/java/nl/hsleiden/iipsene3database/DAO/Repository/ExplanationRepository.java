package nl.hsleiden.iipsene3database.DAO.Repository;

import nl.hsleiden.iipsene3database.model.Explanation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Handles the queries for the Content with type EXPLANATION.
 * @author Vincent Severin
 */
public interface ExplanationRepository extends JpaRepository<Explanation, Long> {
    /**
     * Gets all the Explanations.
     * @return All Explanations
     * @author Vincent Severin
     */
    @Override
    @NonNull
    @Query(value = "SELECT * FROM content WHERE type = 'EXPLANATION'",
            nativeQuery = true)
    List<Explanation> findAll();

    /**
     * Updates an Explanation.
     * @param id The id of the Explanation
     * @param value The value of the Explanation
     * @author Vincent Severin
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE content SET value = :value WHERE id = :id AND type = 'EXPLANATION'",
            nativeQuery = true)
    void update(@Param("id") Long id,
                       @Param("value") String value);
}
