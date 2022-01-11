package nl.hsleiden.iipsene3database.DAO;

import nl.hsleiden.iipsene3database.DAO.Repository.ContentRepository;
import nl.hsleiden.iipsene3database.DAO.Repository.NodeRepository;
import nl.hsleiden.iipsene3database.model.Content;
import nl.hsleiden.iipsene3database.model.Node;
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
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private NodeRepository nodeRepository;

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
     * @author Vincent Severin
     */
    public Node create(Content content, Long parentNodeId) {
        this.contentRepository.save(content);
        Node node = new Node(content.getId(), parentNodeId);
        this.nodeRepository.save(node);
        return node;
    }

    /**
     * Updates a Content in the Database.
     * @param content A Content
     * @author Vincent Severin
     */
    public void update(Content content) {
        this.contentRepository.update(content.getId(), content.getValue(), content.getType());
    }

    /**
     * Deletes a Content from the Database.
     * @param content A Content
     */
    public void delete(Content content) {
        this.contentRepository.delete(content.getId());
    }
}
