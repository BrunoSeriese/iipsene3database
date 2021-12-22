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
     * @return All Questions and the HttpStatus 200
     * @author Vincent Severin
     */
    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Content> getAll(){
        return this.contentService.getAll();
    }
}
