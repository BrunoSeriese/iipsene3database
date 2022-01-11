package nl.hsleiden.iipsene3database.DAO;

import nl.hsleiden.iipsene3database.DAO.Repository.AnswerRepository;
import nl.hsleiden.iipsene3database.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;

public class AnswerDAO {
    @Autowired
    private AnswerRepository answerRepository;

    public void create(Answer answer, Long nodeId) {
        this.answerRepository.create(answer.getId(), answer.getValue(), nodeId);
    }

    public void update(Answer answer) {
        this.answerRepository.update(answer.getId(), answer.getValue());
    }
}
