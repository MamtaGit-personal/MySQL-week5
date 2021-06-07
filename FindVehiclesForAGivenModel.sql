DROP PROCEDURE IF EXISTS FindVehiclesForAGivenModel;

DELIMITER //

CREATE PROCEDURE FindVehiclesForAGivenModel(IN theModel varchar(30))
BEGIN
	Select * from vehicles where model = theModel;

END //

DELIMITER ;