package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.ExplanationRepository;
import nl.hsleiden.iipsene2database.model.Explanation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ExplanationDAO implements DAO<Explanation> {
    private final ExplanationRepository explanationRepository;

    @Autowired
    public ExplanationDAO(ExplanationRepository explanationRepository) {
        this.explanationRepository = explanationRepository;
    }

    @Override
    public List<Explanation> getAll() {
        List<Explanation> explanations = this.explanationRepository.findAll();
        explanations.removeIf(e -> !Objects.equals(e.getType(), "EXPLANATION"));
        return explanations;
    }

    @Override
    public Explanation get(Long id) {
        List<Explanation> explanations = this.explanationRepository.findAll();
        explanations.removeIf(e -> !Objects.equals(e.getId(), id));
        return explanations.get(0);
    }

    @Override
    public Explanation create(Explanation explanation) {
        return this.explanationRepository.save(explanation);
    }

    @Override
    public void update(Long id) {
    }

    @Override
    public void delete(Long id) {
    }
}
