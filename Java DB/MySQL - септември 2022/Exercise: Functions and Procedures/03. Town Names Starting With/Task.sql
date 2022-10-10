DELIMITER $$

CREATE PROCEDURE `usp_get_towns_starting_with`(start_text VARCHAR(50))
BEGIN 

SELECT `name` FROM `towns`
WHERE `name` LIKE CONCAT(start_text, '%')
ORDER BY `name`;

END $$

DELIMITER ;
