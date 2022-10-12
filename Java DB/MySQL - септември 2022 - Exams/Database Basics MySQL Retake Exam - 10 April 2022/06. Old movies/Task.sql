SELECT 
`mai`.`id`,
`m`.`title`,
`mai`.`runtime`,
`mai`.`budget`,
`mai`.`release_date`
FROM
`movies_additional_info` AS `mai`
JOIN `movies` AS `m` ON `m`.`movie_info_id` = `mai`.`id`
WHERE YEAR(`mai`.`release_date`) >= 1996 AND YEAR(`mai`.`release_date`) <= 1999
ORDER BY `mai`.`runtime`, `mai`.`id`
LIMIT 20;
