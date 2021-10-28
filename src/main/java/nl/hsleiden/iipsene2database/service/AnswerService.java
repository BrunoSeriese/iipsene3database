package nl.hsleiden.iipsene2database.service;

import nl.hsleiden.iipsene2database.DAO.AnswerDAO;
import nl.hsleiden.iipsene2database.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerDAO answerDAO;

    public Answer getAnswer(Long id) {
        return this.answerDAO.getByCurrentContentId(id).get(0);
    }

    public List<Answer> getAnswers(Long id) {
        return this.answerDAO.getByCurrentContentId(id);
    }
}
