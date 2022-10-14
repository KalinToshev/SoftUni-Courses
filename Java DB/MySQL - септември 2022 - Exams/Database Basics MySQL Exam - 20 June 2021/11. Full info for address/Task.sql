DELIMITER $$

CREATE PROCEDURE `udp_courses_by_address` (address_name VARCHAR(100))
BEGIN

SELECT
`addresses`.`name`,
`clients`.`full_name`,
(
CASE
WHEN `courses`.`bill` <= 20 THEN 'Low'
WHEN `courses`.`bill` <= 30 THEN 'Medium'
ELSE 'High'
END
) AS 'level_of_bill',
`cars`.`make`,
`cars`.`condition`,
`categories`.`name`
FROM
`addresses`
JOIN
`courses` ON `courses`.`from_address_id` = `addresses`.`id`
JOIN
`clients` ON `courses`.`client_id` = `clients`.`id`
JOIN
`cars` ON `courses`.`car_id` = `cars`.`id`
JOIN
`categories` ON `categories`.`id` = `cars`.`category_id`
WHERE
`addresses`.`name` = address_name
ORDER BY
`cars`.`make`,
`clients`.`full_name`;

END $$

DELIMITER ;
