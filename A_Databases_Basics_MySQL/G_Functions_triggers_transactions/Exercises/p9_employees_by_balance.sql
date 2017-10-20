USE soft_uni;

DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(value DOUBLE(20,4))
BEGIN
	SELECT ah.first_name, ah.last_name
	FROM account_holders AS ah
	JOIN (SELECT ah.id AS holder_id, SUM(ac.balance) AS total, ac.id AS accid
			FROM account_holders AS ah
			JOIN accounts AS ac ON ac.account_holder_id = ah.id
			GROUP BY ac.account_holder_id) AS id_sum ON id_sum.holder_id = ah.id
	WHERE value < id_sum.total
	ORDER BY id_sum.accid,ah.first_name,ah.last_name;
END $$

CALL usp_get_holders_with_balance_higher_than(7000);


USE soft_uni;

DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(value DOUBLE(20,4))
BEGIN
	SELECT ah.first_name, ah.last_name
	FROM account_holders AS ah
	JOIN accounts AS ac ON ac.account_holder_id = ah.id
    GROUP BY ac.account_holder_id
	HAVING value < SUM(ac.balance)
	ORDER BY ac.id,ah.first_name, ah.last_name;
END $$

CALL usp_get_holders_with_balance_higher_than(7000);
