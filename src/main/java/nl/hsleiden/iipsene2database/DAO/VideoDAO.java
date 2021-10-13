package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class VideoDAO implements DAO<Video> {

    public VideoDAO() {
    }

    @Override
    public ArrayList<Video> getAll() {
        return null;
    }

    @Override
    public Video get(int id) {
        return null;
    }

    @Override
    public void post() {
    }

    @Override
    public void put(int id) {
    }

    @Override
    public void delete(int id) {
    }
}
