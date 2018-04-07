package Classes;
import Interface.CommercialUse;
import Interface.MotorizedVehicle;
import Vehicles.LandVehicles;


public class Jeep extends LandVehicles implements CommercialUse, MotorizedVehicle {

	private int EngineLife;
	private float AverageFuelConsumption;

	/**
	 * This constructor a Jeep with a specified maxPassengers,maxSpeed,model,
			numberOfWheels ,roadType ,AverageFuelConsumption,EngineLife.
	 * @param maxPassengers the max Passengers that can be in the Jeep
	 * @param maxSpeed the max speed that the Jeep can reach to
	 * @param model The model of the Jeep
	 * @param numberOfWheels How many wheels the Jeep contains
	 * @param roadType In what road the jeep can drive : Paved or dirt
	 * @param AverageFuelConsumption the Average Fuel Consumption of the Jeep
	 * @param EngineLife the expected Engine Life in years  
	 */
	public Jeep( int maxPassengers, int maxSpeed, String model, int numberOfWheels,
			 String roadType,float AverageFuelConsumption, int EngineLife) {
		super( maxPassengers, maxSpeed, model, numberOfWheels,roadType);
		this.AverageFuelConsumption = AverageFuelConsumption;
		this.EngineLife = EngineLife;
	}
	
	/**
	 * @return the Expected engine Life (by years)
	 */
	public int getEngineLife() {
		return EngineLife;
	}

	/**
	 * @return the average Fuel Consumption of the jeep( in L)
	 */
	public float getAverageFuelConsumption() {
		return AverageFuelConsumption;
	}

	//Override constructor
	/**
	 * This constructor a Jeep with a specified : maxSpeed,model 
	 * All the other parameters are by default
	 */
	public Jeep( int maxSpeed, String model, float AverageFuelConsumption, int EngineLife) {
		super(5, maxSpeed, model,4, "dirt");
		this.AverageFuelConsumption = AverageFuelConsumption;
		this.EngineLife = EngineLife;
	}

	@Override
	public String GetAverageFuelConsumption() {
		return "Engine: " + AverageFuelConsumption + "L ";
	}

	@Override
	public String GetExpectedEngineLife() {
		return " lifetime of " + EngineLife + " year ";
	}

	@Override
	public String LicenseType() {
		return " License type: MINI ";
	}

	@Override
	 public String toString() {
		 return "Jeep: Model: "+this.getModel()+" traveled: "+this.getKilometraz()+" Km, Max speed of :"+this.getMaxSpeed()+" Mph"+" "
	 +"can carry max of : "+this.getMaxPassengers()+" people , Number of wheels:"+this.getNumberOfWheels()+ " ,road type: "+this.getRoadType()+", "+this.GetAverageFuelConsumption()+", "+this.GetExpectedEngineLife();
	 }
	@Override
	 public boolean equals(Object other) {
			boolean ans =false;
			if (other instanceof Jeep) {
				ans = super.equals(other) && this.EngineLife== ((Jeep)other).getEngineLife() && this.AverageFuelConsumption ==((Jeep)other).getAverageFuelConsumption() ; 
			}
			return ans;
		}
}
