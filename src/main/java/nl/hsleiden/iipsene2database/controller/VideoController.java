package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.VideoDAO;
import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value = "/videos")
public class VideoController {
    private final VideoDAO videoDAO;

    @Autowired
    public VideoController(VideoDAO videoDAO) {
        this.videoDAO = videoDAO;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ArrayList<Video>> getAll(){
        return new ResponseEntity<>(this.videoDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Video> get(@PathVariable("id") Long id){
        return this.videoDAO.get(id);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity post(){
        this.videoDAO.create();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity put(@PathVariable("id") Long id){
        this.videoDAO.update(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") Long id){
        this.videoDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
