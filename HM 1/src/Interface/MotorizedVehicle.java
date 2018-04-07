package Interface;
/**
 * This interface will be implemented only in Motorized Vehicle
 */
public interface MotorizedVehicle {
	/**
	 * String representation of the Vehicle's average fuel consumption (by Liters)
	 */
	public String GetAverageFuelConsumption();
	
	/**
	 * String representation of the Vehicle's Expected Engine Life (by years)
	 */
	public String GetExpectedEngineLife() ;

}
