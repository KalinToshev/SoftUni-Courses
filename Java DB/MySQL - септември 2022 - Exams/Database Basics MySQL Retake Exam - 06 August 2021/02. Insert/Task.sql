INSERT INTO `games` (`name`, `rating`, `budget`, `team_id`)
(
SELECT
LOWER(REVERSE(SUBSTR(`name`, 2, CHAR_LENGTH(`name`)))),
`id`,
(`leader_id` * 1000),
`id`
FROM `teams`
WHERE `id` BETWEEN 1 AND 9
);
