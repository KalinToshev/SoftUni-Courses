DELIMITER $$

CREATE PROCEDURE `usp_withdraw_money`(account_id INT, money_amount DOUBLE(19, 4))
BEGIN

START TRANSACTION;
IF(money_amount <= 0 OR (SELECT `balance` FROM `accounts` WHERE `id` = account_id) < money_amount) THEN
ROLLBACK;
ELSE
UPDATE `accounts` AS `ac` SET `ac`.`balance` = `ac`.`balance` - money_amount
WHERE `ac`.`id` = account_id;
END IF;

END $$

DELIMITER ;
