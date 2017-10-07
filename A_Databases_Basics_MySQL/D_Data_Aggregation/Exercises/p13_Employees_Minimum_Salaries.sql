SELECT department_id, MIN(salary) AS 'minimum_salary'
FROM employees AS e
WHERE e.department_id IN(2,5,7) AND e.hire_date > '2000-01-01'
GROUP BY e.department_id;