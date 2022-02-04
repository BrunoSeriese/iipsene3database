package nl.hsleiden.iipsene3database.controller;

import nl.hsleiden.iipsene3database.model.Result;
import nl.hsleiden.iipsene3database.service.UserResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user-results")
@CrossOrigin
public class UserResultsController {
    @Autowired
    private UserResultsService userResultsService;

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Result> getAll() {
        return this.userResultsService.getAll();
    }

    @GetMapping("/past-week")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Result> getAllOfPastWeek() {
        return this.userResultsService.getAllOfPastWeek();
    }

    @GetMapping("/past-month")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Result> getAllOfPastMonth() {
        return this.userResultsService.getAllOfPastMonth();
    }

    @GetMapping("/past-year")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Result> getAllOfPastYear() {
        return this.userResultsService.getAllOfPastYear();
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody String result) {
        this.userResultsService.create(result);
    }
}
