package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.ResultDAO;
import nl.hsleiden.iipsene2database.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ArrayList<Result> getAll(){
        //return this.resultDAO.getAll();
        return null;
    }

    @RequestMapping(value = "?id={id}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Result> get(@PathVariable("id") int id){
        //return this.resultDAO.get();
        return null;
    }

    @RequestMapping(value = "/put/?id={id}", method = RequestMethod.PUT)
    @ResponseBody
    public ArrayList<Result> put(@PathVariable("id") int id){
        //return this.resultDAO.put();
        return null;
    }

    @RequestMapping(value = "/delete/?id={id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ArrayList<Result> delete(@PathVariable("id") int id){
        //return this.resultDAO.delete();
        return null;
    }
}
