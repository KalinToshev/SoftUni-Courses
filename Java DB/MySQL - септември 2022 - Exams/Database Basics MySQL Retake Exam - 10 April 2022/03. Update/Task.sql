UPDATE `movies_additional_info` AS `m`
SET `m`.`runtime` = `m`.`runtime` - 10
WHERE `m`.`id` >= 15 AND `m`.`id` <= 25;
