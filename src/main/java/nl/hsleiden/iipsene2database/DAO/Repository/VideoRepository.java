package nl.hsleiden.iipsene2database.DAO.Repository;

import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    @Override
    @Query(value = "SELECT * FROM content WHERE type = 'VIDEO'",
            nativeQuery = true)
    List<Video> findAll();
}
