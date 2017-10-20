
USE soft_uni;

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value
					(`sum` DECIMAL(20,4), interest_rate DECIMAL(10,4), years INT)
RETURNS DOUBLE(20,2)
BEGIN
	DECLARE result DECIMAL(20,2);
	SET result = `sum` * POW(1 + interest_rate, years);
	RETURN result;
END $$

SELECT ufn_calculate_future_value(1000,0.1,5)