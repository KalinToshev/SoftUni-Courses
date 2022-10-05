SELECT 
`e`.`employee_id`,
`e`.`first_name`,
`e`.`manager_id`,
`m`.`first_name`
FROM
`employees` AS `e`,
`employees` AS `m`
WHERE
`e`.`manager_id` = `m`.`employee_id`
AND `e`.`manager_id` IN (3 , 7)
ORDER BY `e`.`first_name`;
