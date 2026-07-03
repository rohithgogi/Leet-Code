# Write your MySQL query statement below
SELECT 
    ROUND(COUNT(Distinct a.player_id)/
    (SELECT COUNT(Distinct player_id) FROM Activity ),2) AS fraction
FROM Activity a 
    JOIN
        (SELECT player_id,MIN(event_date) as login
        FROM Activity
        GROUP BY player_id) AS firstlogin 
ON a.player_id=firstlogin.player_id
AND a.event_date=DATE_ADD(firstlogin.login,INTERVAL 1 DAY);






