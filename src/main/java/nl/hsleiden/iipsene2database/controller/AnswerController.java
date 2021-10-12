package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.AnswerDAO;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ArrayList<Answer> getAll(){
        //return this.answerDAO.getAll();
        return null;
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Question> get(@PathVariable("id") int id){
        //return this.questionDAO.get();
        return null;
    }

    @RequestMapping(value = "/?questionId={questionId}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Question> getByQuestion(@PathVariable("questionId") int questionId){
        //return this.questionDAO.getByQuestionId();
        return null;
    }

    @RequestMapping(value = "/?id={id}/nextContent", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Question> getNextContentById(@PathVariable("id") int id){
        //return this.questionDAO.getNextContentById();
        return null;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<Question> post(@PathVariable("id") int id){
        //return this.questionDAO.post();
        return null;
    }

    @RequestMapping(value = "/put/?id={id}", method = RequestMethod.PUT)
    @ResponseBody
    public ArrayList<Question> put(@PathVariable("id") int id){
        //return this.questionDAO.put();
        return null;
    }

    @RequestMapping(value = "/delete/?id={id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ArrayList<Question> delete(@PathVariable("id") int id){
        //return this.questionDAO.delete();
        return null;
    }

    @RequestMapping(value = "/patch/?questionId={questionId}", method = RequestMethod.PATCH)
    @ResponseBody
    public ArrayList<Question> patchList(@PathVariable("questionId") int questionId){
        //return this.questionDAO.patchList();
        return null;
    }
}
