SELECT deposit_group, is_deposit_expired, AVG(deposit_interest)
FROM wizzard_deposits AS w
WHERE w.deposit_start_date > '1985-01-01'
GROUP BY w.deposit_group, w.is_deposit_expired
ORDER BY w.deposit_group DESC,w.is_deposit_expired ASC;