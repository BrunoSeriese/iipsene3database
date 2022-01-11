package nl.hsleiden.iipsene3database.DAO.Repository;

import nl.hsleiden.iipsene3database.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NodeRepository extends JpaRepository<Node, Long> {
    @Query(value =  "INSERT INTO Node VALUES(:id,:content_id,:parent_node);",
            nativeQuery = true)
    void create(@Param("id") long id,
                @Param("content_id") long content_id,
                @Param("parent_node") long parent_node);

    @Query(value = "UPDATE Node SET(id = :id, content_id = :content_id, parent_node = :parent_node);",
    nativeQuery = true)
    void update(@Param("id") long id,
                @Param("content_id") long content_id,
                @Param("parent_node") long parent_node);
}
