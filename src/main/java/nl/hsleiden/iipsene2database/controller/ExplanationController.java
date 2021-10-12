package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.ExplanationDAO;
import nl.hsleiden.iipsene2database.model.Explanation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ArrayList<Explanation> explanations(){
        return this.explanationDAO.getAll();
    }
}
