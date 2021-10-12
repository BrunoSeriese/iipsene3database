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
    public ArrayList<Question> getQuestions(){
        return this.questionDAO.getAll();
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Question> getQuestionById(@PathVariable("id") int id){
        //return this.questionDAO.getAll();
        return null;
    }

    @RequestMapping(value = "/?listId={listId}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Question> getQuestionListById(@PathVariable("listId") int listId){
        //return this.questionDAO.get();
        return null;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<Question> postQuestion(){
        //return this.questionDAO.post();
        return null;
    }

    @RequestMapping(value = "/post/?listId={listId}", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<Question> postQuestionList(@PathVariable("listId") int listId){
        //return this.questionDAO.postList();
        return null;
    }

    @RequestMapping(value = "/put/?id={id}", method = RequestMethod.PUT)
    @ResponseBody
    public ArrayList<Question> putQuestion(@PathVariable("id") int id){
        //return this.questionDAO.put();
        return null;
    }

    @RequestMapping(value = "/delete/?id={id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ArrayList<Question> deleteQuestion(@PathVariable("id") int id){
        //return this.questionDAO.delete();
        return null;
    }

    @RequestMapping(value = "/delete/?listId={listId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ArrayList<Question> deleteQuestionList(@PathVariable("listId") int listId){
        //return this.questionDAO.deleteList();
        return null;
    }

    @RequestMapping(value = "/patch/?listId={listId}", method = RequestMethod.PATCH)
    @ResponseBody
    public ArrayList<Question> patchQuestionList(@PathVariable("listId") int listId){
        //return this.questionDAO.patchList();
        return null;
    }
}
