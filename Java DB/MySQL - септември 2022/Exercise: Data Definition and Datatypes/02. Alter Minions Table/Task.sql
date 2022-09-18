ALTER TABLE `minions` 
ADD COLUMN `town_id` INT,
ADD CONSTRAINT `fk_minions_townId_towns_Id`
  FOREIGN KEY (`town_id`)
  REFERENCES `towns` (`id`);
