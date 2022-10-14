SELECT
`c`.`id` AS 'car_id',
`c`.`make`,
`c`.`mileage`,
COUNT(`cour`.`id`) AS 'count_of_courses',
ROUND(AVG(`cour`.`bill`), 2) AS 'avg_bill'
FROM
`cars` AS `c`
LEFT JOIN
`courses` AS `cour` ON `c`.`id` = `cour`.`car_id`
GROUP BY 
`c`.`id`
HAVING
`count_of_courses` != 2
ORDER BY
`count_of_courses` DESC,
`c`.`id`;
