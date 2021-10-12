package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.AnswerDAO;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Content;
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
        return this.answerDAO.getAll();
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.GET)
    @ResponseBody
    public Answer get(@PathVariable("id") int id){
        return this.answerDAO.get(id);
    }

    @RequestMapping(value = "/?questionId={questionId}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Answer> getByQuestion(@PathVariable("questionId") int questionId){
        return this.answerDAO.getByQuestionId(questionId);
    }

    @RequestMapping(value = "/?id={id}/nextContent", method = RequestMethod.GET)
    @ResponseBody
    public Content getNextContentById(@PathVariable("id") int id){
        return this.answerDAO.getNextContentById(id);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public void post(@PathVariable("id") int id){
        this.answerDAO.post();
    }

    @RequestMapping(value = "/put/?id={id}", method = RequestMethod.PUT)
    @ResponseBody
    public void put(@PathVariable("id") int id){
        this.answerDAO.put(id);
    }

    @RequestMapping(value = "/delete/?id={id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") int id){
        this.answerDAO.delete(id);
    }

    @RequestMapping(value = "/patch/?questionId={questionId}", method = RequestMethod.PATCH)
    @ResponseBody
    public void patchList(@PathVariable("questionId") int questionId){
        this.answerDAO.patchList(questionId);
    }
}
