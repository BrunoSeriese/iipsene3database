package nl.hsleiden.iipsene3database.DAO.Repository;

import nl.hsleiden.iipsene3database.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

public interface ContentRepository extends JpaRepository<Content, Long> {
    @Query(value =  "INSERT INTO Content VALUES(:contentId, :contentValue, :contentType);",
            nativeQuery = true)
    void create(@Param("id") Long id,
                @Param("value") String value,
                @Param("type") String type);
}
