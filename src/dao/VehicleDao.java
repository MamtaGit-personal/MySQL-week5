package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Vehicle;

public class VehicleDao {
	private Connection connection;
	private final String SHOW_VEHICLES_QUERY = "SELECT * FROM vehicles";
	private final String DELETE_VEHICLE_BY_ID_QUERY = "DELETE FROM vehicles WHERE id = ?";
	private final String UPDATE_VEHICLE_BY_ID_QUERY = "UPDATE vehicles SET status = ? WHERE id = ?";
	private final String INSERT_NEW_VEHICLE_QUERY = "INSERT INTO vehicles(model, trim, price, status) VALUES(?,?,?,?)";
	private final String CALL_SP_TO_SHOW_VEHICLES_FOR_A_GIVEN_MODEL = "{CALL FindVehiclesForAGivenModel(?)}";
	
	//FindVehiclesForAGivenModel('Jetta');
	
	public VehicleDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Vehicle> getVehicles() throws SQLException {
		ResultSet rs = connection.prepareStatement(SHOW_VEHICLES_QUERY).executeQuery();
		System.out.println("Vehicle DAO -> getVehicles():\n--------------");
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		while(rs.next()) {
			vehicles.add(new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5)));
		}
		return vehicles;
	}
	
	public List<Vehicle> getVehiclesForAGivenModel(String model) throws SQLException {
		CallableStatement stmt = connection.prepareCall(CALL_SP_TO_SHOW_VEHICLES_FOR_A_GIVEN_MODEL);
		stmt.setString(1, model);
		ResultSet rs = stmt.executeQuery(); 
		System.out.println("Vehicle DAO -> getVehiclesForAGivenModel():\n--------------");
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		while(rs.next()) {
			vehicles.add(new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5)));
		}
		return vehicles;
	}
		
	public void insertNewVehicle(String model, String trim, float price, String status) throws SQLException {
		System.out.println("Vehicle DAO -> insertNewVehicle():\n--------------");
		PreparedStatement ps = connection.prepareStatement(INSERT_NEW_VEHICLE_QUERY);
		ps.setString(1, model);
		ps.setString(2, trim);
		ps.setFloat(3, price);  
		ps.setString(4, status);
		ps.executeUpdate();
	}
	
	public void deleteVehicleById(int id) throws SQLException {
		System.out.println("Vehicle DAO -> deleteVehicle():\n--------------");
		PreparedStatement ps = connection.prepareStatement(DELETE_VEHICLE_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updateVehicleById(int id, String status) throws SQLException {
		System.out.println("Vehicle DAO -> updateVehicle():\n--------------");
		PreparedStatement ps = connection.prepareStatement(UPDATE_VEHICLE_BY_ID_QUERY);
		ps.setString(1, status);    
		ps.setInt(2, id);
		ps.executeUpdate();
	}
			
}
