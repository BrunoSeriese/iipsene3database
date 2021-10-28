package nl.hsleiden.iipsene2database.DAO.Repository;

import nl.hsleiden.iipsene2database.model.Explanation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExplanationRepository extends JpaRepository<Explanation, Long> {
    @Override
    @Query(value = "SELECT * FROM content WHERE type = 'EXPLANATION'",
            nativeQuery = true)
    List<Explanation> findAll();
}
