package Classes;
import Interface.NonMotorizedVehicle;
import Vehicles.AirVehicles;


public class GameGlider extends AirVehicles implements NonMotorizedVehicle {
	private String PowerSourceType;
	private String EnergyType;
	
	
	/**
	 * This constructor a Game Glider with a specified maxPassengers,maxSpeed,model,
			VehicleUseType ,EnergyType ,PowerSourceType.
	 * @param maxPassengers the max Passengers that can be in the Game Glider
	 * @param maxSpeed the max speed that the Game Glider can reach to
	 * @param model The model of the Game Glider
	 * @param VehicleUseType Game Glider can be use for military or for civilian use
	 * @param EnergyType The Energy type of the Game Glider : (can be A, B or C)
	 * @param PowerSourceType The Game Glider power source type ( manual,automatic, semi-automatic..) 
	 */
	public GameGlider(int maxPassengers, int maxSpeed, String model, String VehicleUseType,String EnergyType,String PowerSourceType) {
		super(maxPassengers, maxSpeed, model, VehicleUseType);
		this.EnergyType = EnergyType;
		this.PowerSourceType = PowerSourceType;
	}

	/**
	 * @return the energy Type (can be A, B or C)
	 */
	public String getEnergyType() {
		return EnergyType;
	}

	/**
	 * @return the what type of power Source the Game Glider uses ( manual,automatic, semiautomatic..)
	 */
	public String getPowerSourceType() {
		return PowerSourceType;
	}
	

	//Override constructor
	public GameGlider() {
		super(0, 10 ,"Toy", "Civilian");
		this.EnergyType ="A";
		this.PowerSourceType = "Manual";
	}
	
	@Override
	public String PowerSource() {
		return " Power Source: "+this.PowerSourceType+ " ";
		
	}
	@Override
	public String EnergeticScore() {
		return " Energetic Score: "+this.EnergyType+ " ";
	}
	
	@Override
	public String toString() {
		 return "GameGlider: Model: "+this.getModel()+" traveled: "+this.getKilometraz()+" Km, Max speed of :"+this.getMaxSpeed()+" Mph"+" "
	 +"can carry max of : "+this.getMaxPassengers()+" people , Vehicle Use Type:"+this.getVehicleUseType()+this.PowerSource()+this.EnergeticScore();
	 }
	
	@Override
	public boolean equals(Object other) {
		boolean ans =false;
		if (other instanceof GameGlider) {
			ans = super.equals(other) && this.EnergyType.equals(((GameGlider)other).getEnergyType()) && this.PowerSourceType.equals(((GameGlider)other).getPowerSourceType()) ; 
		}
		return ans;
	}
	
}