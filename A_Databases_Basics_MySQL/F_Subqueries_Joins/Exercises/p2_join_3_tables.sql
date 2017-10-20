SELECT first_name,last_name,t.name AS town, a.address_text
FROM employees AS e
JOIN addresses AS a ON e.address_id = a.address_id
JOIN towns AS t ON a.town_id = t.town_id
ORDER BY e.first_name ASC, last_name
LIMIT 5;