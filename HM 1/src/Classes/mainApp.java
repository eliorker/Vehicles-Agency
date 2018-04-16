/**
 * @author Elior Kertsman
 * @ID : 313565095
 * @Campus : Ashdod
 *
 */
package Classes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import Vehicles.*;

public class mainApp {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Vehicles> obj = new ArrayList<Vehicles>();
	static ArrayList<WaterVehicles> waterVehicle = new ArrayList<WaterVehicles>();

	public static void main(String[] args) { // main method
		// ----------------------------------------------------------
		// Vehicle Agency Program
		// ----------------------------------------------------------
		int selection = 0; /// first add Vehicles to the agency
		System.out.println("Welcome to the Vehicle Agency Program\n");
		System.out.println(
				"==================================================================================================\n");
		System.out.println("Add vehicles to your agency :\n");
		Execute2(selection); /// add vehicles to agency outside the loop
		while (selection != 5) {
			OptionsMenu();
			try {
			selection = input.nextInt();
			}catch(InputMismatchException e) {System.out.println("Wrong input, try again"); input.next();}
			if (selection >= 1 && selection <= 5)
				Execute2(selection);
			else
				System.out.println("** Invalid Selection -- Please Reenter **");
		}
		input.close();
	}

	private static void VehicleMenu() { // presents all the vehicle choises
		System.out.println("\nSelect one of the following:");
		System.out.println("-------------------------------------------------");
		System.out.println("1 - Jeep");
		System.out.println("2 - Frigate");
		System.out.println("3 - Spy Glider");
		System.out.println("4 - Game Glider");
		System.out.println("5 - To Quit\n");
		System.out.println("Enter : ");
	}

	private static void OptionsMenu() { // presents the user optionality
		System.out.println("\nSelect one of the following:");
		System.out.println("-------------------------------------------------");
		System.out.println("1 - Buy a  Vehicle from the agency");
		System.out.println("2 - Take a car for a test Drive");
		System.out.println("3 - reset all the car's kilometraz");
		System.out.println("4 - Change country flag ");
		System.out.println("5 - To Quit\n");
		System.out.println("Enter : ");
	}

	/**
	 * @param selection select and executing the method by the user choose
	 */
	public static void Execute2(int selection) {
		try {
		int selectionForAddingVehicles, VehicleChooseType, flag = 0, numberOfKm;
		String countryFlag;
		Vehicles vehicle = null;
		switch (selection) {
		case 0: // add Vehicle to the agency
			do {
				VehicleMenu();
				VehicleChooseType = input.nextInt();
				vehicle = CreateNewVehicle(VehicleChooseType,1);
				if (vehicle != null)
					obj.add(vehicle);
			} while (VehicleChooseType != 5);
			break;

		case 1: // buy a vehicle
			flag = 0;
			for (int i = 0; i < obj.size(); i++) {
				System.out.println(obj.get(i).toString());
			}
			System.out.println("which type of car do you want to buy :");
			VehicleMenu();
			VehicleChooseType = input.nextInt();
			vehicle = CreateNewVehicle(VehicleChooseType,0);
			if (vehicle != null)
				for (int i = 0; i < obj.size(); i++)
					if (obj.get(i).equals(vehicle)) {
						System.out.println("thanks for bought a vehicle");
						flag = 1;
						obj.remove(i);
						try {
						waterVehicle.remove(i);
						}catch(IndexOutOfBoundsException e) {}
					}
			if (flag == 0)
				System.out.println("The vehicle that you wanted to buy does not exist\n");
			break;

		case 2: // take the car for a test drive
			flag = 0;
			System.out.println("which type of vehicle do you want to take for a test drive? :");
			VehicleMenu();
			VehicleChooseType = input.nextInt();
			vehicle = CreateNewVehicle(VehicleChooseType,0);
			System.out.println("How much km did you drive?");
			numberOfKm = input.nextInt();
			for (int i = 0; i < obj.size(); i++)
				if (obj.get(i).equals(vehicle)) {
					obj.get(i).setKilometraz(numberOfKm);
					flag = 1;
				}
			if (flag == 0)
				System.out.println("The vehicle that you wanted to buy does not exist\n");
			else
				System.out.println("thanks for taking the vehicle for a test drive\n");
			break;

		case 3: //reset all the cars kilometers
			for (int i = 0; i < obj.size(); i++)
				obj.get(i).ResetKilometraz();
			System.out.println("All Vehicles Kilometers have been reset\n :");
			break;
			
		case 4: // change all the Water Vehicles country flag
			System.out.println("To what country flag do you want to change all the Water Vehicles ? :");
			countryFlag = input.next();
			for (int i = 0; i < waterVehicle.size(); i++)
				waterVehicle.get(i).setCountryFlag(countryFlag);
			break;

		case 5: // exit
			System.out.println("Thank you for updating the Car Agaency \n");
			break;
		}
		
		}
		catch(InputMismatchException e) {System.out.println("Wrong input, try again"); input.next();}
	}

	/**
	 * @param choose decide which type of vehicle to create
	 * @param dontCreateNewVehicle 1-creat 0-not
	 * @return a new vehicle (jeep , frigate, spy glider , game glider)
	 */
	public static Vehicles CreateNewVehicle(int choose,int CreateOrNewVehicle) {
		Vehicles vehicle = null;
		Frigate frigate;
		int maxSpeed, EngineLife, maxPassengers, WindDirection;
		float AverageFuelConsumption;
		String model, PowerSource;
		switch (choose) {
		case 1: // creating a Jeep

			System.out.print("Enter The Jeep Details: \n");
			System.out.println("Enter max speed: ");
			maxSpeed = input.nextInt();
			System.out.println("Enter model: ");
			model = input.next();
			System.out.println("Enter Average Fuel Consumption: ");
			AverageFuelConsumption = input.nextFloat();
			System.out.println("Enter Engine Life: ");
			EngineLife = input.nextInt();
			vehicle = new Jeep(maxSpeed, model, AverageFuelConsumption, EngineLife);

			break;

		case 2: // creating a Frigate
			System.out.print("Enter The Frigate Details: \n");
			System.out.println("Enter max passengers: ");
			maxPassengers = input.nextInt();
			System.out.println("Enter max speed: ");
			maxSpeed = input.nextInt();
			System.out.println("Enter model: ");
			model = input.next();
			System.out.println("0 - with the wind, 1 - against the wind");
			WindDirection = input.nextInt();
			if (WindDirection == 0)
				frigate = new Frigate(maxPassengers, maxSpeed, model, "with the widnd");
			else
				frigate = new Frigate(maxPassengers, maxSpeed, model, "against the wind");
			if(CreateOrNewVehicle!=0)
				waterVehicle.add(frigate);
			return frigate;

		case 3: // creating Spy Glider
			System.out.print("Enter The Spy Glider Details: \n");
			System.out.println("Enter Power Source ( manual,automatic, semiautomatic..): ");
			PowerSource = input.next();
			vehicle = new SpyGlider(PowerSource);
			break;

		case 4:// creating Game Glider
			vehicle = new GameGlider();
			break;

		}
		return vehicle;
	}

}
