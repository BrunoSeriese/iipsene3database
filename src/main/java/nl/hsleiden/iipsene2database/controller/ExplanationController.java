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
        return this.explanationDAO.getAll();
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.GET)
    @ResponseBody
    public Explanation get(@PathVariable("id") int id){
        return this.explanationDAO.get();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public void post(){
        this.explanationDAO.post();
    }

    @RequestMapping(value = "/put/?id={id}", method = RequestMethod.PUT)
    @ResponseBody
    public void put(@PathVariable("id") int id){
        this.explanationDAO.put();
    }

    @RequestMapping(value = "/delete/?id={id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") int id){
        this.explanationDAO.delete();
    }
}
