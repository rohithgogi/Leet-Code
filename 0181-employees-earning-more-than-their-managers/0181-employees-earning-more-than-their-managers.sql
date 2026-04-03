# Write your MySQL query statement below
SELECT name AS Employee
FROM Employee e1
WHERE managerId IS NOT NULL
AND salary > (
    SELECT salary
    FROM Employee e2
    WHERE e2.id = e1.managerId
);