package application;


public class Application {

	public static void main(String[] args) {
		
		Menu menu = new Menu();
		menu.start();		
	}

}







/*public List<Vehicle> getVehiclesForAGivenModel(String model) throws SQLException {
PreparedStatement ps = connection.prepareStatement(SHOW_VEHICLES_QUERY_FOR_A_MODEL);
ps.setString(1, model);
ResultSet rs = ps.executeQuery(); 
System.out.println("Vehicle DAO -> getVehiclesForAGivenModel():\n--------------");

List<Vehicle> vehicles = new ArrayList<Vehicle>();
while(rs.next()) {
	vehicles.add(new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5)));
}
return vehicles;
}*/