package Classes;
import Interface.MotorizedVehicle;
import Vehicles.WaterVehicles;

public class Frigate extends WaterVehicles implements MotorizedVehicle {

	private int EngineLife;
	private float AverageFuelConsumption;

	/**
	 * This constructor a Frigate with a specified maxPassengers,maxSpeed,model,
			windDirection,countryFlag,AverageFuelConsumption,EngineLife
	 * @param maxPassengers the max Passengers that can be in the Frigate
	 * @param maxSpeed the max speed that the Frigate can reach to
	 * @param model The model of the Frigate
	 * @param windDirection The wind Direction of the Frigate
	 * @param countryFlag The country Flag of the Frigate
	 * @param AverageFuelConsumption the Average Fuel Consumption of the Frigate
	 * @param EngineLife the expected engine life of the Frigate
	 */
	public Frigate( int maxPassengers, int maxSpeed, String model,
			String windDirection, String countryFlag, float AverageFuelConsumption, int EngineLife) {
		super( maxPassengers, maxSpeed, model, windDirection, countryFlag);
		this.AverageFuelConsumption = AverageFuelConsumption;
		this.EngineLife = EngineLife;
	} 
	
	//Override constructor
	/**
	 * This constructor a Frigate with a specified maxPassengers,maxSpeed,model,
			windDirection.
			countryFlag,AverageFuelConsumption,EngineLife are default 
	 * @param maxPassengers the max Passengers that can be in the Frigate
	 * @param maxSpeed the max speed that the Frigate can reach to
	 * @param model The model of the Frigate
	 * @param windDirection windDirection The wind Direction of the Frigate , 0- with the wind , 1- against the wind
	 */
	public Frigate( int maxPassengers, int maxSpeed, String model,
			String windDirection) {
		super( maxPassengers, maxSpeed, model, windDirection,"Israel");
		this.AverageFuelConsumption = 500;
		this.EngineLife = 4;
	}

	/**
	 * @return the size of the engine Life expected in years
	 */
	public int getEngineLife() {
		return EngineLife;
	}

	/**
	 * @return the size of the average Fuel Consumption by Liters
	 */
	public float getAverageFuelConsumption() {
		return AverageFuelConsumption;
	}

	@Override 
	public String GetAverageFuelConsumption() {
		return " Engine: " + AverageFuelConsumption + "L ";
	}

	@Override
	public String GetExpectedEngineLife() {
		return " lifetime of " + EngineLife + " year ";
	}

	@Override
	 public String toString() {
		 return "Frigate: Model: "+this.getModel()+" traveled: "+this.getKilometraz()+" Km, Max speed of :"+this.getMaxSpeed()+" Mph"+" "
	 +"can carry max of : "+this.getMaxPassengers()+" people . Under *"+this.getCountryFlag()+"* flag, "+this.getWindDirection()+", "+this.GetAverageFuelConsumption()+", "+this.GetExpectedEngineLife();
	 }
	 
	 
	@Override
	public boolean equals(Object other) {
			boolean ans =false;
			if (other instanceof Frigate) {
				ans = super.equals(other) && this.EngineLife== ((Frigate)other).getEngineLife() && this.AverageFuelConsumption ==((Frigate)other).getAverageFuelConsumption() ; 
			}
			return ans;
		}
}
