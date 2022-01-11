package nl.hsleiden.iipsene3database.DAO.Repository;

import nl.hsleiden.iipsene3database.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Modifying
    @Query(value =  "INSERT INTO Answer VALUES(:id, :value)\n;" +
                    "INSERT INTO Path VALUES(:nodeId, :id);",
            nativeQuery = true)
    void create(@Param("id") Long id,
                @Param("value") String value,
                @Param("nodeId") Long nodeId);
    @Modifying
    @Query(value = "UPDATE Answer SET( id = :id, value = :value) WHERE id = :id;",
            nativeQuery = true)
    void update(@Param("id") Long id,
                @Param("value") String value);
}
