DELETE `c`
FROM `clients` AS `c`
LEFT JOIN `courses` AS `cour` ON `c`.`id` = `cour`.`client_id`
WHERE
`cour`.`id` IS NULL
AND
CHAR_LENGTH(`c`.`full_name`) > 3;
