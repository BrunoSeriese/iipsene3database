package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.ExplanationRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Explanation;
import org.jboss.jandex.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ExplanationDAO implements DAO<Explanation> {
    private final ExplanationRepository explanationRepository;
    private final AnswerDAO answerDAO;

    @Autowired
    public ExplanationDAO(ExplanationRepository explanationRepository,
                          AnswerDAO answerDAO) {
        this.explanationRepository = explanationRepository;
        this.answerDAO = answerDAO;
    }

    @Override
    public List<Explanation> getAll() {
        List<Explanation> explanations = this.explanationRepository.findAll();
        explanations.removeIf(e -> !Objects.equals(e.getType(), "EXPLANATION"));
        explanations.forEach(e -> {
            Answer answer;
            try {
                answer = this.answerDAO.getByCurrentContentId(e.getId()).get(0);
            } catch(IndexOutOfBoundsException indexOutOfBoundsException) {
                answer = new Answer();
            }
            e.setAnswer(answer);
        });
        return explanations;
    }

    @Override
    public Explanation get(Long id) {
        Explanation explanation = this.explanationRepository.getById(id);
        Answer answer;
        try {
            answer = this.answerDAO.getByCurrentContentId(explanation.getId()).get(0);
        } catch(IndexOutOfBoundsException indexOutOfBoundsException) {
            answer = new Answer();
        }
        explanation.setAnswer(answer);
        return explanation;
    }

    @Override
    public Explanation create(Explanation explanation) {
        return this.explanationRepository.save(explanation);
    }

    @Override
    public Explanation update(Long id) {
        return null;
    }

    @Override
    public void delete(Explanation explanation) {
        this.explanationRepository.delete(explanation);
    }
}
