USE soft_uni;

DELIMITER $$
CREATE PROCEDURE usp_transfer_money
	(from_account_id INT, to_account_id INT, amount DECIMAL(50,4))
BEGIN
	START TRANSACTION;
		UPDATE accounts
		SET balance = balance - amount
		WHERE id = from_account_id;

		UPDATE accounts
		SET balance = balance + amount
		WHERE id = to_account_id;


	IF(amount < 0) THEN
		ROLLBACK;
	END IF;

	IF(from_account_id NOT IN(SELECT id FROM accounts) OR
	to_account_id NOT IN(SELECT id FROM accounts ))
	THEN ROLLBACK;
	END IF;

	IF((SELECT balance
		FROM accounts
		WHERE id = from_account_id)
		< amount )
	THEN ROLLBACK;
	END IF;

	IF(from_account_id = to_account_id) THEN ROLLBACK;
	END IF;

	COMMIT;
END $$

CALL usp_transfer_money(19,20,10);

SELECT * FROM ACCOUNTS