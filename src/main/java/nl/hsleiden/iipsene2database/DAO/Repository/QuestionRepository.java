package nl.hsleiden.iipsene2database.DAO.Repository;

import nl.hsleiden.iipsene2database.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.util.List;

/**
 * Handles the queries for the Content with type QUESTION.
 * @author Vincent Severin
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
    /**
     * Gets all the Questions
     * @return All Questions
     * @author Vincent Severin
     */
    @Override
    @Null
    @Query(value = "SELECT * FROM content WHERE type = 'QUESTION'",
            nativeQuery = true)
    List<Question> findAll();

    /**
     * Updates a Question
     * @param id The id of the Question
     * @param value The value of the Question
     * @return The updated Question
     * @author Vincent Severin
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE content SET value = :value WHERE id = :id AND type = 'QUESTION'",
            nativeQuery = true)
    Question update(@Param("id") Long id,
                    @Param("value") String value);
}
