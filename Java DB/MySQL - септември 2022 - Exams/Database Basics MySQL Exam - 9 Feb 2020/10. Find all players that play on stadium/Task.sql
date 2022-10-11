DELIMITER $$

CREATE FUNCTION `udf_stadium_players_count`(stadium_name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN

RETURN (
SELECT COUNT(*) 
FROM `players` AS `p` 
LEFT JOIN `teams` AS `t` ON `t`.`id` = `p`.`team_id` 
LEFT JOIN `stadiums` AS `s` ON `s`.`id` = `t`.`stadium_id` 
WHERE `s`.`name` = stadium_name
);

END $$

DELIMITER ;
