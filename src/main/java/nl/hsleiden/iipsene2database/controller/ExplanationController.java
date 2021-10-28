package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.ExplanationDAO;
import nl.hsleiden.iipsene2database.model.Explanation;
import nl.hsleiden.iipsene2database.service.ExplanationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/explanations")
public class ExplanationController {
    @Autowired
    private ExplanationDAO explanationDAO;
    @Autowired
    private ExplanationService explanationService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Explanation>> getAll(){
        return new ResponseEntity<>(this.explanationService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Explanation> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.explanationService.get(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Explanation> post(@RequestBody Explanation explanation){
        return new ResponseEntity<>(this.explanationDAO.create(explanation), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Explanation> put(@PathVariable("id") Long id){
        this.explanationDAO.update(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Explanation> delete(@RequestBody Explanation explanation){
        this.explanationDAO.delete(explanation);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
