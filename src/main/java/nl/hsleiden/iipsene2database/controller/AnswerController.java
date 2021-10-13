package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.AnswerDAO;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ArrayList<Answer>> getAll(){
        return new ResponseEntity<>(this.answerDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Answer> get(@PathVariable("id") int id){
        return new ResponseEntity<>(this.answerDAO.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/?questionId={questionId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ArrayList<Answer>> getByQuestion(@PathVariable("questionId") int questionId){
        return new ResponseEntity<>(this.answerDAO.getByQuestionId(questionId), HttpStatus.OK);
    }

    @RequestMapping(value = "/?id={id}/nextContent", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Content> getNextContentById(@PathVariable("id") int id){
        return new ResponseEntity<>(this.answerDAO.getNextContentById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity post(@PathVariable("id") int id){
        this.answerDAO.post();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/put/?id={id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity put(@PathVariable("id") int id){
        this.answerDAO.put(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/?id={id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") int id){
        this.answerDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/patch/?questionId={questionId}", method = RequestMethod.PATCH)
    @ResponseBody
    public ResponseEntity patchList(@PathVariable("questionId") int questionId){
        this.answerDAO.patchList(questionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
