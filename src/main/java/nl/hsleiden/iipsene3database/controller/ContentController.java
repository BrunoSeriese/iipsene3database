package nl.hsleiden.iipsene3database.controller;

import nl.hsleiden.iipsene3database.model.Answer;
import nl.hsleiden.iipsene3database.model.Content;
import nl.hsleiden.iipsene3database.model.ContentRequest;
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
@CrossOrigin
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
     * @param contentRequests a Content and parentNodeId in a wrapper
     * @author Vincent Severin
     */
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody List<ContentRequest> contentRequests) {
        for(ContentRequest contentRequest : contentRequests) {
            Content content = new Content(contentRequest.getId(), contentRequest.getValue(), contentRequest.getType(), contentRequest.getAnswers());
            this.contentService.create(content, contentRequest.getParentNodeId());
        }
    }

    @PostMapping("/answers")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void postAnswers(@RequestBody List<Content> contents) {
        for(Content content : contents) {
            this.contentService.createAnswers(content);
        }
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

    @DeleteMapping("/all")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteAll() {
        this.contentService.delete();
    }
}
