package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.ExplanationDAO;
import nl.hsleiden.iipsene2database.model.Explanation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/explanations")
public class ExplanationController {
    private final ExplanationDAO explanationDAO;

    @Autowired
    public ExplanationController(ExplanationDAO explanationDAO) {
        this.explanationDAO = explanationDAO;
    }

    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<Explanation>> getAll(){
        return new ResponseEntity<>(this.explanationDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}")
    @ResponseBody
    public ResponseEntity<Explanation> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.explanationDAO.get(id), HttpStatus.OK);
    }

    @PostMapping(value = "/post")
    @ResponseBody
    public ResponseEntity<Explanation> post(Explanation explanation){
        return new ResponseEntity<>(this.explanationDAO.create(explanation), HttpStatus.CREATED);
    }

    @PutMapping(value = "/put/id/{id}")
    @ResponseBody
    public ResponseEntity put(@PathVariable("id") Long id){
        this.explanationDAO.update(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/id/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") Long id){
        this.explanationDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
