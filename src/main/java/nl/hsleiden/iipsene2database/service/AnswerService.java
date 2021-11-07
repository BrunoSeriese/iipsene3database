package nl.hsleiden.iipsene2database.service;

import nl.hsleiden.iipsene2database.DAO.AnswerDAO;
import nl.hsleiden.iipsene2database.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles the communication between some controller/dao methods.
 * @author Vincent Severin
 */
@Service
public class AnswerService {
    @Autowired
    private AnswerDAO answerDAO;

    public Answer getAnswer(Long id) {
        Answer answer;
        try {
            answer = this.answerDAO.getByCurrentContentId(id).get(0);
        } catch(IndexOutOfBoundsException indexOutOfBoundsException) {
            answer = new Answer();
        }
        return answer;
    }

    public List<Answer> getAnswers(Long id) {
        return this.answerDAO.getByCurrentContentId(id);
    }

    public void update(Answer answer) {
        this.answerDAO.update(answer.getId(), answer.getValue(), answer.getCurrentContentId(), answer.getNextContentId());
    }
}
