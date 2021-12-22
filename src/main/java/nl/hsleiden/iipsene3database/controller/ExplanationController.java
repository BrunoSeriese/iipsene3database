package nl.hsleiden.iipsene3database.controller;

import nl.hsleiden.iipsene3database.DAO.ExplanationDAO;
import nl.hsleiden.iipsene3database.model.Explanation;
import nl.hsleiden.iipsene3database.service.ExplanationService;
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
@RequestMapping(value = "/explanations")
public class ExplanationController {
    @Autowired
    private ExplanationDAO explanationDAO;
    @Autowired
    private ExplanationService explanationService;

    /**
     * Gets all the Explanations in the Database and returns them.
     * @return All Explanations and the HttpStatus 200
     * @author Vincent Severin
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Explanation>> getAll(){
        return new ResponseEntity<>(this.explanationService.getAll(), HttpStatus.OK);
    }

    /**
     * Gets an Explanation based of the id param out of the Database and returns it.
     * @param id The id of the Explanation
     * @return The Explanation with the id same as that of the id param and the HttpStatus 200
     * @author Vincent Severin
     */
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Explanation> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.explanationService.get(id), HttpStatus.OK);
    }

    /**
     * Creates a new Explanation in the Database.
     * @param explanation an Explanation
     * @return The Explanation created and HttpStatus 201
     * @author Vincent Severin
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Explanation> post(@RequestBody Explanation explanation){
        return new ResponseEntity<>(this.explanationDAO.create(explanation), HttpStatus.CREATED);
    }

    /**
     * Updates an Explanation in the Database.
     * @param explanation an Explanation
     * @return HttpStatus 200
     * @author Vincent Severin
     */
    @PutMapping
    @ResponseBody
    public ResponseEntity<Explanation> put(@RequestBody Explanation explanation){
        this.explanationService.update(explanation);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Deletes an Explanation from the Database.
     * @param explanation an Explanation
     * @return HttpStatus 202
     * @author Vincent Severin
     */
    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Explanation> delete(@RequestBody Explanation explanation){
        this.explanationDAO.delete(explanation);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
