package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.ResultDAO;
import nl.hsleiden.iipsene2database.model.Result;
import nl.hsleiden.iipsene2database.service.ResultService;
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
    @Autowired
    private ResultService resultService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Result>> getAll(){
        return new ResponseEntity<>(this.resultService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Result> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.resultService.get(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Result> post(@RequestBody Result result){
        return new ResponseEntity<>(this.resultDAO.create(result), HttpStatus.OK);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Result> put(@RequestBody Result result){
        this.resultService.update(result);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Result> delete(@RequestBody Result result){
        this.resultDAO.delete(result);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
