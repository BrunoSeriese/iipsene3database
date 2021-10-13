package nl.hsleiden.iipsene2database.DAO.Repository;

import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Explanation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExplanationRepository extends JpaRepository<Explanation, Long> {
}
