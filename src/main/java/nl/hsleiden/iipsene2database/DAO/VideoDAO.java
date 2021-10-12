package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.VideoRepository;
import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class VideoDAO implements DAO<Video> {
    private final VideoRepository videoRepository;

    public VideoDAO(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public ArrayList<Video> getAll() {
        return null;
    }

    public Video get() {
        return null;
    }

    public void post() {
    }

    public void put() {
    }

    public void delete() {
    }
}
