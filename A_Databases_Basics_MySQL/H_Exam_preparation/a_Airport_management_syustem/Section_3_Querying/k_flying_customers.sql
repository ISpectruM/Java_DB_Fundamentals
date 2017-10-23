SELECT DISTINCT c.customer_id, CONCAT(c.first_name, ' ',c.last_name) AS full_name, (2016-YEAR(c.date_of_birth)) AS age
FROM customers AS c
JOIN tickets AS ti ON ti.customer_id = c.customer_id
JOIN flights AS f ON f.flight_id = ti.flight_id
WHERE  f.`status` = 'Departing'
ORDER BY age,c.customer_id;