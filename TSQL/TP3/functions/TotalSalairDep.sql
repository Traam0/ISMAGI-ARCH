-- use TP3A;

CREATE FUNCTION TotalSalairDep (@DepId INT) RETURNS INT
AS BEGIN
    DECLARE @total INT;

    SELECT @total = SUM(E.Salaire)
    FROM Employe E INNER JOIN Departement D ON D.DepartmentID = E.DepartmentID;
    RETURN @total;
END;