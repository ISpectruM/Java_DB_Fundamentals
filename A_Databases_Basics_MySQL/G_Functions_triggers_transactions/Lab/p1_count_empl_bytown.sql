CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(20))
RETURNS INTEGER
BEGIN
	DECLARE towns_count INTEGER;
	SET towns_count := (SELECT COUNT(e.address_id) AS count
							FROM employees AS e
							JOIN addresses AS a ON a.address_id = e.address_id
							JOIN towns AS t ON t.town_id = a.town_id
							WHERE t.name = town_name);
	RETURN towns_count;
END