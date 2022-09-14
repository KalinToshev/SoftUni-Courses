ALTER TABLE `products` 
ADD CONSTRAINT `fk_id`
  FOREIGN KEY (`category_id`)
  REFERENCES `categories` (`id`);
