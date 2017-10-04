SELECT first_name,last_name
FROM employees
WHERE LOCATE('ei',LOWER(last_name))
ORDER BY employee_id;