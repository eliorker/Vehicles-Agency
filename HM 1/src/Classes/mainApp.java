/**
 * @author Elior Kertsman
 * @ID : 313565095
 * @Campus : Ashdod
 *
 */
package Classes;
import java.util.ArrayList;
import java.util.Scanner;

import Vehicles.*;



public class mainApp {
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// ----------------------------------------------------------
		// Vehicle Agency Program
		// ----------------------------------------------------------
		int selection=0; /// first add Vehicles to the agency
		System.out.println("Welcome to the Vehicle Agency Program\n");
		System.out.println(
				"==================================================================================================\n");
		System.out.println("Add vehicles to your agency :\n");
		ArrayList<Vehicles> obj = new ArrayList<Vehicles>();
		Execute2(selection,obj); /// add vehicles to agency outside the loop 
		while (selection != 5) {
			OptionsMenu();
			selection = input.nextInt();
			if (selection >= 1 && selection <= 5)
				Execute2(selection,obj);
			else
				System.out.println("** Invalid Selection -- Please Reenter **");
		} 
	}

	private static void VehicleMenu() {
		System.out.println("\nSelect one of the following:");
		System.out.println("-------------------------------------------------");
		System.out.println("1 - Jeep");
		System.out.println("2 - Frigate");
		System.out.println("3 - Spy Glider");
		System.out.println("4 - Game Glider");
		System.out.println("5 - To Quit\n");
		System.out.println("Enter : ");
	}
	
	private static void OptionsMenu() {
		System.out.println("\nSelect one of the following:");
		System.out.println("-------------------------------------------------");
		System.out.println("1 - Buy a  Vehicle from the agency");
		System.out.println("2 - Take a car for a test Drive");
		System.out.println("3 - reset all the car's kilometraz");
		System.out.println("4 - Change country flag ");
		System.out.println("5 - To Quit\n");
		System.out.println("Enter : ");
	}

	public static void Execute2(int selection,ArrayList obj) {
		int selectionForAddingVehicles,VehicleChooseType,flag=0,numberOfKm;
		String countryFlag;
		Vehicles vehicle=null;
		switch (selection) {
		case 0: // add Vehicle to the agency
			do {
				VehicleMenu();
				VehicleChooseType=input.nextInt();
				vehicle=CreateNewVehicle(VehicleChooseType);
				if(vehicle!=null)
					obj.add(vehicle);
			} while(VehicleChooseType!=5);
			break;
			
		case 1:  // buy a vehicle
			flag=0;
			 for (int i=0; i<obj.size();i++) {
				   System.out.println(obj.get(i).toString());
			   }
			 System.out.println("which type of car do you want to buy :");
			 VehicleMenu();
			 VehicleChooseType=input.nextInt();
			 vehicle=CreateNewVehicle(VehicleChooseType);
			 if(vehicle != null)
			 for(int i=0;i<obj.size();i++)
				 if(obj.get(i).equals(vehicle))
				 {
					 System.out.println("thanks for bought a vehicle");
					 flag=1;
					 obj.remove(i);
				 }
			 if(flag==0)
				 System.out.println("The vehicle that you wanted to buy does not exist\n");
			break;
			
		case 2: 
			flag=0;
			System.out.println("which type of vehicle do you want to take for a test drive? :");
			VehicleMenu();
			VehicleChooseType=input.nextInt();
			vehicle=CreateNewVehicle(VehicleChooseType);
			System.out.println("How much km did you drive?");
			numberOfKm=input.nextInt();
			for(int i=0;i<obj.size();i++)
				 if(obj.get(i).equals(vehicle)) {
					 ((Vehicles) obj.get(i)).setKilometraz(numberOfKm);
					 flag=1;
				 }
			if(flag==0)
				 System.out.println("The vehicle that you wanted to buy does not exist\n");
			else
				System.out.println("thanks for taking the vehicle for a test drive\n");
			break;

		case 3:
			for(int i=0;i<obj.size();i++)
				((Vehicles) obj.get(i)).ResetKilometraz();
				System.out.println("All Vehicles Kilometers have been reset\n :");
			break;
		case 4:
			System.out.println("To what country flag do you want to change all the Water Vehicles ? :");
			countryFlag=input.nextLine();
			for(int i=0;i<obj.size();i++)
				if(obj.get(i) instanceof WaterVehicles)
					((WaterVehicles)obj.get(i)).setCountryFlag(countryFlag);
			break;

		case 5:
			System.out.println("Thank you for updating the Car Agaency \n");
			break;
		}
	}
	

		public static Vehicles CreateNewVehicle(int choose)
		{
			
			Vehicles vehicle=null;
			int maxSpeed , EngineLife,maxPassengers,WindDirection;
			float AverageFuelConsumption;
			String model,PowerSource;
			switch (choose) {
			case 1: //creating a Jeep
				System.out.print("Enter The Jeep Details: \n");
				System.out.println("Enter max speed: ");
				maxSpeed=input.nextInt();
				System.out.println("Enter model: ");
				input.next(); // collect the \n
				model=input.nextLine();
				System.out.println("Enter Average Fuel Consumption: ");
				AverageFuelConsumption=input.nextFloat();
				System.out.println("Enter Engine Life: ");
				EngineLife=input.nextInt();
				vehicle=new Jeep(maxSpeed,model, AverageFuelConsumption, EngineLife);
				break;
				
			case 2: // creating a Frigate
				System.out.print("Enter The Frigate Details: \n");
				System.out.println("Enter max passengers: ");
				maxPassengers=input.nextInt();
				System.out.println("Enter max speed: ");
				maxSpeed=input.nextInt();
				System.out.println("Enter model: ");
				input.next(); // collect the \n
				model=input.nextLine();
				System.out.println("0 - with the wind, 1 - against the wind");
				WindDirection=input.nextInt();
				if(WindDirection==0)
					vehicle=new Frigate(maxPassengers, maxSpeed, model, "with the widnd");
				else
					vehicle=new Frigate(maxPassengers, maxSpeed, model, "against the wind");
				break;
				
			case 3: // creating Spy Glider
				System.out.print("Enter The Spy Glider Details: \n");
				System.out.println("Enter Power Source ( manual,automatic, semiautomatic..): ");
				PowerSource=input.next();
				vehicle=new SpyGlider(PowerSource);
				break;
				
			case 4://creating Game Glider
				vehicle=new GameGlider();
				break;

			}
			return vehicle;
		}
}
