SELECT COUNT(employee_id) AS higher_salary
FROM employees AS e
WHERE e.salary > (
	SELECT AVG(e1.salary) AS avg_salary
	FROM employees AS e1
	);