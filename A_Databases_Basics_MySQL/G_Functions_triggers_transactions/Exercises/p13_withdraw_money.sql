USE soft_uni;

DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(50,4))
BEGIN
	START TRANSACTION;
	UPDATE accounts
		SET balance = balance - money_amount
		WHERE id = account_id;

	IF(money_amount < 0) THEN
		ROLLBACK;
	END IF;

	IF((SELECT balance
		FROM accounts
		WHERE id = account_id)
		< 0 )
	THEN ROLLBACK;
	END IF;

	COMMIT;
END $$

CALL usp_withdraw_money(1,10);

SELECT * FROM ACCOUNTS