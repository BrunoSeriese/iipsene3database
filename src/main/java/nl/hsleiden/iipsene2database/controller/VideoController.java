package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.VideoDAO;
import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/videos")
public class VideoController {
    private final VideoDAO videoDAO;

    @Autowired
    public VideoController(VideoDAO videoDAO) {
        this.videoDAO = videoDAO;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Video>> getAll(){
        return new ResponseEntity<>(this.videoDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Video> get(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.videoDAO.get(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Video> post(@RequestBody Video video){
        this.videoDAO.create(video);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Video> put(@PathVariable("id") Long id){
        this.videoDAO.update(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Video> delete(@RequestBody Video video){
        this.videoDAO.delete(video);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
