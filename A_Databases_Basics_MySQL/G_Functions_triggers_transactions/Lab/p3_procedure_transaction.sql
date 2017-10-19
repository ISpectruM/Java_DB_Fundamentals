DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(id INTEGER)
BEGIN
	START TRANSACTION;
	IF((SELECT employee_id
		FROM employees AS e
		WHERE e.employee_id = id) IS NOT NULL)
	THEN
		UPDATE employees AS e
		SET e.salary = e.salary*1.05
		WHERE e.employee_id = id;
	ELSE
		ROLLBACK;
	END IF;
END $$

CALL usp_raise_salary_by_id(1)