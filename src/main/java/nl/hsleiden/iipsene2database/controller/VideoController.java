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
        //return this.videoDAO.getAll();
        return null;
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Video> get(@PathVariable("id") int id){
        //return this.videoDAO.get();
        return null;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<Video> post(){
        //return this.videoDAO.post();
        return null;
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.PUT)
    @ResponseBody
    public ArrayList<Video> put(@PathVariable("id") int id){
        //return this.videoDAO.put();
        return null;
    }

    @RequestMapping(value = "/?id={id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ArrayList<Video> delete(@PathVariable("id") int id){
        //return this.videoDAO.delete();
        return null;
    }
}
