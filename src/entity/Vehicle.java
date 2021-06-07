package entity;

public class Vehicle {
	private int vehicleId;
	private String model;
	private String trim;
	private float price;
	private String status; 
	
	public Vehicle(int id, String model, String trim, float price, String status) {
		this.setVehicleId(id);
		this.model = model;
		this.trim = trim;
		this.price = price;
		this.setStatus(status);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

}
