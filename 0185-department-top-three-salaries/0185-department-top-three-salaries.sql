# Write your MySQL query statement below
SELECT 
d.name AS Department,
e.name AS Employee,
e.salary AS Salary
FROM (
    SELECT 
    name,
    salary,
    departmentId,
    DENSE_RANK() OVER(
        PARTITION BY departmentId
        ORDER BY salary DESC
    ) AS rnk FROM employee
) e JOIN department d ON e.departmentId=d.id
WHERE rnk<=3;


