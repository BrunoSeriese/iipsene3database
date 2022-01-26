package nl.hsleiden.iipsene3database.DAO.Repository;

import nl.hsleiden.iipsene3database.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserResultsRepository extends JpaRepository<Result, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_results (result) VALUES (:result)",
            nativeQuery = true)
    void create(@Param("result") String result);

    @Transactional
    @Query(value = "SELECT * FROM user_results WHERE date_added > NOW() - INTERVAL '7 days'",
            nativeQuery = true)
    List<Result> getAllSince7Days();

    @Transactional
    @Query(value = "SELECT * FROM user_results WHERE date_added > NOW() - INTERVAL '30 days'",
            nativeQuery = true)
    List<Result> getAllSince30Days();

    @Transactional
    @Query(value = "SELECT * FROM user_results WHERE date_added > NOW() - INTERVAL '365 days'",
            nativeQuery = true)
    List<Result> getAllSince365Days();
}
