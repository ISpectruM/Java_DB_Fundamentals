SELECT SUM(w.deposit_amount-
(
	SELECT w1.deposit_amount
	FROM wizzard_deposits AS w1
	WHERE w1.id = w.id + 1
)) AS 'sum_difference'
FROM wizzard_deposits AS w;