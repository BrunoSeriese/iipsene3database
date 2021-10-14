package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.model.Video;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class VideoDAO implements DAO<Video> {

    public VideoDAO() {
    }

    @Override
    public ArrayList<Video> getAll() {
        return null;
    }

    @Override
    public Optional<Video> get(Long id) {
        return null;
    }

    @Override
    public void create() {
    }

    @Override
    public void update(Long id) {
    }

    @Override
    public void delete(Long id) {
    }
}
