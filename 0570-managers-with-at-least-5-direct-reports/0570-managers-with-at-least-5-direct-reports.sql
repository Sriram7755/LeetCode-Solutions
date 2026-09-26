SELECT E1.name
FROM Employee E
JOIN Employee E1
    ON E.managerId = E1.id
GROUP BY E1.id, E1.name
HAVING COUNT(*) >= 5;