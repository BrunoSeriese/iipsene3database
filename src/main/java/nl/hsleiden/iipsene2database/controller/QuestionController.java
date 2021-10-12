package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.QuestionDAO;
import nl.hsleiden.iipsene2database.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/questions")
public class QuestionController {
    private final QuestionDAO questionDAO;

    @Autowired
    public QuestionController(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Question> getAll(){
        return this.questionDAO.getAll();
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.GET)
    @ResponseBody
    public Question get(@PathVariable("id") int id){
        return this.questionDAO.get();
    }

    @RequestMapping(value = "/?listId={listId}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Question> getListById(@PathVariable("listId") int listId){
        return this.questionDAO.getList();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public void post(){
        this.questionDAO.post();
    }

    @RequestMapping(value = "/post/?listId={listId}", method = RequestMethod.POST)
    @ResponseBody
    public void postList(@PathVariable("listId") int listId){
        this.questionDAO.postList();
    }

    @RequestMapping(value = "/put/?id={id}", method = RequestMethod.PUT)
    @ResponseBody
    public void put(@PathVariable("id") int id){
        this.questionDAO.put();
    }

    @RequestMapping(value = "/delete/?id={id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") int id){
        this.questionDAO.delete();
    }

    @RequestMapping(value = "/delete/?listId={listId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteList(@PathVariable("listId") int listId){
        this.questionDAO.deleteList();
    }

    @RequestMapping(value = "/patch/?listId={listId}", method = RequestMethod.PATCH)
    @ResponseBody
    public void patchList(@PathVariable("listId") int listId){
        this.questionDAO.patchList();
    }
}
