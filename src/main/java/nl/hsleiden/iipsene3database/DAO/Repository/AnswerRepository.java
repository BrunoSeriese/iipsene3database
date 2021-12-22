package nl.hsleiden.iipsene3database.DAO.Repository;

import nl.hsleiden.iipsene3database.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Handles the queries for the Answer(s)
 * @author Vincent Severin
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    /**
     * Gets everything from Answer current_content_id equals the param.
     * This can be 1 Answer or more.
     * @param currentContentId The id of the content it belongs to.
     * @return All the Answer(s) found that belong to the id
     * @author Vincent Severin
     */
    @Query(value = "SELECT * FROM answer WHERE current_content_id = :currentContentId",
            nativeQuery = true)
    List<Answer> getByCurrentContentId(@Param("currentContentId") Long currentContentId);

    /**
     * Updates an Answer.
     * @param id The id of the Answer
     * @param value The value of the Answer
     * @param currentContentId The id of the content it belongs to
     * @param nextContentId The id of the content it refers to
     * @author Vincent Severin
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE answer SET value = :value, current_content_id = :currentContentId, next_content_id = :nextContentId WHERE id = :id",
            nativeQuery = true)
    void update(@Param("id") Long id,
                  @Param("value") String value,
                  @Param("currentContentId") Long currentContentId,
                  @Param("nextContentId") Long nextContentId);
}
