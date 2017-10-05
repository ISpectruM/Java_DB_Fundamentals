SELECT country_name, iso_code
FROM countries AS c
WHERE c.country_name LIKE '%A%A%A%'
ORDER BY c.iso_code;