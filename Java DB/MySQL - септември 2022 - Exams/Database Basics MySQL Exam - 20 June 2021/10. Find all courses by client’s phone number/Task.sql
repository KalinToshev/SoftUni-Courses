DELIMITER $$

CREATE FUNCTION `udf_courses_by_client` (phone_num VARCHAR (20))
RETURNS INT
DETERMINISTIC
BEGIN

DECLARE `number_of_courses` INT;
SET `number_of_courses` := (
SELECT
COUNT(`courses`.`client_id`)
FROM
`clients`
JOIN
`courses` ON `clients`.`id` = `courses`.`client_id`
WHERE
`clients`.`phone_number` = phone_num
);
RETURN `number_of_courses`; 

END $$

DELIMITER ;
