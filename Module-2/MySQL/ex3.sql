SELECT 
    u.user_id,
    u.full_name,
    u.email,
    u.city,
    u.registration_date
FROM 
    Users u
LEFT JOIN 
    Registrations r ON u.user_id = r.user_id
WHERE 
    r.registration_date IS NULL OR 
    r.registration_date < DATE_SUB(CURDATE(), INTERVAL 180 DAY);

-- INSERT INTO Users (full_name, email, city, registration_date)
-- VALUES ('Test User', 'testuser@example.com', 'Test City', '2024-12-01');

-- -- No registration entry for this user

