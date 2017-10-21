USE soft_uni;
CREATE TABLE IF NOT EXISTS `logs`(
	log_id INT PRIMARY KEY AUTO_INCREMENT,
	account_id INT,
	old_sum DECIMAL(50,4),
	new_sum DECIMAL(50,4));

CREATE TABLE IF NOT EXISTS notification_emails(
id INT PRIMARY KEY AUTO_INCREMENT,
recipient INT,
subject VARCHAR(255),
body VARCHAR(255));

DELIMITER $$
CREATE TRIGGER tp_balance_change
AFTER UPDATE
ON accounts
FOR EACH ROW
BEGIN
	INSERT INTO logs(account_id, old_sum, new_sum)
	VALUES (OLD.id,OLD.balance, NEW.balance);
END $$

DELIMITER $$
CREATE TRIGGER tp_balance_change_mail
AFTER INSERT
ON `logs`
FOR EACH ROW
BEGIN
	INSERT INTO notification_emails(recipient,subject,body)
	VALUES (NEW.account_id,
				CONCAT('Balance change for account: ',NEW.account_id),
				CONCAT('On ', NOW(),' your balance was changed from ',NEW.old_sum,' to ',NEW.new_sum,'.'));
END $$

CALL usp_transfer_money(2,1,10);

SELECT * FROM `logs`;
SELECT * FROM `notification_emails`;
SELECT * FROM accounts;