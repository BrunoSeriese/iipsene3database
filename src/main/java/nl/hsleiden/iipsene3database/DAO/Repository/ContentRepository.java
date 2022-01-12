package nl.hsleiden.iipsene3database.DAO.Repository;

import nl.hsleiden.iipsene3database.model.Content;
import nl.hsleiden.iipsene3database.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContentRepository extends JpaRepository<Content, Long> {

    @Modifying
    @Query(value = "DELETE FROM content WHERE id = :id;",
            nativeQuery = true)
    void delete(@Param("id") Long id);
}
