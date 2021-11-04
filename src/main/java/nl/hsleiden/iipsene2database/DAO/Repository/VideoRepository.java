package nl.hsleiden.iipsene2database.DAO.Repository;

import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * Handles the queries for the Content with type VIDEO
 * @author Vincent Severin
 */
public interface VideoRepository extends JpaRepository<Video, Long> {
    /**
     * Gets all the Videos
     * @return All Videos
     * @author Vincent Severin
     */
    @Override
    @NonNull
    @Query(value = "SELECT * FROM content WHERE type = 'VIDEO'",
            nativeQuery = true)
    List<Video> findAll();

    /**
     * Updates the Video.
     * @param id The id of the Video
     * @param value The value of the Video
     * @return The updated Video
     * @author Vincent Severin
     */
    @Query(value = "UPDATE content SET value = :value WHERE id = :id AND type = VIDEO",
            nativeQuery = true)
    Video update(@Param("id") Long id,
                 @Param("value") String value);
}
