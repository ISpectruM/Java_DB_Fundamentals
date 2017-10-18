SELECT COUNT(c1.country_code) AS country_count
FROM (SELECT c.country_code, mountain_id
	FROM countries AS c
	LEFT JOIN mountains_countries AS mc
	ON mc.country_code = c.country_code
	WHERE mountain_id IS NULL) AS c1;