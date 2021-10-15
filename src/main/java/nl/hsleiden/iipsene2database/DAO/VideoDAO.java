package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.VideoRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class VideoDAO implements DAO<Video> {
    private final VideoRepository videoRepository;
    private final AnswerDAO answerDAO;

    @Autowired
    public VideoDAO(VideoRepository videoRepository,
                    AnswerDAO answerDAO) {
        this.videoRepository = videoRepository;
        this.answerDAO = answerDAO;
    }

    @Override
    public List<Video> getAll() {
        List<Video> videos = this.videoRepository.findAll();
        videos.removeIf(v -> !Objects.equals(v.getType(), "VIDEO"));
        videos.forEach(v -> {
            Answer answer;
            try {
                answer = this.answerDAO.getByCurrentContentId(v.getId()).get(0);
            } catch(IndexOutOfBoundsException indexOutOfBoundsException) {
                answer = new Answer();
            }
            v.setAnswer(answer);
        });
        return videos;
    }

    @Override
    public Video get(Long id) {
        Video video = this.videoRepository.getById(id);
        Answer answer;
        try {
            answer = this.answerDAO.getByCurrentContentId(video.getId()).get(0);
        } catch(IndexOutOfBoundsException indexOutOfBoundsException) {
            answer = new Answer();
        }
        video.setAnswer(answer);
        return video;
    }

    @Override
    public Video create(Video video) {
        return this.videoRepository.save(video);
    }

    @Override
    public void update(Long id) {
    }

    @Override
    public void delete(Long id) {
    }
}
