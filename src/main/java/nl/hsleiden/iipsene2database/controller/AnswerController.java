package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.AnswerDAO;
import nl.hsleiden.iipsene2database.model.Answer;
import nl.hsleiden.iipsene2database.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<Answer>> getAll(){
        return new ResponseEntity<>(this.answerDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Answer get(@PathVariable("id") Long id){
        System.out.println(this.answerDAO.get(id));
        return this.answerDAO.get(id);
    }

    @RequestMapping(value = "/currentContentId/{currentContentId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Answer>> getByCurrentContentId(@PathVariable("currentContentId") Long currentContentId){
        return new ResponseEntity<>(this.answerDAO.getByCurrentContentId(currentContentId), HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}/nextContent", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Content> getNextContentById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.answerDAO.getNextContentById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity post(@PathVariable("id") Long id){
        this.answerDAO.create();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/put/id/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity put(@PathVariable("id") Long id){
        this.answerDAO.update(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/id/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") Long id){
        this.answerDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/patch/contentId/{contentId}", method = RequestMethod.PATCH)
    @ResponseBody
    public ResponseEntity patchList(@PathVariable("contentId") Long contentId){
        this.answerDAO.patchList(contentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
