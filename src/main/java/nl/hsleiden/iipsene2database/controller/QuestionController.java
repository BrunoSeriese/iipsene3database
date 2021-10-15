package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.QuestionDAO;
import nl.hsleiden.iipsene2database.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/questions")
public class QuestionController {
    private final QuestionDAO questionDAO;

    @Autowired
    public QuestionController(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<Question>> getAll(){
        return new ResponseEntity<>(this.questionDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Question> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.questionDAO.get(id), HttpStatus.OK);
    }

    @GetMapping(value = "/listId/{listId}")
    @ResponseBody
    public ResponseEntity<List<Question>> getListById(@PathVariable("listId") Long listId){
        return new ResponseEntity<>(this.questionDAO.getList(listId), HttpStatus.OK);
    }

    @PostMapping(value = "")
    @ResponseBody
    public ResponseEntity<Question> post(Question question){
        return new ResponseEntity<>(this.questionDAO.create(question), HttpStatus.CREATED);
    }

    @PostMapping(value = "/listId/{listId}")
    @ResponseBody
    public ResponseEntity postList(@PathVariable("listId") Long listId){
        this.questionDAO.postList(listId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity put(@PathVariable("id") Long id){
        this.questionDAO.update(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") Long id){
        this.questionDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/listId/{listId}")
    @ResponseBody
    public ResponseEntity deleteList(@PathVariable("listId") Long listId){
        this.questionDAO.deleteList(listId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PatchMapping(value = "/listId/{listId}")
    @ResponseBody
    public ResponseEntity patchList(@PathVariable("listId") Long listId){
        this.questionDAO.patchList(listId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
