ALTER TABLE `minions`
ADD COLUMN `town_id` INT,
ADD FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`);
