SELECT t.ticket_id, ap.airport_name AS destination, CONCAT(c.first_name, ' ',c.last_name) AS customer_name
FROM tickets AS t
JOIN flights AS f ON f.flight_id = t.flight_id
JOIN airports AS ap ON ap.airport_id = f.destination_airport_id
JOIN customers AS c ON c.customer_id = t.customer_id
WHERE t.price < 5000 AND t.class = 'First'
ORDER BY t.ticket_id;