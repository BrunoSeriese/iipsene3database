package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.DAO.VideoDAO;
import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    public ArrayList<Video> getAll(){
        return this.videoDAO.getAll();
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.GET)
    @ResponseBody
    public Video get(@PathVariable("id") int id){
        return this.videoDAO.get();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public void post(){
        this.videoDAO.post();
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.PUT)
    @ResponseBody
    public void put(@PathVariable("id") int id){
        this.videoDAO.put();
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") int id){
        this.videoDAO.delete();
    }
}
