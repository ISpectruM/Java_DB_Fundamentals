SELECT MIN(av.avg_salaries) AS min_average_salary
FROM (SELECT AVG(e1.salary) AS avg_salaries
	FROM employees AS e1
	GROUP BY e1.department_id) AS av;