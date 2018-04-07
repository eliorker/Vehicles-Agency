package Vehicles;

public abstract class Vehicles {
	private int Kilometraz,MaxPassengers,MaxSpeed;
	private String Model;
	
	/**
	 * This constructor Vehicles with a specified
	 * maxPassengers,maxSpeed,model  
	 * parameters will be explained explicitly in the Derived classes
	 */
	public Vehicles( int maxPassengers, int maxSpeed, String model) {
		super();
		Kilometraz = 0; // default by zero
		MaxPassengers = maxPassengers;
		MaxSpeed = maxSpeed;
		Model = model;
	}


	/**
	 * @return Numerical representation , how much KM the Vehicle past (by KM) 
	 */
	public int getKilometraz() {
		return Kilometraz;
	}
	
	/**
	 * Used to update the KM of the Vehicle 
	 * @param moreKilometraz The extra KM that the Vehicle did
	 */
	public void setKilometraz(int moreKilometraz) {
		this.Kilometraz += moreKilometraz;
	}

	/**
	 * @return Max capacity that the Vehicle can carry
	 */
	public int getMaxPassengers() {
		return MaxPassengers;
	}

	/**
	 * @return The top speed that the Vehicle can reach to (by Kmh)
	 */
	public int getMaxSpeed() {
		return MaxSpeed;
	}

	/**
	 * @return String representation for the Vehicle model
	 */
	public String getModel() {
		return Model;
	}
	
	/**
	 * Change all the Vehicle's Kilomertraz to be zero
	 */
	public void ResetKilometraz() {this.Kilometraz=0;}
	
	
	/**
	 * Check if two Vehicles are equals according to the following values: MaxPassengers,MaxSpeed,Model
	 * @param other Can be any object , but will compare values only if the current object and the Parameters are from the same class  
	 * @return True - the chosen values are equals , else - return False
	 */
	public boolean equals(Object other) {
		boolean ans = false;
		if (other instanceof Vehicles) {
			if( this.MaxPassengers== ((Vehicles)other).getMaxPassengers() && this.MaxSpeed== ((Vehicles)other).getMaxSpeed() && this.Model.equals(((Vehicles)other).getModel())) {
				ans=true;
			}
		}
		return ans;
		
	}
	public abstract String toString();
	
}
