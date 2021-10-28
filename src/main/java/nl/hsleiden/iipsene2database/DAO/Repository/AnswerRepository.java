package nl.hsleiden.iipsene2database.DAO.Repository;

import nl.hsleiden.iipsene2database.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query(value = "SELECT * FROM answer WHERE current_content_id = :currentContentId",
            nativeQuery = true)
    List<Answer> getByCurrentContentId(@Param("currentContentId") Long currentContentId);

    @Query(value = "UPDATE answer SET value = :value, current_content_id = :currentContentId, next_content_id = :nextContentId WHERE id = :id",
            nativeQuery = true)
    Answer update(@Param("id") Long id,
                  @Param("value") String value,
                  @Param("currentContentId") Long currentContentId,
                  @Param("nextContentId") Long nextContentId);
}
