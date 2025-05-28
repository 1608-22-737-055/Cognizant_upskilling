SELECT 
    e.event_id,
    e.title AS event_name,
    COUNT(f.feedback_id) AS feedback_count,
    AVG(f.rating) AS average_rating
FROM 
    Feedback f
JOIN 
    Events e ON f.event_id = e.event_id
GROUP BY 
    e.event_id, e.title
HAVING 
    COUNT(f.feedback_id) >= 10
ORDER BY 
    average_rating DESC;
