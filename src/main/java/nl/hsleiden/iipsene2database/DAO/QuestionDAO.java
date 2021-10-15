package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.QuestionRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Question;
import org.jboss.jandex.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class QuestionDAO implements DAO<Question> {
    private final QuestionRepository questionRepository;
    private final AnswerDAO answerDAO;

    @Autowired
    public QuestionDAO(QuestionRepository questionRepository,
                       AnswerDAO answerDAO) {
        this.questionRepository = questionRepository;
        this.answerDAO = answerDAO;
    }

    @Override
    public List<Question> getAll() {
        List<Question> questions = this.questionRepository.findAll();
        questions.removeIf(q -> !Objects.equals(q.getType(), "QUESTION"));
        questions.forEach(q -> {
            List<Answer> answers = new ArrayList<>();
            try {
                answers = this.answerDAO.getByCurrentContentId(q.getId());
            } catch(IndexOutOfBoundsException indexOutOfBoundsException) {
                answers.add(new Answer());
            }
            q.setAnswers(answers);
        });
        return questions;
    }

    @Override
    public Question get(Long id) {
        Question question = this.questionRepository.getById(id);
        List<Answer> answers = new ArrayList<>();
        try {
            answers = this.answerDAO.getByCurrentContentId(question.getId());
        } catch(IndexOutOfBoundsException indexOutOfBoundsException) {
            answers.add(new Answer());
        }
        question.setAnswers(answers);
        return question;
    }

    public List<Question> getList(Long listId) {
        return null;
    }

    @Override
    public Question create(Question question) {
        return this.questionRepository.save(question);
    }

    public List<Question> createList(Long listId) {
        return null;
    }

    @Override
    public Question update(Long id) {
        return null;
    }

    @Override
    public void delete(Question question) {
        this.questionRepository.delete(question);
    }

    public List<Question> deleteList(Long listId) {
        return null;
    }

    public List<Question> patchList(Long listId) {
        return null;
    }
}
