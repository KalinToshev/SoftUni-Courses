SELECT `title`
FROM `books`
WHERE UPPER(SUBSTRING(`title`, 1, 5)) = "HARRY"
ORDER BY `id`;
