-- TLDR: Mission Count LeaderBoard
-- Query: Soldier mission count leaderboard descending.
SELECT 
    s.id AS soldier_id,
    s.first_name,
    s.last_name,
    COUNT(p.mission_id) AS mission_count
FROM 
    Soldier s
JOIN 
    Participation p ON s.id = p.soldier_id
GROUP BY 
    s.id, s.first_name, s.last_name
ORDER BY 
    mission_count DESC;


-- TLDR: Medal LeaderBoard All
-- Query: Number of medals awarded per soldier.
SELECT s.id, s.first_name, s.last_name, COUNT(m.id) AS medal_count
FROM Soldier s
JOIN Participation p ON s.id = p.soldier_id
JOIN Medal m ON p.id = m.participation_id
GROUP BY s.id, s.first_name, s.last_name;


-- TLDR: Latest mission location squad
-- Query: List out latest mission location and it's soldiers.

-- getting mission location
SELECT * FROM (
    SELECT * FROM Mission ORDER BY start_date DESC
) WHERE ROWNUM = 1;

-- getting soldiers
SELECT 
    s.id AS soldier_id,
    s.first_name,
    s.last_name
FROM 
    Mission m
JOIN 
    Participation p ON m.id = p.mission_id
JOIN 
    Soldier s ON p.soldier_id = s.id
WHERE 
    m.start_date = (
        SELECT MAX(start_date)
        FROM Mission
    );

-- TLDR: Medal + Rank LeaderBoard (min 2 medals) (show first mission - beginning of service)
-- Complex Query: List all soldiers with their rank, first mission (beginning of service), and number of medals, only show those with more than 2 medals, sorted by medal count.
SELECT s.id, s.first_name, s.last_name, r.name AS rank_name, 
       COUNT(m.id) AS total_medals,
       MIN(ms.start_date) AS first_mission
FROM Soldier s
JOIN Rank r ON s.rank_id = r.id
LEFT JOIN Participation p ON s.id = p.soldier_id
LEFT JOIN Mission ms ON p.mission_id = ms.id
LEFT JOIN Medal m ON p.id = m.participation_id
GROUP BY s.id, s.first_name, s.last_name, r.name
HAVING COUNT(m.id) > 2
ORDER BY total_medals DESC;


-- TLDR: Update Rank + Award weapon


-- list out soldier, mission count, rank
SELECT 
    s.id AS soldier_id,
    s.first_name,
    s.last_name,
    COUNT(p.mission_id) AS mission_count,
    r.id AS rank_id,
    r.name AS rank_name
FROM 
    Soldier s
LEFT JOIN 
    Participation p ON s.id = p.soldier_id
LEFT JOIN 
    Rank r ON s.rank_id = r.id
GROUP BY 
    s.id, s.first_name, s.last_name, r.id, r.name
ORDER BY 
    mission_count DESC;
