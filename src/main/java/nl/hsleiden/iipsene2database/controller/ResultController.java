package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.ResultDAO;
import nl.hsleiden.iipsene2database.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/results")
public class ResultController {
    private final ResultDAO resultDAO;

    @Autowired
    public ResultController(ResultDAO resultDAO){
        this.resultDAO = resultDAO;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ArrayList<Result>> getAll(){
        return new ResponseEntity<>(this.resultDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Result> get(@PathVariable("id") int id){
        return new ResponseEntity<>(this.resultDAO.get(id), HttpStatus.CREATED);
    }

    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity post(){
        this.resultDAO.create();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/put/?id={id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity put(@PathVariable("id") int id){
        this.resultDAO.update(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/?id={id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") int id){
        this.resultDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
