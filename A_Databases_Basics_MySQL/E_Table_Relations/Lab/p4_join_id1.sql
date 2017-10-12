SELECT starting_point, end_point, leader_id,
CONCAT(first_name, ' ',last_name) AS leader_name
FROM routes AS v
JOIN campers AS c
ON v.leader_id = c.id;