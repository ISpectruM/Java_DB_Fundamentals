USE soft_uni;

DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(string_param VARCHAR(20))
BEGIN
	SELECT t.name
	FROM towns AS t
	WHERE LOWER(t.name) LIKE CONCAT(string_param,'%')
	ORDER BY t.name;
END $$

CALL usp_get_towns_starting_with('b');
