package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class VideoDAO implements DAO<Video> {

    public VideoDAO() {
    }

    public ArrayList<Video> getAll() {
        return null;
    }

    public Video get(int id) {
        return null;
    }

    public void post() {
    }

    public void put(int id) {
    }

    public void delete(int id) {
    }
}
