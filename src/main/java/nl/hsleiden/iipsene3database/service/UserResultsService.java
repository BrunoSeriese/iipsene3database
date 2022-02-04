package nl.hsleiden.iipsene3database.service;

import nl.hsleiden.iipsene3database.DAO.UserResultsDAO;
import nl.hsleiden.iipsene3database.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserResultsService {
    @Autowired
    private UserResultsDAO userResultsDAO;

    public List<Result> getAll() {
        return this.userResultsDAO.getAll();
    }

    public List<Result> getAllOfPastWeek() {
        return this.userResultsDAO.getAllOfPastWeek();
    }

    public List<Result> getAllOfPastMonth() {
        return this.userResultsDAO.getAllOfPastMonth();
    }

    public List<Result> getAllOfPastYear() {
        return this.userResultsDAO.getAllOfPastYear();
    }

    public void create(String result) {
        this.userResultsDAO.create(result);
    }
}
