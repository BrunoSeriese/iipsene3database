package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.VideoDAO;
import nl.hsleiden.iipsene2database.model.Video;
import nl.hsleiden.iipsene2database.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Takes care of mapping request data to the defined request handler method.
 * @author Vincent Severin
 */
@RestController
@RequestMapping(value = "/videos")
public class VideoController {
    @Autowired
    private VideoDAO videoDAO;
    @Autowired
    private VideoService videoService;

    /**
     * Gets all the Videos in the Database and returns them.
     * @return All Videos and the HttpStatus 200
     * @author Vincent Severin
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Video>> getAll(){
        return new ResponseEntity<>(this.videoService.getAll(), HttpStatus.OK);
    }

    /**
     * Gets a Video based of the id param out of the Database and returns it.
     * @param id The id of the Video
     * @return The Video with the id same as that of the id param and the HttpStatus 200
     * @author Vincent Severin
     */
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Video> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.videoService.get(id), HttpStatus.OK);
    }

    /**
     * Creates a new Video in the Database.
     * @param video a Video
     * @return The Video created and HttpStatus 201
     * @author Vincent Severin
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Video> post(@RequestBody Video video){
        this.videoDAO.create(video);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Updates a Video in the Database.
     * @param video a Video
     * @return HttpStatus 200
     * @author Vincent Severin
     */
    @PutMapping
    @ResponseBody
    public ResponseEntity<Video> put(@RequestBody Video video){
        this.videoService.update(video);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Deletes a Video from the Database.
     * @param video a Video
     * @return HttpStatus 202
     * @author Vincent Severin
     */
    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Video> delete(@RequestBody Video video){
        this.videoDAO.delete(video);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
