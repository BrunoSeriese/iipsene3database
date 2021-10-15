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

    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<Answer>> getAll(){
        return new ResponseEntity<>(this.answerDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Answer> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.answerDAO.get(id), HttpStatus.OK);
    }

    @GetMapping(value = "/currentContentId/{currentContentId}")
    @ResponseBody
    public ResponseEntity<List<Answer>> getByCurrentContentId(@PathVariable("currentContentId") Long currentContentId){
        return new ResponseEntity<>(this.answerDAO.getByCurrentContentId(currentContentId), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/nextContent")
    @ResponseBody
    public ResponseEntity<Content> getNextContentById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.answerDAO.getNextContentById(id), HttpStatus.OK);
    }

    @PostMapping(value = "")
    @ResponseBody
    public ResponseEntity<Answer> post(@RequestBody Answer answer){
        return new ResponseEntity<>(this.answerDAO.create(answer), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Answer> put(@PathVariable("id") Long id){
        this.answerDAO.update(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "")
    @ResponseBody
    public ResponseEntity<Answer> delete(@RequestBody Answer answer){
        this.answerDAO.delete(answer);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PatchMapping(value = "/contentId/{contentId}")
    @ResponseBody
    public ResponseEntity<List<Answer>> patchList(@PathVariable("contentId") Long contentId){
        this.answerDAO.patchList(contentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
