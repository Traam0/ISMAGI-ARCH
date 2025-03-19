--use TP3A;

CREATE TRIGGER StatUpdate ON Employe
INSTEAD OF DELETE
AS BEGIN
    INSERT INTO Employe
        (EmployeeID, Nom, Prenom, Salaire, DepartmentID, DateEmbauche)
    SELECT d.EmployeeID, d.Nom, d.Prenom, d.Salaire, d.DepartmentID, d.DateEmbauche
    FROM deleted d JOIN Employe E ON E.EmployeeID = d.EmployeeID
END;