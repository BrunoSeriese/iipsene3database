package nl.hsleiden.iipsene3database.DAO.Repository;

import nl.hsleiden.iipsene3database.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import javax.transaction.Transactional;
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
     * @author Vincent Severin
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE content SET value = :value WHERE id = :id AND type = 'VIDEO'",
            nativeQuery = true)
    void update(@Param("id") Long id,
                 @Param("value") String value);
}
