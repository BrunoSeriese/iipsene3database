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
        List<Video> videos = this.videoRepository.findAll();
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
    public Video update(Long id) {
        return null;
    }

    @Override
    public void delete(Video video) {
        this.videoRepository.delete(video);
    }
}
