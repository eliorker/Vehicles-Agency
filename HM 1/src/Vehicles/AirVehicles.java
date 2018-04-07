package Vehicles;

public abstract class AirVehicles extends Vehicles {
	private String VehicleUseType; // military or civilian

	/**
	 * This constructor a Air Vehicles with a specified
	 * maxPassengers,maxSpeed,model,VehicleUseType  
	 * parameters will be explained explicitly in the Derived classes
	 */
	public AirVehicles(int maxPassengers, int maxSpeed, String model, String VehicleUseType) {
		super(maxPassengers, maxSpeed, model);
		this.VehicleUseType = VehicleUseType;
	}
	
	/**
	 * @return String representation for the  Air Vehicle Use Type, military or civilian 
	 */
	public String getVehicleUseType() {
		return this.VehicleUseType;
	}

	
	public void setVehicleUseType(String VehicleUseType) {
		this.VehicleUseType = VehicleUseType;
	}

	@Override
	public boolean equals(Object other) {
		boolean ans = false;
		if (other instanceof AirVehicles) {
			ans = super.equals(other) && this.VehicleUseType.equals(((AirVehicles) other).getVehicleUseType());
		}
		return ans;
	}
	
	public abstract String toString();
}
