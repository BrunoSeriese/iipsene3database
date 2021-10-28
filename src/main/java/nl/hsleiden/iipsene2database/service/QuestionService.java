package nl.hsleiden.iipsene2database.service;

import nl.hsleiden.iipsene2database.DAO.QuestionDAO;
import nl.hsleiden.iipsene2database.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionDAO questionDAO;
    @Autowired
    private AnswerService answerService;

    public List<Question> getAll() {
        List<Question> questions = this.questionDAO.getAll();
        questions.forEach(question -> {
            question.setAnswers(answerService.getAnswers(question.getId()));
        });
        return questions;
    }

    public Question get(Long id) {
        Question question = this.questionDAO.get(id);
        question.setAnswers(answerService.getAnswers(id));
        return question;
    }
}
