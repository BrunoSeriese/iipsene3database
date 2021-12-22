package nl.hsleiden.iipsene3database.DAO;

import nl.hsleiden.iipsene3database.DAO.Repository.VideoRepository;
import nl.hsleiden.iipsene3database.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The DAO, Data Access Object, that handles all the Video related requests to the Database.
 * @author Vincent Severin
 */
@Component
public class VideoDAO implements DAO<Video> {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private AnswerDAO answerDAO;

    /**
     * Gets all the videos in the Database.
     * @return All Videos
     * @author Vincent Severin
     */
    @Override
    public List<Video> getAll() {
        return this.videoRepository.findAll();
    }

    /**
     * Gets a video based of the id param out of the database.
     * @param id The id of Video it is trying to find
     * @return The Video with the same id as that of the id param
     * @author Vincent Severin
     */
    @Override
    public Video get(Long id) {
        return this.videoRepository.getById(id);
    }

    /**
     * Creates a new video in the Database.
     * @param video a Video
     * @return The Video created
     * @author Vincent Severin
     */
    @Override
    public Video create(Video video) {
        return this.videoRepository.save(video);
    }

    /**
     * Updates a Video in the Database
     * @param id The id of the Video
     * @param value The value of the Video
     * @author Vincent Severin
     */
    public void update(Long id, String value) {
        this.videoRepository.update(id, value);
    }

    /**
     * Deletes a Video from the Database.
     * @param video a Video
     * @author Vincent Severin
     */
    @Override
    public void delete(Video video) {
        this.videoRepository.delete(video);
    }
}
