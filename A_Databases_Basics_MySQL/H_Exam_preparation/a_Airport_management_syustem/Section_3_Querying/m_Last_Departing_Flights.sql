SELECT *
FROM (SELECT f.flight_id,
				f.departure_time,
				f.arrival_time,
				orig.airport_name AS origin,
				des.airport_name AS destination
		FROM flights AS f
		JOIN airports AS des ON des.airport_id = f.destination_airport_id
		JOIN airports AS orig ON orig.airport_id = f.origin_airport_id
		WHERE  f.`status` = 'Departing'
		ORDER BY departure_time DESC
		LIMIT 5) AS fl
ORDER BY departure_time, flight_id;