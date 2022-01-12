package nl.hsleiden.iipsene3database.controller;

import nl.hsleiden.iipsene3database.model.Content;
import nl.hsleiden.iipsene3database.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Takes care of mapping request data to the defined request handler method.
 * @author Vincent Severin
 */
@RestController
@RequestMapping(value = "/contents")
public class ContentController {
    @Autowired
    private ContentService contentService;

    /**
     * Gets all the Content in the Database and returns them in pre-order.
     * @return All Contents and the HttpStatus 200
     * @author Vincent Severin
     */
    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Content> getAll(){
        return this.contentService.getAll();
    }

    /**
     * Creates a new Content in the Database.
     * @param content a Content
     * @param parentNodeId The id of the parent node
     * @return The Content created
     * @author Vincent Severin
     */
    @PostMapping("/{parentNodeId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Content post(@RequestBody Content content, @PathVariable("parentNodeId") Long parentNodeId){
        return this.contentService.create(content, parentNodeId);
    }

    /**
     * Updates a Content in the Database.
     * @param content a Content
     * @author Vincent Severin
     */
    @PutMapping("{parentNodeId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public void put(@RequestBody Content content, @PathVariable("parentNodeId") Long parentNodeId){
        this.contentService.update(content, parentNodeId);
    }

    /**
     * Deletes a Content from the Database.
     * @param content a Content
     * @author Vincent Severin
     */
    @DeleteMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@RequestBody Content content){
        this.contentService.delete(content);
    }
}
