-- use TP3A;

CREATE TRIGGER AuditTrigger ON Employe
AFTER UPDATE
AS BEGIN
    INSERT INTO TP3a.dbo.AuditLog
        (TableName, ColName, OldValue, NewValue)
    SELECT 'Employe', 'Salaire', i.Salaire, d.Salaire
    FROM deleted d JOIN inserted i ON i.EmployeeID = d.EmployeeID
END;
