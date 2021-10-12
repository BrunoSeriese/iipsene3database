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
    public ArrayList<Question> get(@PathVariable("id") int id){
        //return this.questionDAO.get();
        return null;
    }

    @RequestMapping(value = "/?listId={listId}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Question> getListById(@PathVariable("listId") int listId){
        //return this.questionDAO.getList();
        return null;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<Question> post(){
        //return this.questionDAO.post();
        return null;
    }

    @RequestMapping(value = "/post/?listId={listId}", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<Question> postList(@PathVariable("listId") int listId){
        //return this.questionDAO.postList();
        return null;
    }

    @RequestMapping(value = "/put/?id={id}", method = RequestMethod.PUT)
    @ResponseBody
    public ArrayList<Question> put(@PathVariable("id") int id){
        //return this.questionDAO.put();
        return null;
    }

    @RequestMapping(value = "/delete/?id={id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ArrayList<Question> delete(@PathVariable("id") int id){
        //return this.questionDAO.delete();
        return null;
    }

    @RequestMapping(value = "/delete/?listId={listId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ArrayList<Question> deleteList(@PathVariable("listId") int listId){
        //return this.questionDAO.deleteList();
        return null;
    }

    @RequestMapping(value = "/patch/?listId={listId}", method = RequestMethod.PATCH)
    @ResponseBody
    public ArrayList<Question> patchList(@PathVariable("listId") int listId){
        //return this.questionDAO.patchList();
        return null;
    }
}
