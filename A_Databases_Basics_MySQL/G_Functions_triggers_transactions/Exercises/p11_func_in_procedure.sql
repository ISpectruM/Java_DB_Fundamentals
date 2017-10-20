USE soft_uni;

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value
					(`sum` DECIMAL(20,4), interest_rate DECIMAL(10,4), years INT)
RETURNS DECIMAL(20,4)
BEGIN
	DECLARE result DECIMAL(20,4);
	SET result = `sum` * POW(1 + interest_rate, years);
	RETURN result;
END $$

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, interest_rate DECIMAL(20,4))
BEGIN
	SELECT ac.id AS account_id, ah.first_name, ah.last_name, ac.balance AS current_balance,
				ufn_calculate_future_value(ac.balance,interest_rate,5) AS balance_in_5_years
	FROM account_holders AS ah
	JOIN accounts AS ac ON ac.account_holder_id = ah.id
	WHERE ac.id = account_id;
END $$

CALL usp_calculate_future_value_for_account(1,0.1)