--use TP3A;

CREATE PROC EmpSalAugment(@Taux DECIMAL(3,2),
    @DepID INT)
AS
BEGIN
    UPDATE Employe SET Salaire = Salaire +  Salaire * @Taux WHERE DepartmentID = @DepID;
END;
