SELECT department_id, ROUND(MIN(salary),2) AS 'Min Salary'
FROM employees AS e
GROUP BY e.department_id
HAVING `Min Salary` > 800;