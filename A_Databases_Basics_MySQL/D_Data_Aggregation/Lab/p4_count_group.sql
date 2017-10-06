SELECT COUNT(id) AS 'Count'
FROM products AS p
WHERE p.category_id = 2 AND p.price > 8
GROUP BY p.category_id;