SELECT DISTINCT c.customer_id,
					CONCAT(c.first_name, ' ',c.last_name) AS full_name,
					ti.price,
					ap.airport_name
FROM customers AS c
JOIN tickets AS ti ON ti.customer_id = c.customer_id
JOIN flights AS f ON f.flight_id = ti.flight_id
JOIN airports AS ap ON ap.airport_id = f.destination_airport_id
WHERE  f.`status` = 'Delayed'
ORDER BY ti.price DESC,c.customer_id
LIMIT 3;