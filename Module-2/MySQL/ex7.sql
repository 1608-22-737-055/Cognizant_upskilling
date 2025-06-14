SELECT 
    u.full_name AS user_name,
    u.email,
    e.title AS event_name,
    f.rating,
    f.comments
FROM 
    Feedback f
JOIN 
    Users u ON f.user_id = u.user_id
JOIN 
    Events e ON f.event_id = e.event_id
WHERE 
    f.rating <= 3
ORDER BY 
    f.rating ASC;
