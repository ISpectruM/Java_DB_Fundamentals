CREATE FUNCTION ufn_get_salary_level (salary DOUBLE(10,4))
RETURNS VARCHAR(10)
BEGIN
	DECLARE salary_level VARCHAR(10);
	IF (salary < 30000) THEN SET salary_level = 'Low';
	ELSEIF (salary <= 50000) THEN SET salary_level = 'Average';
	ELSE SET salary_level = 'High';
	END IF;
	RETURN salary_level;
END;

CREATE PROCEDURE usp_get_employees_by_salary_level (salary_level VARCHAR(10))
BEGIN
	SELECT e.first_name,e.last_name
	FROM employees AS e
	WHERE LOWER(ufn_get_salary_level(e.salary)) = LOWER(salary_level)
	ORDER BY e.first_name DESC,e.last_name DESC;
END