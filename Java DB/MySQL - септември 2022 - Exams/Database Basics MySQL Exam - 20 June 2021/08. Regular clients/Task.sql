SELECT
`c`.`full_name`,
COUNT(`cour`.`car_id`) AS 'count_of_cars',
SUM(`cour`.`bill`) AS 'total_sum'
FROM
`clients` AS `c`
JOIN
`courses` AS `cour` ON `c`.`id` = `cour`.`client_id`
GROUP BY
`c`.`id`
HAVING
SUBSTR(`c`.`full_name`, 2, 1) LIKE 'a' AND
`count_of_cars` > 1
ORDER BY
`c`.`full_name`;
