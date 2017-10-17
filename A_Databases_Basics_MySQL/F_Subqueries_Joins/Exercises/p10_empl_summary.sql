SELECT e.employee_id,
	CONCAT(e.first_name,' ',e.last_name),
	CONCAT(e1.first_name,' ',e1.last_name) AS manager_name,
	d.name AS department_name
FROM employees AS e
JOIN employees AS e1 ON e1.employee_id = e.manager_id
JOIN departments AS d ON d.department_id = e.department_id
WHERE e.manager_id IS NOT NULL
ORDER BY e.employee_id
LIMIT 5;