SELECT e.`id`,
	concat(e.`first_name`, ' ', e.`last_name`) AS `full_name`,
        e.`job_title`,
        e.`salary`
FROM `employees` AS e
WHERE e.`salary` > 1000.00
ORDER BY e.`id`;
