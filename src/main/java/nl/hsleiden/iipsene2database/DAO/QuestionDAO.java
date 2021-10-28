package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.QuestionRepository;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class QuestionDAO implements DAO<Question> {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerDAO answerDAO;

    @Override
    public List<Question> getAll() {
        List<Question> questions = this.questionRepository.findAll();
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

    public void deleteList(List<Question> questions) {
    }

    public List<Question> patchList(Long listId) {
        return null;
    }
}
