SELECT t.town_id, t.name AS 'town_name', address_text
FROM towns AS t
RIGHT JOIN addresses AS a
ON t.town_id = a.town_id
WHERE t.name = 'San Francisco' OR t.name = 'Sofia' OR t.name = 'Carnation'
ORDER BY t.town_id,a.address_text;