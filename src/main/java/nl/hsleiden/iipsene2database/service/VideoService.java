package nl.hsleiden.iipsene2database.service;

import nl.hsleiden.iipsene2database.DAO.VideoDAO;
import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles the communication between some controller/dao methods.
 * @author Vincent Seviner
 */
@Service
public class VideoService {
    @Autowired
    private VideoDAO videoDAO;
    @Autowired
    private AnswerService answerService;

    public List<Video> getAll() {
        List<Video> videos = this.videoDAO.getAll();
        videos.forEach(video -> {
            video.setAnswer(answerService.getAnswer(video.getId()));
        });
        return videos;
    }

    public Video get(Long id) {
        Video video = this.videoDAO.get(id);
        video.setAnswer(answerService.getAnswer(id));
        return video;
    }

    public void update(Video video) {
        this.videoDAO.update(video.getId(), video.getValue());
    }
}
