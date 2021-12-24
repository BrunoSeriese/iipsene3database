package nl.hsleiden.iipsene3database.DAO;

import nl.hsleiden.iipsene3database.model.Content;
import nl.hsleiden.iipsene3database.service.SQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The DAO, Data Access Object, that handles all the ContentNode related requests to the Database.
 * @author Vincent Severin
 */
@Component
public class ContentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SQLService sqlService;

    /**
     * Gets all the Contents in the Database.
     * @return List of ContentMaps
     * @author Vincent Severin
     */
    public List<Map<String, Object>> getAll() {
        String sql = sqlService.getSQLQuery("getAll");

        return jdbcTemplate.query(sql, (resultSet, rowNumber) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("contentId", resultSet.getLong("content_id"));
            map.put("contentValue", resultSet.getString("content_value"));
            map.put("contentType", resultSet.getString("content_type"));
            map.put("answerIds", resultSet.getArray("answer_ids").getArray());
            map.put("answerValues", resultSet.getArray("answer_values").getArray());
            return map;
        });
    }

    /**
     * Creates a new Content in the Database.
     * @param content A Content
     * @param parentContentId The id of the parent content
     * @author Vincent Severin
     */
    public void create(Content content, Long parentContentId) {
        //TODO
        // Create and query a script to create a content.
        String sql = sqlService.getSQLQuery("");
        jdbcTemplate.execute(sql);
    }

    /**
     * Updates a Content in the Database.
     * @param content A Content
     * @author Vincent Severin
     */
    public void update(Content content) {
        //TODO
        // Create and query a script to update a content.
        String sql = sqlService.getSQLQuery("");
        jdbcTemplate.execute(sql);
    }

    /**
     * Deletes a Content from the Database.
     * @param content A Content
     */
    public void delete(Content content) {
        //TODO
        // Create and query a script to delete a content.
        String sql = sqlService.getSQLQuery("");
        jdbcTemplate.execute(sql);
    }
}
