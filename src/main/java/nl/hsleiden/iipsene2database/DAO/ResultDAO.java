package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.ResultRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ResultDAO implements DAO<Result> {
    private final ResultRepository resultRepository;
    private final AnswerDAO answerDAO;

    @Autowired
    public ResultDAO(ResultRepository resultRepository,
                     AnswerDAO answerDAO) {
        this.resultRepository = resultRepository;
        this.answerDAO = answerDAO;
    }

    @Override
    public List<Result> getAll() {
        List<Result> results = this.resultRepository.findAll();
        results.forEach(r -> {
            Answer answer;
            try {
                answer = this.answerDAO.getByCurrentContentId(r.getId()).get(0);
            } catch(IndexOutOfBoundsException indexOutOfBoundsException) {
                answer = new Answer();
            }
            r.setAnswer(answer);
        });
        return results;
    }

    @Override
    public Result get(Long id) {
        Result result = this.resultRepository.getById(id);
        Answer answer;
        try {
            answer = this.answerDAO.getByCurrentContentId(result.getId()).get(0);
        } catch(IndexOutOfBoundsException indexOutOfBoundsException) {
            answer = new Answer();
        }
        result.setAnswer(answer);
        return result;
    }

    @Override
    public Result create(Result result) {
        return this.resultRepository.save(result);
    }

    @Override
    public Result update(Long id) {
        return null;
    }

    @Override
    public void delete(Result result) {
        this.resultRepository.delete(result);
    }
}
