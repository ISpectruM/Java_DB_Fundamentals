UPDATE tickets AS t
INNER JOIN flights AS f ON f.flight_id = t.flight_id
INNER JOIN airlines AS a ON a.airline_id = f.airline_id
SET price = price*1.5
WHERE a.rating = (SELECT MAX(a.rating)
						FROM airlines);