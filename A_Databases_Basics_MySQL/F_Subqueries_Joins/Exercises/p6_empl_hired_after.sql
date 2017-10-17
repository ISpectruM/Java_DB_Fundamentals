SELECT e.first_name,e.last_name, e.hire_date,d.name AS dept_name
FROM employees AS e
LEFT JOIN departments AS d ON d.department_id = e.department_id
WHERE DATE(e.hire_date) > '1999-1-1' AND (d.name = "Sales" OR d.name ="Finance")
ORDER BY e.hire_date ASC;