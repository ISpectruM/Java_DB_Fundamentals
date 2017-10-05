SELECT g.name AS 'game',
IF(HOUR(g.`start`)>=0 AND HOUR(g.`start`)<12,'Morning',
	IF(HOUR(g.`start`)>=12 AND HOUR(g.`start`) < 18,'Afternoon','Evening')) AS 'Part of the Day',
IF(g.duration <= 3,'Extra Short',
	IF(g.duration BETWEEN 4 AND 6,'Short',
		IF(g.duration BETWEEN 7 AND 10, 'Long','Extra Long'))) AS 'Duration'
FROM games AS g;