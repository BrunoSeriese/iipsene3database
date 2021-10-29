package nl.hsleiden.iipsene2database.DAO.Repository;

import nl.hsleiden.iipsene2database.model.Explanation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ExplanationRepository extends JpaRepository<Explanation, Long> {
    @Override
    @NonNull
    @Query(value = "SELECT * FROM content WHERE type = 'EXPLANATION'",
            nativeQuery = true)
    List<Explanation> findAll();

    @Query(value = "UPDATE content SET value = :value WHERE id = :id AND type = EXPLANATION",
            nativeQuery = true)
    Explanation update(@Param("id") Long id,
                       @Param("value") String value);
}
