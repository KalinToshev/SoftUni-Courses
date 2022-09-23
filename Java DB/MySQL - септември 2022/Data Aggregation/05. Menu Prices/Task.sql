SELECT 
`category_id`,
ROUND(AVG(`price`), 2) AS 'Average Price',
ROUND(MIN(`price`), 2) AS 'Cheapest Price',
ROUND(MAX(`price`), 2) AS 'Most Expensive Price'
FROM `products`
GROUP BY `category_id`;
