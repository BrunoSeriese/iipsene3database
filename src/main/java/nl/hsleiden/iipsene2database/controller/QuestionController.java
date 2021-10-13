package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.QuestionDAO;
import nl.hsleiden.iipsene2database.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ArrayList<Question>> getAll(){
        return new ResponseEntity<>(this.questionDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Question> get(@PathVariable("id") int id){
        return new ResponseEntity<>(this.questionDAO.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/?listId={listId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ArrayList<Question>> getListById(@PathVariable("listId") int listId){
        return new ResponseEntity<>(this.questionDAO.getList(listId), HttpStatus.OK);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity post(){
        this.questionDAO.create();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/post/?listId={listId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity postList(@PathVariable("listId") int listId){
        this.questionDAO.postList(listId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/put/?id={id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity put(@PathVariable("id") int id){
        this.questionDAO.update(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/?id={id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") int id){
        this.questionDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/delete/?listId={listId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteList(@PathVariable("listId") int listId){
        this.questionDAO.deleteList(listId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/patch/?listId={listId}", method = RequestMethod.PATCH)
    @ResponseBody
    public ResponseEntity patchList(@PathVariable("listId") int listId){
        this.questionDAO.patchList(listId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
