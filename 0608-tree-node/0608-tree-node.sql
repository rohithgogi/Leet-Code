# Write your MySQL query statement below
SELECT DISTINCT t.id,
    CASE
        WHEN t.p_id IS NULL THEN 'Root'
        WHEN c.id IS NULL ThEN 'Leaf'
        ELSE 'Inner'
    END AS type
FROM Tree t
LEFT JOIN Tree c
ON t.id=c.p_id;