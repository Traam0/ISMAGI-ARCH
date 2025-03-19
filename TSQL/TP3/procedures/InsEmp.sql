--use TP3A;


CREATE PROC InsEmp
    (@ID INT,
    @Nom NVARCHAR(50),
    @Prenom NVARCHAR(50),
    @Salaire DECIMAL(10,2),
    @DepId INT)
AS
BEGIN

    INSERT INTO Employe
        (EmployeeID, Nom, Prenom, Salaire, DepartmentID, DateEmbauche)
    VALUES
        (@ID, @Nom, @Prenom, @Salaire, @DepId, GETDATE());

END;