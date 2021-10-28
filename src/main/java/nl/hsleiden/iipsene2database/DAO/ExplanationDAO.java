package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.ExplanationRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Explanation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ExplanationDAO implements DAO<Explanation> {
    @Autowired
    private ExplanationRepository explanationRepository;
    @Autowired
    private AnswerDAO answerDAO;

    @Override
    public List<Explanation> getAll() {
        return this.explanationRepository.findAll();
    }

    @Override
    public Explanation get(Long id) {
        return this.explanationRepository.getById(id);
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
