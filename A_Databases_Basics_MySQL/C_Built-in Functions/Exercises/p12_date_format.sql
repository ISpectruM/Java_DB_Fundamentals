SELECT g.name, DATE_FORMAT(g.`start`,'%Y-%m-%d') AS `start`
FROM games AS g
WHERE YEAR(g.`start`) IN (2011,2012)
ORDER BY g.`start`,g.name
LIMIT 50;