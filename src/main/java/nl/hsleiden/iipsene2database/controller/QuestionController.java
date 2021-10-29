package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.QuestionDAO;
import nl.hsleiden.iipsene2database.model.Question;
import nl.hsleiden.iipsene2database.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/questions")
public class QuestionController {
    @Autowired
    private QuestionDAO questionDAO;
    @Autowired
    private QuestionService questionService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Question>> getAll(){
        return new ResponseEntity<>(this.questionService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Question> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.questionService.get(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Question> post(@RequestBody Question question){
        return new ResponseEntity<>(this.questionDAO.create(question), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Question> put(@RequestBody Question question){
        this.questionService.update(question);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Question> delete(@RequestBody Question question){
        this.questionDAO.delete(question);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
