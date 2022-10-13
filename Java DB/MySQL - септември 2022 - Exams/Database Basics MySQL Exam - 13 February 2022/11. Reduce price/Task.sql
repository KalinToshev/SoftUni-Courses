DELIMITER $$

CREATE PROCEDURE `udp_reduce_price`(category_name VARCHAR(50))
BEGIN

UPDATE `products` AS `p`
JOIN `reviews` AS `r` ON `r`.`id` = `p`.`review_id`
JOIN `categories` AS `c` ON `c`.`id` = `p`.`category_id`
SET `p`.`price` = `p`.`price` * 0.70
WHERE `c`.`name` = category_name
AND
`r`.`rating` < 4;

END $$

DELIMITER ;
