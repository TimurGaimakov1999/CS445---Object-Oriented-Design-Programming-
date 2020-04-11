package cs445_FinalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends Person implements User
{
	private String picture;
	private Car car;
	private Phone phone;
	private Account account;
	private Ride ride;
	private Rating rating;
	private Systems systems;
	
	public Driver()
	{
		picture = "";
		systems = new Systems();
		
		String firstPart = (int)(Math.random() * 900) + 100 + "" + "-";
		String secondPart = (int)(Math.random() * 900) + 100 + "" + "-";
		String thirdPart = (int)(Math.random() * 9000) + 1000 + "";
		String phoneNumber = firstPart + secondPart + thirdPart;
		
		phone = new Phone(phoneNumber); // Driver has a random phone number in format of 'XXX-XXX-XXXX'
	}
	
	public Driver(String link)
	{
		picture = "";
	}
	
	public Account createAccount()
	{
		System.out.println("Driver's create Account"); 
		Scanner scan = new Scanner(System.in);
		
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
		boolean dec = systems.verify_Phone_numbers(account, phone);
		
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
			dec = systems.verify_Phone_numbers(account, phone);
		}
		scan.close();
		return account;
	}
	
	public void activateAccount(Account acc)
	{
		systems.send_link_to_UserPhone_to_activate_his_Account(phone, acc);
	}
	
	public Ride createRide()
	{	
		Scanner scan = new Scanner(System.in); // for String
		Scanner sc = new Scanner(System.in);  // for int
		Scanner sca = new Scanner(System.in); // for double
		
		System.out.print("Enter the starting point: ");
		String startPoint = scan.nextLine();
		
		System.out.print("Enter the ending point: ");
		String endPoint = scan.nextLine();
		
		System.out.print("Enter date (MM-dd-YYYY format): ");
		String date = scan.nextLine();
		
		while(!(date.substring(2, 3)).equals("-") || !(date.substring(5, 6)).equals("-") || date.length() != 10)
		{
			System.out.print("\nError: the date entered is not in format MM-dd-YYYY\nEnter the correct date: ");
			date = scan.nextLine();
		}
		
		String[] parts = date.split("-");
		String monthStr = parts[0];
		String dayStr = parts[1];
		String yearStr = parts[2];
		
		int month, day, year;
		
		for(int i = 0; i < parts.length; i++)
		{
			if(i == 0)
			{
				month = Integer.parseInt(monthStr);
				while(month < 1 || month > 12)
				{
					System.out.print("\nError: the month entered is not correct (12 months)\nEnter date (MM-dd-YYYY format): ");
					date = scan.nextLine();
					
					while(!(date.substring(2, 3)).equals("-") || !(date.substring(5, 6)).equals("-") || date.length() != 10)
					{
						System.out.print("\nError: the date entered is not in format MM-dd-YYYY\nEnter the correct date: ");
						date = scan.nextLine();
					}
					
					parts = date.split("-");
					monthStr = parts[0];
					dayStr = parts[1];
					yearStr = parts[2];
					
					month = Integer.parseInt(monthStr);
					day = Integer.parseInt(dayStr);
					year = Integer.parseInt(yearStr);
				}
			}
			else if(i == 1)
			{
				day = Integer.parseInt(dayStr);
				month = Integer.parseInt(monthStr);
				
				while(day < 1 || day > 30 || month < 1 || month > 12)
				{
					if(day < 1 || day > 30)
					{
						System.out.print("\nError: the day entered is not correct (30 days)\nEnter date (MM-dd-YYYY format): ");
					}
					else if(month < 1 || month > 12)
					{
						System.out.print("\nError: the month entered is not correct (12 months)\nEnter date (MM-dd-YYYY format): ");
					}
					date = scan.nextLine();
					
					while(!(date.substring(2, 3)).equals("-") || !(date.substring(5, 6)).equals("-") || date.length() != 10)
					{
						System.out.print("\nError: the date entered is not in format MM-dd-YYYY\nEnter the correct date: ");
						date = scan.nextLine();
					}
					
					parts = date.split("-");
					monthStr = parts[0];
					dayStr = parts[1];
					yearStr = parts[2];
					
					month = Integer.parseInt(monthStr);
					day = Integer.parseInt(dayStr);
					year = Integer.parseInt(yearStr);
				}
			}
			else if(i == 2)
			{
				day = Integer.parseInt(dayStr);
				month = Integer.parseInt(monthStr);
				
				year = Integer.parseInt(yearStr);
				while(year != 2020)
				{
					if(day < 1 || day > 30)
					{
						System.out.print("\nError: the day entered is not correct (30 days)\nEnter date (MM-dd-YYYY format): ");
					}
					else if(month < 1 || month > 12)
					{
						System.out.print("\nError: the month entered is not correct (12 months)\nEnter date (MM-dd-YYYY format): ");
					}
					else if(year != 2020)
					{
						System.out.print("\nError: the year entered is not correct (2020 year only)\nEnter date (MM-dd-YYYY format): ");
					}
					date = scan.nextLine();
					
					while(!(date.substring(2, 3)).equals("-") || !(date.substring(5, 6)).equals("-") || date.length() != 10)
					{
						System.out.print("\nError: the date entered is not in format MM-dd-YYYY\nEnter the correct date: ");
						date = scan.nextLine();
					}
					
					parts = date.split("-");
					monthStr = parts[0];
					dayStr = parts[1];
					yearStr = parts[2];
					
					month = Integer.parseInt(monthStr);
					day = Integer.parseInt(dayStr);
					year = Integer.parseInt(yearStr);
				}
			}
		}
		
		System.out.print("Enter departure time (24:00 format): ");
		String time = scan.nextLine();
		
		while(!(time.substring(2, 3)).equals(":") || time.length() != 5)
		{
			System.out.print("\nError: the time entered is not in 24:00 format\nEnter the correct departure time: ");
			time = scan.nextLine();
		}
		
		String[] parts1 = time.split(":");
		String hourStr = parts[0];
		String minuteStr = parts[1];
		
		int hour, minute;
		for(int i = 0; i < parts1.length; i++)
		{
			if(i == 0)
			{
				hour = Integer.parseInt(hourStr);
				while(hour < 0 || hour > 24)
				{
					System.out.print("\nError: the hour entered is not correct (24 hours)\nEnter the correct departure time: ");
					time = scan.nextLine();
					
					while(!(time.substring(2, 3)).equals(":") || time.length() != 5)
					{
						System.out.print("\nError: the time entered is not in 24:00 format\nEnter the correct departure time: ");
						time = scan.nextLine();
					}
					
					parts1 = time.split("-");
					hourStr = parts1[0];
					minuteStr = parts1[1];
					
					hour = Integer.parseInt(hourStr);
					minute = Integer.parseInt(minuteStr);
				}
			}
			else if(i == 1)
			{
				hour = Integer.parseInt(hourStr);
				minute = Integer.parseInt(minuteStr);
				
				while(minute < 0 || minute > 59 || hour < 0 || hour > 24)
				{
					if(minute < 0 || minute > 59)
					{
						System.out.print("\nError: the minutes entered are not correct (24 hours)\nEnter the correct departure time: ");
					}
					else if(hour < 0 || hour > 24)
					{
						System.out.print("\nError: the hour entered is not correct (24 hours)\nEnter the correct departure time: ");
					}
					time = scan.nextLine();
					
					while(!(time.substring(2, 3)).equals(":") || time.length() != 5)
					{
						System.out.print("\nError: the time entered is not in 24:00 format\nEnter the correct departure time: ");
						time = scan.nextLine();
					}
					
					parts1 = time.split("-");
					hourStr = parts1[0];
					minuteStr = parts1[1];
					
					hour = Integer.parseInt(hourStr);
					minute = Integer.parseInt(minuteStr);
				}
			}
		}
				
		System.out.print("Enter max people: ");
		int max_people = sc.nextInt();
		while(max_people < 1)
		{
			System.out.println("\nError: max number of passengers cannot be a 0 or negative number");
			System.out.println("Enter max people: ");
			max_people = sc.nextInt();
		}
		
		System.out.print("Enter amount to take (Enter 0.00 if you are doing this for free): ");
		double amount = sca.nextDouble();
		
		if(amount == 0.0 || amount == 0.00)
		{
			ride = new Ride(startPoint, endPoint, date, time, max_people);
		}
		else
		{
			ride = new Ride(startPoint, endPoint, date, time, max_people, amount);
		}
		System.out.print("Enter the make of your car: ");
		String make = scan.nextLine();
		
		System.out.print("Enter the model of your car: ");
		String model = scan.nextLine();
		
		System.out.print("Enter the color of your car: ");
		String color = scan.nextLine();
		
		System.out.print("Enter the licence plate number of your car: ");
		String licence_plate_number = scan.nextLine();
		
		System.out.print("Enter the state where your licence was issued: ");
		String state = scan.nextLine();
		
		LicencePlate plate = new LicencePlate(licence_plate_number, state);
		car = new Car(make, model, color, plate);
		
		System.out.println();
		sc.close();
		sca.close();
		scan.close();
		//systems.receiveRideFromDriver(ride);
		return ride;
	}
	
	public void driverInformation()
	{
		
	}
	
	public void send_Rides_to_System(ArrayList<Ride> rides, Systems system)
	{
		for(int i = 0; i < rides.size(); i++)
		{
			system.receiveRideFromDriver(rides.get(i));
		}
	}
	
	public void see_created_rides(ArrayList<Ride> rides)
	{
		System.out.println("Created rides");
		int count = 1;
		for(int i = 0; i < rides.size(); i++)
		{
			System.out.print(count + ")" + rides.get(i).toString());
			count++;
		}
	}
	
	public ArrayList<Ride> createdRides(ArrayList<Ride> rides)
	{
		ArrayList<Ride> arr = new ArrayList<Ride>();
		for(int i = 0; i < rides.size(); i++)
		{
			arr.add(rides.get(i));
		}
		return arr;
	}
	
	public void specifyNotes() 
	{
		
	}
	
	public String getPicture()
	{
		return picture;
	}
	
	public void receive_link_from_System_to_the_Note(Systems sys)
	{
		sys.sendNotificationToDriverByLink(phone);
	}
	
	public Car getCar()
	{
		return car;
	}
	
	public Rating getRating()
	{
		return rating;
	}
}
