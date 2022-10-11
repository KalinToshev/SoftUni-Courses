INSERT INTO `coaches` (`first_name`, `last_name`, `salary`, `coach_level`)
(SELECT 
`first_name`, 
`last_name`, 
`salary`, 
CHAR_LENGTH(`first_name`)
FROM `players`
WHERE `age` >= 45);
