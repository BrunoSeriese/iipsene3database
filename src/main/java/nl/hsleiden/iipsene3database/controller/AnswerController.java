package nl.hsleiden.iipsene3database.controller;

import nl.hsleiden.iipsene3database.DAO.AnswerDAO;
import nl.hsleiden.iipsene3database.model.Answer;
import nl.hsleiden.iipsene3database.service.AnswerService;
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
@RequestMapping(value = "/answers")
public class AnswerController {
    @Autowired
    private AnswerDAO answerDAO;
    @Autowired
    private AnswerService answerService;

    /**
     * Gets all the Answers in the Database and returns them.
     * @return All Answers and the HttpStatus 200
     * @author Vincent Severin
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Answer>> getAll(){
        return new ResponseEntity<>(this.answerDAO.getAll(), HttpStatus.OK);
    }

    /**
     * Gets an Answer based of the id param out of the Database and returns it.
     * @param id The id of the Answer
     * @return The Answer with the id same as that of the id param and the HttpStatus 200
     * @author Vincent Severin
     */
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Answer> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.answerDAO.get(id), HttpStatus.OK);
    }

    /**
     * Gets all Answer(s) based of the currentContentId param out of the Database and returns them.
     * @param currentContentId The currentContentId of the Answer(s)
     * @return All Answer(s) with the currentContentId same as that of the currentContentId param and the HttpStatus 200
     * @author Vincent Severin
     */
    @GetMapping(value = "/currentContentId/{currentContentId}")
    @ResponseBody
    public ResponseEntity<List<Answer>> getByCurrentContentId(@PathVariable("currentContentId") Long currentContentId){
        return new ResponseEntity<>(this.answerDAO.getByCurrentContentId(currentContentId), HttpStatus.OK);
    }

    /**
     * Creates a new Answer in the Database.
     * @param answer an Answer
     * @return The Answer created and HttpStatus 201
     * @author Vincent Severin
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Answer> post(@RequestBody Answer answer){
        return new ResponseEntity<>(this.answerDAO.create(answer), HttpStatus.CREATED);
    }

    /**
     * Updates an Answer in the Database.
     * @param answer an Answer
     * @return HttpStatus 200
     * @author Vincent Severin
     */
    @PutMapping
    @ResponseBody
    public ResponseEntity<Answer> put(@RequestBody Answer answer){
        this.answerService.update(answer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Deletes an Answer from the Database.
     * @param answer an Answer
     * @return HttpStatus 202
     * @author Vincent Severin
     */
    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Answer> delete(@RequestBody Answer answer){
        this.answerDAO.delete(answer);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
