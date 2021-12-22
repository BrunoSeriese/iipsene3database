package nl.hsleiden.iipsene3database.DAO;

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

    /**
     * Gets all the ContentNodes in the Database.
     * @return All ContentNodes
     * @author Vincent Severin
     */
    public List<Map<String, Object>> getAll() {
        String sql = "WITH RECURSIVE tree AS (\n" +
                "\t(\n" +
                "\t\tSELECT 1 AS depth, ARRAY[id] AS path, id, parent_node, content_id\n" +
                "\t\tFROM node\n" +
                "\t\tWHERE parent_node IS NULL\n" +
                "\t)\n" +
                "\tUNION ALL\n" +
                "\t(\n" +
                "\t\tSELECT tree.depth + 1, tree.path || node.id, node.id, node.parent_node, node.content_id\n" +
                "\t\tFROM tree\n" +
                "\t\tINNER JOIN node ON tree.id = node.parent_node\n" +
                "\t)\n" +
                ")\n" +
                "SELECT content.id AS content_id, content.value AS content_value, content.type AS content_type, array_agg(answer.id) AS answer_ids, array_agg(answer.value) AS answer_values\n" +
                "FROM tree\n" +
                "JOIN path ON tree.id = path.node_id\n" +
                "JOIN content ON tree.content_id = content.id\n" +
                "JOIN answer ON answer_id = answer.id\n" +
                "GROUP BY content.id, content.value, content.type, tree.path\n" +
                "ORDER BY path;";

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
}
