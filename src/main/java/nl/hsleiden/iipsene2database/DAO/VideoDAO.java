package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.VideoRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class VideoDAO implements DAO<Video> {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private AnswerDAO answerDAO;

    @Autowired
    public VideoDAO(VideoRepository videoRepository,
                    AnswerDAO answerDAO) {
        this.videoRepository = videoRepository;
        this.answerDAO = answerDAO;
    }

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

    @Override
    public Video update(Long id) {
        return null;
    }

    @Override
    public void delete(Video video) {
        this.videoRepository.delete(video);
    }
}
