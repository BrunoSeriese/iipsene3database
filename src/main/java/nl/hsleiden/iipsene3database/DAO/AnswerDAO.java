package nl.hsleiden.iipsene3database.DAO;

import nl.hsleiden.iipsene3database.DAO.Repository.AnswerRepository;
import nl.hsleiden.iipsene3database.DAO.Repository.PathRepository;
import nl.hsleiden.iipsene3database.model.Answer;
import nl.hsleiden.iipsene3database.model.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class AnswerDAO {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private PathRepository pathRepository;

    @Transactional
    public void create(Answer answer, Long nodeId) {
        this.answerRepository.saveAndFlush(answer);
        Path path = new Path(nodeId, answer.getId());
        this.pathRepository.save(path);
    }

    public void update(Answer answer) {
        this.answerRepository.save(answer);
    }

    public void delete() {
        this.answerRepository.deleteAll();
    }
}
