SELECT c.country_name, MAX(p.elevation) AS highest_peak, MAX(r.`length`) AS longest_river
FROM countries AS c
LEFT JOIN mountains_countries AS mc ON mc.country_code = c.country_code
LEFT JOIN mountains AS m ON m.id = mc.mountain_id
LEFT JOIN peaks AS p ON p.mountain_id = m.id
LEFT JOIN countries_rivers AS cr ON cr.country_code = c.country_code
LEFT JOIN rivers AS r ON r.id = cr.river_id
GROUP BY c.country_name
ORDER BY highest_peak DESC, longest_river DESC, c.country_name
LIMIT 5;