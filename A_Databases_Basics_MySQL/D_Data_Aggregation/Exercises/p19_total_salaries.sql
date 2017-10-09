SELECT department_id, SUM(salary) AS 'total_salary'
FROM employees AS e
GROUP BY e.department_id
ORDER BY e.department_id;