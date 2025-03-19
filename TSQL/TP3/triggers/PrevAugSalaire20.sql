--use TP3A;

CREATE TRIGGER PrevAugSalaire20 ON Employe
INSTEAD OF UPDATE
AS BEGIN

    DECLARE @OldSal DECIMAL(10,2);
    DECLARE @NewSal DECIMAL(10,2);

    SELECT @OldSal = d.Salaire, @NewSal = i.Salaire
    FROM deleted d JOIN inserted i ON i.EmployeeID = d.EmployeeID;

    if(@OldSal + @OldSal * 0.2 > @NewSal) 
	BEGIN
        RAISERROR('Augm bigger than 20%', 16,1);
    END;

    DELETE Departement 
    FROM DELETED D
        INNER JOIN dbo.Departement De ON De.DepartmentID = D.DepartmentID
END;
