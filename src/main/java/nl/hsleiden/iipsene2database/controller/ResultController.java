package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.ResultDAO;
import nl.hsleiden.iipsene2database.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/results")
public class ResultController {
    @Autowired
    private ResultDAO resultDAO;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Result>> getAll(){
        return new ResponseEntity<>(this.resultDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Result> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.resultDAO.get(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Result> post(@RequestBody Result result){
        return new ResponseEntity<>(this.resultDAO.create(result), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    @ResponseBody
    public ResponseEntity<Result> put(@PathVariable("id") Long id){
        this.resultDAO.update(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Result> delete(@RequestBody Result result){
        this.resultDAO.delete(result);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
