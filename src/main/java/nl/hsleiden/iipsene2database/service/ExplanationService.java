package nl.hsleiden.iipsene2database.service;

import nl.hsleiden.iipsene2database.DAO.ExplanationDAO;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Explanation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles the communication between some controller/dao methods.
 * @author Vincent Severin
 */
@Service
public class ExplanationService {
    @Autowired
    private ExplanationDAO explanationDAO;
    @Autowired
    private AnswerService answerService;

    public List<Explanation> getAll() {
        List<Explanation> explanations = this.explanationDAO.getAll();
        explanations.forEach(explanation -> {
            explanation.setAnswer(answerService.getAnswer(explanation.getId()));
        });
        return explanations;
    }

    public Explanation get(Long id) {
        Explanation explanation = this.explanationDAO.get(id);
        explanation.setAnswer(answerService.getAnswer(id));
        return explanation;
    }

    public void update(Explanation explanation) {
        this.explanationDAO.update(explanation.getId(), explanation.getValue());
    }
}
