USE soft_uni;

CREATE TABLE IF NOT EXISTS `logs`(
	log_id INT PRIMARY KEY AUTO_INCREMENT,
	account_id INT,
	old_sum DECIMAL(50,4),
	new_sum DECIMAL(50,4)
	);

DELIMITER $$
CREATE TRIGGER tp_balance_change
AFTER UPDATE
ON accounts
FOR EACH ROW
BEGIN
	INSERT INTO logs(account_id, old_sum, new_sum)
	VALUES (OLD.id,OLD.balance, NEW.balance);
END $$

CALL usp_transfer_money(1,2,10);

SELECT * FROM `logs`