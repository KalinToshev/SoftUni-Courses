DELIMITER $$

CREATE FUNCTION `ufn_count_employees_by_town`(`town_name` VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
DECLARE `emp_count` INT;

SET `emp_count` := (SELECT COUNT(*) FROM `employees` AS `e`
JOIN `addresses` AS `a` ON `a`.`address_id` = `e`.`address_id`
JOIN `towns` AS `t` ON `t`.`town_id` = `a`.`town_id`
WHERE `t`.`name` = `town_name`);
    
RETURN `emp_count`;
END $$

DELIMITER ;
