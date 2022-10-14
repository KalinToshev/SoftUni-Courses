SELECT
`g`.`name`,
(
CASE
WHEN `g`.`budget` < 50000 THEN 'Normal budget'
ELSE 'Insufficient budget'
END
) AS 'budget_level',
`t`.`name` AS 'team_name',
`a`.`name`
FROM
`games` AS `g`
LEFT JOIN 
`games_categories` AS `gc` ON `g`.`id` = `gc`.`game_id`
JOIN
`teams` AS `t` ON `g`.`team_id` = `t`.`id`
JOIN
`offices` AS `o` ON `t`.`office_id` = `o`.`id`
JOIN 
`addresses` AS `a` ON `o`.`address_id` = `a`.`id`
WHERE
`g`.`release_date` IS NULL
AND
`gc`.`category_id` IS NULL
ORDER BY
`g`.`name`;
