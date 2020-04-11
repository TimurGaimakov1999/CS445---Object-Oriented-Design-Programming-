package cs445_FinalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Rider extends Person implements User
{
	private Systems system;
	private Account account;
	private Phone phone;
	private String picture;
	
	public Rider()
	{	
		system = new Systems();
		String firstPart = (int)(Math.random() * 900) + 100 + "" + "-";
		String secondPart = (int)(Math.random() * 900) + 100 + "" + "-";
		String thirdPart = (int)(Math.random() * 9000) + 1000 + "";
		String phoneNumber = firstPart + secondPart + thirdPart;
		
		phone = new Phone(phoneNumber); // Driver has a random phone number in format of 'XXX-XXX-XXXX'
	}
	
	public Account createAccount()
	{
		System.out.println("Rider's create Account"); 
		Scanner scan = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your first name: ");
		String firstName = scan.nextLine();
		
		System.out.print("Enter your last name: ");
		String lastName = scan.nextLine();
		
		System.out.print("Enter your cell phone number 'XXX-XXX-XXXX': ");
		String cellPhoneNumber = scan.nextLine();
		
		while(!(cellPhoneNumber.substring(3, 4)).equals("-") || !(cellPhoneNumber.substring(7, 8)).equals("-") || cellPhoneNumber.length() != 12)
		{
			System.out.print("\nError: the phone number entered is not in format 'XXX-XXX-XXXX'\nEnter the correct phone number: ");
			cellPhoneNumber = scan.nextLine();
		}
		System.out.println();
		account = new Account(firstName, lastName, cellPhoneNumber, picture);
		boolean dec = system.verify_Phone_numbers(account, phone);
		
		while(dec == false)
		{
			System.out.println("Error: your registered account phone number and your actual phone numbers differ.");
			System.out.println("Your actual phone number: " + phone.getPhoneNumber());
			System.out.print("Enter your cell phone number 'XXX-XXX-XXXX': ");
			cellPhoneNumber = scan.nextLine();
			
			while(!(cellPhoneNumber.substring(3, 4)).equals("-") || !(cellPhoneNumber.substring(7, 8)).equals("-") || cellPhoneNumber.length() != 12)
			{
				System.out.print("\nError: the phone number entered is not in format 'XXX-XXX-XXXX'\nEnter the correct phone number: ");
				cellPhoneNumber = scan.nextLine();
			}
			System.out.println();
			account = new Account(firstName, lastName, cellPhoneNumber, picture);
			dec = system.verify_Phone_numbers(account, phone);
		}
		//(driver.getSystem()).send_link_to_UserPhone_to_activate_his_Account(phone, account);
		sc.close();
		scan.close();
		return account;
	}
	
	public void activateAccount(Account acc)
	{
		system.send_link_to_UserPhone_to_activate_his_Account(phone, acc);
	}
	
	public void see_all_rides(Systems sys)
	{
		int count = 1;
		System.out.println("The system has these rides");
		for(int i = 0; i < (sys.showAllRides()).size(); i++)
		{
			System.out.print(count + ") " + ((sys.showAllRides()).get(i)).toString());
			count++;
		}
	}
	
	public void searchRides(String departure_city, String arrival_city, String date_of_ride, Systems sys)
	{
		String str = "";
		int count = 0;
		ArrayList<Ride> ride = sys.showAllRides();
		System.out.println("\nThese rides match your search (Departure city: " + departure_city + ", Arrival city: " + arrival_city + ", Date: " + date_of_ride + ")");
		for(int i = 0; i < ride.size(); i++)
		{
			if(((ride.get(i)).getStarting_Point()).equals(departure_city)
				&& ((ride.get(i)).getEnding_Point()).equals(arrival_city)
				&& ((ride.get(i)).getDate()).equals(date_of_ride))
			{
				count++;
				str += count + ") " + ride.get(i).toString();
				sys.receiveSelectedRidesFromRider(ride.get(i));
			}
		}
		System.out.print(str);
	}

	public Ride choosen_ride(ArrayList<Ride> rides, Systems sys)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Which ride do you choose? (Enter number of a ride): ");
		int rideNumber = scan.nextInt();
		while(rideNumber > rides.size() || rideNumber < 1)
		{
			System.out.print("Error: the number is not on the list\nEnter the correct number: ");
			rideNumber = scan.nextInt();
		}
		sys.receiveSelectedRideFromRider(rides.get(rideNumber - 1));
		scan.close();
		return rides.get(rideNumber - 1);
	}
	
	public Note createNote(Ride r)
	{
		Scanner scan = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of passengers: ");
		int numPassengers = scan.nextInt();
		//System.out.println("Number of passengers: " + numPassengers);
		while(numPassengers < 1)
		{
			System.out.println("\nError: number of passengers cannot be a 0 or negative number");
			System.out.print("Enter number of passengers: ");
			numPassengers = scan.nextInt();
		}
		while(numPassengers > r.getMax_people())
		{
			System.out.println("\nError: number of passengers cannot be higher than ride's max passengers");
			System.out.print("Enter number of passengers: ");
			numPassengers = scan.nextInt();
		}
		
		System.out.print("Enter pick-up place: ");
		String pickUp = sc.nextLine();
		//System.out.println("Pick-up place: " + pickUp);
		
		System.out.print("Enter drop-off place: ");
		String dropOff = sc.nextLine();
		//System.out.println("Drop-off place: " + dropOff);
		
		Note note1 = new Note(numPassengers, pickUp, dropOff);
		scan.close();
		sc.close();
		return note1;
	}
	
	public void postNoteToDesiredRide(Note note, Systems sys)
	{	
		note.sendNote_with_link_to_System(sys);
	}
}
