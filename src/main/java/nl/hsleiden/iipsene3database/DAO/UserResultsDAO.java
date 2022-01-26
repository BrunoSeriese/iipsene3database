package nl.hsleiden.iipsene3database.DAO;

import nl.hsleiden.iipsene3database.DAO.Repository.UserResultsRepository;
import nl.hsleiden.iipsene3database.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserResultsDAO {
    @Autowired
    private UserResultsRepository userResultsRepository;

    public List<Result> getAll() {
        return this.userResultsRepository.findAll();
    }

    public List<Result> getAllOfPastWeek() {
        return this.userResultsRepository.getAllSince7Days();
    }

    public List<Result> getAllOfPastMonth() {
        return this.userResultsRepository.getAllSince30Days();
    }

    public List<Result> getAllOfPastYear() {
        return this.userResultsRepository.getAllSince365Days();
    }

    public void create(String result) {
        this.userResultsRepository.create(result);
    }
}
