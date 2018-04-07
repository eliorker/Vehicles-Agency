package Interface;
/**
 * This interface will be implemented only in Motorized Vehicle
 */
public interface NonMotorizedVehicle {
	/**
	 * String representation of the Vehicle's Power Source type ( manual,automatic, semiautomatic..)
	 */
	public String PowerSource();
	
	/**
	 * String representation of the Vehicle's Energetic Score (should be A , B or C)
	 */
	public String EnergeticScore(); 
	
}
