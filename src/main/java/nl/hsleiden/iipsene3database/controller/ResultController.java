package nl.hsleiden.iipsene3database.controller;

import nl.hsleiden.iipsene3database.DAO.ResultDAO;
import nl.hsleiden.iipsene3database.model.Result;
import nl.hsleiden.iipsene3database.service.ResultService;
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
@RequestMapping(value = "/results")
public class ResultController {
    @Autowired
    private ResultDAO resultDAO;
    @Autowired
    private ResultService resultService;

    /**
     * Gets all the Result in the Database and returns them.
     * @return All Results and the HttpStatus 200
     * @author Vincent Severin
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Result>> getAll(){
        return new ResponseEntity<>(this.resultService.getAll(), HttpStatus.OK);
    }

    /**
     * Gets a Result based of the id param out of the Database and returns it.
     * @param id The id of the Result
     * @return The Result with the id same as that of the id param and the HttpStatus 200
     * @author Vincent Severin
     */
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Result> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.resultService.get(id), HttpStatus.OK);
    }

    /**
     * Creates a new Result in the Database.
     * @param result a Result
     * @return The Result created and HttpStatus 201
     * @author Vincent Severin
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Result> post(@RequestBody Result result){
        return new ResponseEntity<>(this.resultDAO.create(result), HttpStatus.OK);
    }

    /**
     * Updates a Result in the Database.
     * @param result a Result
     * @return HttpStatus 200
     * @author Vincent Severin
     */
    @PutMapping
    @ResponseBody
    public ResponseEntity<Result> put(@RequestBody Result result){
        this.resultService.update(result);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Deletes a Result from the Database.
     * @param result a Result
     * @return HttpStatus 202
     * @author Vincent Severin
     */
    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Result> delete(@RequestBody Result result){
        this.resultDAO.delete(result);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
