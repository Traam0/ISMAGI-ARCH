--use TP3A;

CREATE TRIGGER PrevDelFromDep ON Departement  
INSTEAD OF DELETE
AS BEGIN

    if (SELECT 1
    FROM Employe E INNER JOIN deleted D ON d.DepartmentID = E.DepartmentID) = 1
	BEGIN
        RAISERROR('Departement still has employees', 16,1);
        RETURN;
    END;

    DELETE Departement 
    FROM DELETED D
        INNER JOIN dbo.Departement De ON De.DepartmentID = D.DepartmentID
END;
