DELIMITER $$

CREATE PROCEDURE `usp_calculate_future_value_for_account`(id INT, rate DECIMAL(19, 4))
BEGIN

SELECT 
`a`.`id` AS 'account_id', 
`ah`.`first_name`, 
`ah`.`last_name`, 
`a`.`balance` AS 'current_balance',
ufn_calculate_future_value(`a`.`balance`, rate, 5) AS 'balance_in_5_years'
FROM `account_holders` AS `ah`
JOIN `accounts` AS `a` ON `ah`.`id` = `a`.`account_holder_id`
WHERE `a`.`id` = id;

END $$

DELIMITER ;
