package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.VehicleDao;
import entity.Vehicle;

public class Menu {
	
	private VehicleDao vehicleDao = new VehicleDao();
	private Scanner scanner = new Scanner(System.in);
	
	private List<String> options = Arrays.asList(
			"Display Vehicles", 
			"Display Vehicles for a given Model",
			"Insert a Vehicle",
			"Delete a Vehicle",
			"Update an existing Vehicle");
	
	public void start() {
		String selection = "";
				
		do {
			printMenu();
			selection = scanner.nextLine();
			System.out.println("The Selection is: " + selection);
			try {
				if(selection.equals("1")) {
					displayVehicles();
				}
				else if(selection.equals("2")) {
					displayVehiclesForAGivenModel();
				}
				else if(selection.equals("3")) {
					insertVehicles();
				}
				else if(selection.equals("4")) {
					deleteVehicles();
				}
				else if(selection.equals("5")) {
					updateVehicles();
				}
				else break;
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		}while(!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n--------------");
		for(int i = 0; i<options.size(); i++) {
			System.out.println(i+1+ ") " + options.get(i));
			
		}
	}
	
	private void displayVehicles() throws SQLException {
		List<Vehicle> vehicles = vehicleDao.getVehicles();
		for(Vehicle vehicle : vehicles) {
			System.out.println("The id is: " +vehicle.getVehicleId() + ", model is: " + vehicle.getModel() + ", trim is: " 
			+ vehicle.getTrim() + ", price is: " + vehicle.getPrice() + ", status is: " + vehicle.getStatus());
		}
	}
	
	private void displayVehiclesForAGivenModel() throws SQLException {
		System.out.print("Enter model to display vehicles: ");
		String model = scanner.nextLine();
		List<Vehicle> vehicles = vehicleDao.getVehiclesForAGivenModel(model);
		for(Vehicle vehicle : vehicles) {
			System.out.println("The id is: " +vehicle.getVehicleId() + ", model is: " + vehicle.getModel() + ", trim is: " 
			+ vehicle.getTrim() + ", price is: " + vehicle.getPrice() + ", status is: " + vehicle.getStatus());
		}
	}
	
	private void insertVehicles() throws SQLException {
		System.out.print("Enter model to insert: ");
		String model = scanner.nextLine();
		System.out.print("Enter trim to insert: ");
		String trim = scanner.nextLine();
		float price =0;
		if(trim.equals("S")) {
			price = 1200;
		}
		else if(trim.equals("SE")) {
			price = 1500;
		}
		else price = 1700;

		vehicleDao.insertNewVehicle(model, trim, price, "unsold");
	}
	
	private void updateVehicles() throws SQLException {
		displayVehicles();
		System.out.print("Enter id to update: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("To update, enter either 'Sold' or 'unsold' for the status:");
		String status = scanner.nextLine();
		vehicleDao.updateVehicleById(id, status);
		
	}
	
	private void deleteVehicles() throws SQLException  {
		displayVehicles();
		System.out.print("Enter id to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		vehicleDao.deleteVehicleById(id);
			
	}

}

