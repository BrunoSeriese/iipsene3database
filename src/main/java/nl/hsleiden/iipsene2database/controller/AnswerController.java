package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.AnswerDAO;
import nl.hsleiden.iipsene2database.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/answers")
public class AnswerController {
    private final AnswerDAO answerDAO;

    @Autowired
    public AnswerController(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Answer> answers(){
        return this.answerDAO.getAll();
    }
}
