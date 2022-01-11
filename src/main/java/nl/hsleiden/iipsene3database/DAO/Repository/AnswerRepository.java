package nl.hsleiden.iipsene3database.DAO.Repository;

import nl.hsleiden.iipsene3database.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    @Modifying
    @Query(value = "INSERT INTO Path VALUES(:nodeId, :answerId);",
            nativeQuery = true)
    void createPath(@Param("nodeId") Long nodeId,
                    @Param("answerId") Integer answerId);

    @Modifying
    @Query(value = "UPDATE Answer SET( id = :id, value = :value) WHERE id = :id;",
            nativeQuery = true)
    void update(@Param("id") Integer id,
                @Param("value") String value);
}
