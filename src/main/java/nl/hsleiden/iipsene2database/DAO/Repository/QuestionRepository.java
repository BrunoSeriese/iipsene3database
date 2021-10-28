package nl.hsleiden.iipsene2database.DAO.Repository;

import nl.hsleiden.iipsene2database.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Override
    @Query(value = "SELECT * FROM content WHERE type = 'QUESTION'",
            nativeQuery = true)
    List<Question> findAll();
}
