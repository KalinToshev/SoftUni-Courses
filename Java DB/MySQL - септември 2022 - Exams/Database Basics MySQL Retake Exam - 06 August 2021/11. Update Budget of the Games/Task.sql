DELIMITER $$

CREATE PROCEDURE `udp_update_budget`(min_game_rating FLOAT)
BEGIN

UPDATE `games` AS `g`
LEFT JOIN
`games_categories` AS `gc` ON `g`.`id` = `gc`.`game_id`
SET
`g`.`budget` = `g`.`budget` + 100000,
`g`.`release_date` = ADDDATE(`g`.`release_date`, INTERVAL 1 YEAR)
WHERE
`gc`.`category_id` IS NULL
AND
`g`.`rating` > min_game_rating
AND
`g`.`release_date` IS NOT NULL;

END $$

DELIMITER ;
