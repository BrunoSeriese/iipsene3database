package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.ResultDAO;
import nl.hsleiden.iipsene2database.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ArrayList<Result> results(){
        return this.resultDAO.getAll();
    }
}
