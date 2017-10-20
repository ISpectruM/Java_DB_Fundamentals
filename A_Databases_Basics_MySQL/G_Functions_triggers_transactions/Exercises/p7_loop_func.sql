USE soft_uni;

DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
RETURNS BIT
BEGIN
	DECLARE i INT;
	DECLARE curr_letter CHAR(1);
	DECLARE result BIT;
	SET i = 1;
	SET result = 0;

	loop_label: LOOP
        IF(i <= CHAR_LENGTH(word)) THEN
            SET curr_letter = SUBSTRING(word,i,1);

            IF(LOCATE(LOWER(curr_letter),LOWER(set_of_letters)) > 0)
            THEN
                SET result = 1;
                SET i = i + 1;
                ITERATE loop_label;
            ELSE
                SET result = 0;
                LEAVE loop_label;
            END IF;
        ELSE LEAVE loop_label;
        END IF;
	END LOOP;
	RETURN result;
END $$

SELECT ufn_is_word_comprised('oistmiahf', 'Sofia');
