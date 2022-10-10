DELIMITER $$

CREATE PROCEDURE `usp_get_holders_with_balance_higher_than`(money DECIMAL(19,4))
BEGIN

SELECT `h`.`first_name`, `h`.`last_name`
FROM `account_holders` as `h`
LEFT JOIN `accounts` as `a` ON `h`.`id` = `a`.`account_holder_id`
GROUP BY `h`.`first_name`, `h`.`last_name`
HAVING SUM(`a`.`balance`) > `money`
ORDER BY `h`.`id`;
    
END $$

DELIMITER ;
