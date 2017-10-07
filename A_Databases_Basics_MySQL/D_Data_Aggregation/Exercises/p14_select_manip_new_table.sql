CREATE TABLE `high_paid` AS
SELECT *
FROM employees AS e
WHERE e.salary > 30000;

DELETE FROM high_paid
WHERE manager_id = 42;

UPDATE high_paid
SET salary = salary + 5000
WHERE department_id = 1;

SELECT department_id, AVG(salary) AS 'avg_salary'
FROM high_paid
GROUP BY department_id
ORDER BY department_id;