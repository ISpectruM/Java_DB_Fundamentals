SELECT DISTINCT c.customer_id, CONCAT(c.first_name, ' ',c.last_name) AS full_name, t.town_name AS home_town
FROM customers AS c
JOIN towns AS t ON t.town_id = c.home_town_id
JOIN tickets AS ti ON ti.customer_id = c.customer_id
JOIN flights AS f ON f.flight_id = ti.flight_id
JOIN airports AS ap ON ap.airport_id = f.origin_airport_id
WHERE  f.`status` = 'Departing' AND ap.town_id = c.home_town_id
ORDER BY c.customer_id;