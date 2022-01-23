package nl.hsleiden.iipsene3database.DAO;

import nl.hsleiden.iipsene3database.DAO.Repository.AnswerRepository;
import nl.hsleiden.iipsene3database.DAO.Repository.PathRepository;
import nl.hsleiden.iipsene3database.model.Answer;
import nl.hsleiden.iipsene3database.model.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnswerDAO {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private PathRepository pathRepository;

    public void create(Answer answer, Long nodeId) {
        this.answerRepository.save(answer);
        this.pathRepository.save(new Path(nodeId, answer.getId()));
    }

    public void update(Answer answer) {
        this.answerRepository.save(answer);
    }

    public void delete() {
        this.answerRepository.deleteAll();
    }
}
