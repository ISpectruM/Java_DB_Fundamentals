SELECT *
FROM projects
WHERE start_date IS NOT NULL
ORDER BY start_date,name,project_id
LIMIT 10;