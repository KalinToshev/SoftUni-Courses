SELECT REPLACE(`title`, 'The', '***') AS `Summary`
FROM `books`
WHERE SUBSTRING(`title`, 1, 3) = "The";
