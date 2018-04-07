package Vehicles;
public abstract class WaterVehicles extends Vehicles {
	private String WindDirection;
	private String CountryFlag;

	
	/**
	 * This constructor a Water Vehicles with a specified
	 * maxPassengers,maxSpeed,model,windDirection,countryFlag  
	 * parameters will be explained explicitly in the Derived classes
	 */
	public WaterVehicles(int maxPassengers, int maxSpeed, String model, String windDirection, String countryFlag) {
		super(maxPassengers, maxSpeed, model);
		WindDirection = windDirection;
		CountryFlag = countryFlag;
	}

	/**
	 * @return the windDirection // with the wind or against
	 */
	public String getWindDirection() {
		return WindDirection;
	}

	/**
	 * @return String representation of the Vehicle's country Flag
	 */
	public String getCountryFlag() {
		return CountryFlag;
	}

	/**
	 * @param countryFlag which country flag the vehicle carries
	 *   change the current flag to the excepted parameter
	 */
	public void setCountryFlag(String countryFlag) {
		CountryFlag = countryFlag;
	}
	
	@Override
	public boolean equals(Object other) {
		boolean ans =false;
		if (other instanceof WaterVehicles) {
			ans = super.equals(other) && this.CountryFlag.equals(((WaterVehicles)other).getCountryFlag()) &&
					this.WindDirection.equals(((WaterVehicles)other).getWindDirection()) ;
		}
		return ans;

	}
	public abstract String toString();

}
