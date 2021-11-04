package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.QuestionDAO;
import nl.hsleiden.iipsene2database.model.Question;
import nl.hsleiden.iipsene2database.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Takes care of mapping request data to the defined request handler method.
 * @author Vincent Severin
 */
@RestController
@RequestMapping(value = "/questions")
public class QuestionController {
    @Autowired
    private QuestionDAO questionDAO;
    @Autowired
    private QuestionService questionService;

    /**
     * Gets all the Questions in the Database and returns them.
     * @return All Questions and the HttpStatus 200
     * @author Vincent Severin
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Question>> getAll(){
        return new ResponseEntity<>(this.questionService.getAll(), HttpStatus.OK);
    }

    /**
     * Gets a Question based of the id param out of the Database and returns it.
     * @param id The id of the Question
     * @return The Question with the id same as that of the id param and the HttpStatus 200
     * @author Vincent Severin
     */
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Question> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.questionService.get(id), HttpStatus.OK);
    }

    /**
     * Creates a new Question in the Database.
     * @param question a Question
     * @return The Question created and HttpStatus 201
     * @author Vincent Severin
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Question> post(@RequestBody Question question){
        return new ResponseEntity<>(this.questionDAO.create(question), HttpStatus.CREATED);
    }

    /**
     * Updates a Question in the Database.
     * @param question a Question
     * @return HttpStatus 200
     * @author Vincent Severin
     */
    @PutMapping
    @ResponseBody
    public ResponseEntity<Question> put(@RequestBody Question question){
        this.questionService.update(question);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Deletes a Question from the Database.
     * @param question a Question
     * @return HttpStatus 202
     * @author Vincent Severin
     */
    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Question> delete(@RequestBody Question question){
        this.questionDAO.delete(question);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
