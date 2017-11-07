SELECT * 
FROM donations.donation 
WHERE charity_id = 2
ORDER BY donation_date DESC
LIMIT 10;