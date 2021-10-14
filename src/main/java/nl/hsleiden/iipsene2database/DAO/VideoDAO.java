package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.VideoRepository;
import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class VideoDAO implements DAO<Video> {
    private final VideoRepository videoRepository;

    @Autowired
    public VideoDAO(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> getAll() {
        List<Video> videos = this.videoRepository.findAll();
        videos.removeIf(v -> !Objects.equals(v.getType(), "VIDEO"));
        return videos;
    }

    @Override
    public Video get(Long id) {
        List<Video> videos = this.videoRepository.findAll();
        videos.removeIf(v -> !Objects.equals(v.getId(), id));
        return videos.get(0);
    }

    @Override
    public void create() {
    }

    @Override
    public void update(Long id) {
    }

    @Override
    public void delete(Long id) {
    }
}
