SELECT c.customer_id, CONCAT(c.first_name, ' ',c.last_name), (2016-YEAR(c.date_of_birth)) AS age
FROM customers AS c
INNER JOIN tickets AS ti ON ti.customer_id = c.customer_id
INNER JOIN flights AS f ON f.flight_id = ti.flight_id
WHERE f.`status` = 'Arrived'
GROUP BY c.customer_id
HAVING age < 21
ORDER BY age DESC, c.customer_id;