WITH RECURSIVE tree AS (
	(
		SELECT 1 AS depth, ARRAY[id] AS path, id, parent_node, content_id
		FROM node
		WHERE parent_node IS NULL
	)
	UNION ALL
	(
		SELECT tree.depth + 1, tree.path || node.id, node.id, node.parent_node, node.content_id
		FROM tree
		INNER JOIN node ON tree.id = node.parent_node
	)
)
SELECT content.id AS content_id, content.value AS content_value, content.type AS content_type, array_agg(answer.id) AS answer_ids, array_agg(answer.value) AS answer_values
FROM tree
JOIN path ON tree.id = path.node_id
JOIN content ON tree.content_id = content.id
JOIN answer ON answer_id = answer.id
GROUP BY content.id, content.value, content.type, tree.path
ORDER BY path;