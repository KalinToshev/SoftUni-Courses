SELECT 
COUNT(*) AS `count`
FROM `employees` AS `e`
WHERE `salary` > (
SELECT 
AVG(`e1`.`salary`)
FROM `employees` AS `e1`
);
