# Write your MySQL query statement below
SELECT customer_id FROM 
Customer
GROUP BY customer_id
HAVING Count(DISTINCT product_key) = (SELECT count(*)  FROM  Product);