package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.ExplanationDAO;
import nl.hsleiden.iipsene2database.model.Explanation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/explanations")
public class ExplanationController {
    private final ExplanationDAO explanationDAO;

    @Autowired
    public ExplanationController(ExplanationDAO explanationDAO) {
        this.explanationDAO = explanationDAO;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Explanation> getAll(){
        //return this.explanationDAO.getAll();
        return null;
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Explanation> get(@PathVariable("id") int id){
        //return this.explanationDAO.get();
        return null;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<Explanation> post(){
        //return this.explanationDAO.post();
        return null;
    }

    @RequestMapping(value = "/put/?id={id}", method = RequestMethod.PUT)
    @ResponseBody
    public ArrayList<Explanation> put(@PathVariable("id") int id){
        //return this.explanationDAO.put();
        return null;
    }

    @RequestMapping(value = "/delete/?id={id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ArrayList<Explanation> delete(@PathVariable("id") int id){
        //return this.explanationDAO.delete();
        return null;
    }
}
