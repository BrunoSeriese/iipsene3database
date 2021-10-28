package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.VideoRepository;
import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VideoDAO implements DAO<Video> {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private AnswerDAO answerDAO;

    @Override
    public List<Video> getAll() {
        return this.videoRepository.findAll();
    }

    @Override
    public Video get(Long id) {
        return this.videoRepository.getById(id);
    }

    @Override
    public Video create(Video video) {
        return this.videoRepository.save(video);
    }

    public Video update(Long id, String value) {
        return this.videoRepository.update(id, value);
    }

    @Override
    public void delete(Video video) {
        this.videoRepository.delete(video);
    }
}
