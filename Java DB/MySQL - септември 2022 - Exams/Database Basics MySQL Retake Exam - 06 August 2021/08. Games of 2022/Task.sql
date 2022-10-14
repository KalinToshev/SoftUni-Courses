SELECT
`g`.`name`,
`g`.`release_date`,
CONCAT(SUBSTR(`g`.`description`, 1, 10), '...') AS 'summary',
(
CASE
WHEN MONTH(`g`.`release_date`) = 1 THEN 'Q1'
WHEN MONTH(`g`.`release_date`) = 2 THEN 'Q1'
WHEN MONTH(`g`.`release_date`) = 3 THEN 'Q1'
WHEN MONTH(`g`.`release_date`) = 4 THEN 'Q2'
WHEN MONTH(`g`.`release_date`) = 5 THEN 'Q2'
WHEN MONTH(`g`.`release_date`) = 6 THEN 'Q2'
WHEN MONTH(`g`.`release_date`) = 7 THEN 'Q3'
WHEN MONTH(`g`.`release_date`) = 8 THEN 'Q3'
WHEN MONTH(`g`.`release_date`) = 9 THEN 'Q3'
WHEN MONTH(`g`.`release_date`) = 10 THEN 'Q4'
WHEN MONTH(`g`.`release_date`) = 11 THEN 'Q4'
WHEN MONTH(`g`.`release_date`) = 12 THEN 'Q4'
ELSE 'Invalid Month!'
END
) AS 'quarter',
`t`.`name` AS 'team_name'
FROM `games` AS `g`
JOIN
`teams` AS `t` ON `g`.`team_id` = `t`.`id`
WHERE
YEAR(`g`.`release_date`) = 2022
AND
(MONTH(`g`.`release_date`) % 2 = 0)
AND
`g`.`name` LIKE '%2'
ORDER BY
`quarter`;
