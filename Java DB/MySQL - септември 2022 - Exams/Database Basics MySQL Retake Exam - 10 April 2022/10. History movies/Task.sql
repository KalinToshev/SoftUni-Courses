DELIMITER $$

CREATE FUNCTION `udf_actor_history_movies_count`(full_name VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN

DECLARE `history_movies` INT;

SET `history_movies` := (
SELECT count(`ma`.`movie_id`)
FROM `movies_actors` AS `ma`
JOIN `actors` AS `a` ON `ma`.`actor_id` = `a`.`id`
JOIN `genres_movies` AS `gm` ON `gm`.`movie_id` = `ma`.`movie_id`
JOIN `genres` AS `g` ON `gm`.`genre_id` = `g`.`id`
WHERE concat_ws(' ', `a`.`first_name`, `a`.`last_name`) = full_name 
AND 
`g`.`name` = 'History'
GROUP BY `ma`.`actor_id`
);

RETURN `history_movies`;

END $$

DELIMITER ;
