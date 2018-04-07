package Classes;
import Interface.NonMotorizedVehicle;
import Vehicles.AirVehicles;

public class SpyGlider extends AirVehicles implements NonMotorizedVehicle   {

	private String EnergyType;
	private String PowerSourceType;
	
	/**
	 * This constructor a Spy Glider with a specified maxPassengers,maxSpeed,model,
			VehicleUseType ,EnergyType ,PowerSourceType.
	 * @param maxPassengers the max Passengers that can be in the Spy Glider
	 * @param maxSpeed the max speed that the Spy Glider can reach to
	 * @param model The model of the Spy Glider
	 * @param VehicleUseType Spy Glider can be use for military or for civilian use
	 * @param EnergyType The Energy type of the Spy Glider : (can be A, B or C)
	 * @param PowerSourceType The Spy Glider power source type ( manual,automatic, semi-automatic..) 
	 */
	public SpyGlider(int maxPassengers, int maxSpeed, String model, String VehicleUseType,String EnergyType,String PowerSourceType) {
		super(maxPassengers, maxSpeed, model, VehicleUseType);
		this.EnergyType=EnergyType;
		this.PowerSourceType=PowerSourceType;
	}
	
	//Override constructor
	public SpyGlider(String PowerSource) {
		super(1,50, "Classified", "Military");
		this.PowerSourceType = PowerSource;
		this.EnergyType="C";
		
	}
	@Override
	public String PowerSource() {
		return " Power Source : "+this.PowerSourceType+ " ";
		
	}
	@Override
	public String EnergeticScore() {
		return " Energetic Score: "+this.EnergyType+ " ";
	}
	
	@Override
	public String toString() {
		 return "SpyGlider: Model: "+this.getModel()+" traveled: "+this.getKilometraz()+" Km, Max speed of :"+this.getMaxSpeed()+" Mph"+" "
	 +"can carry max of : "+this.getMaxPassengers()+" people , Vehicle Use Type:"+this.getVehicleUseType()+this.PowerSource()+this.EnergeticScore();
	 }
	
	@Override
	public boolean equals(Object other) {
		boolean ans =false;
		if (other instanceof SpyGlider) {
			ans = super.equals(other) && this.EnergyType.equals(((SpyGlider)other).getEnergyType()) && this.PowerSourceType.equals(((SpyGlider)other).getPowerSourceType()) ; 
		}
		return ans;
	}

	/**
	 * @return the energy Type (can be A, B or C)
	 */
	public String getEnergyType() {
		return EnergyType;
	}

	/**
	 * @return the what type of power Source the Spy Glider uses ( manual,automatic, semiautomatic..)
	 */
	public String getPowerSourceType() {
		return PowerSourceType;
	}
}
