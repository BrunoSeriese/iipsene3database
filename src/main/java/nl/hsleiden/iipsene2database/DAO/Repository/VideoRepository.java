package nl.hsleiden.iipsene2database.DAO.Repository;

import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    @Override
    @NonNull
    @Query(value = "SELECT * FROM content WHERE type = 'VIDEO'",
            nativeQuery = true)
    List<Video> findAll();

    @Query(value = "UPDATE content SET value = :value WHERE id = :id AND type = VIDEO",
            nativeQuery = true)
    Video update(@Param("id") Long id,
                 @Param("value") String value);
}
