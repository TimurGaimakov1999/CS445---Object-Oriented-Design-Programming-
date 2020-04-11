package cs445_FinalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Test 
{
	public static void main(String[] args)
	{
		Driver driver = new Driver();
		Systems system = new Systems();
		
		ArrayList<Ride> arr = new ArrayList<Ride>();
		System.out.println("Driver's menu option");
		System.out.println("1) create Account (must be first thing to do and done only once)");
		System.out.println("2) create a Ride");
		System.out.println("#) exit");
		System.out.print("Enter your option (enter only a number): ");
		Scanner s = new Scanner(System.in);
		
		String choiceD = s.nextLine();
		System.out.println();
		int p = 0;
		while(choiceD.equals("1") || choiceD.equals("2"))
		{
			if(choiceD.equals("1"))
			{
				if(p == 0)
				{
					Account acc1 = driver.createAccount();
					driver.activateAccount(acc1);
					p++;
					System.out.println();
					System.out.println("Driver's menu option");
					System.out.println("1) create Account (must be first thing to do and done only once)");
					System.out.println("2) create a Ride");
					System.out.println("#) exit");
					System.out.print("Enter your option (enter only a number): ");
					choiceD = s.nextLine();
					System.out.println();
				}
				else if(p != 0)
				{
					System.out.println("Error: you can create Account only once\n");
					System.out.println("Driver's menu option");
					System.out.println("1) create Account (must be first thing to do and done only once)");
					System.out.println("2) create a Ride");
					System.out.println("#) exit");
					System.out.print("Enter your option (enter only a number): ");
					choiceD = s.nextLine();
					System.out.println();
				}
			}
			else if(choiceD.equals("2"))
			{
				if(p == 0)
				{
					System.out.println("Error: you must create Account first\n");
					System.out.println("Driver's menu option");
					System.out.println("1) create Account (must be first thing to do and done only once)");
					System.out.println("2) create a Ride");
					System.out.println("#) exit");
					System.out.print("Enter your option (enter only a number): ");
					choiceD = s.nextLine();
					System.out.println();
				}
				else if(p != 0)
				{
					arr.add(driver.createRide());
					System.out.println("Driver's menu option");
					System.out.println("1) create Account (must be first thing to do and done only once)");
					System.out.println("2) create a Ride");
					System.out.println("#) exit");
					System.out.print("Enter your option (enter only a number): ");
					choiceD = s.nextLine();
					System.out.println();
				}
			}
		}
		
		driver.send_Rides_to_System(arr, system);
		
		System.out.println("=============================================="); 
		System.out.println(); 
		System.out.println("Switching to rider's mode..... Please wait"); 
		System.out.println();
		System.out.println("=============================================="); 
		Rider rider = new Rider();
		
		System.out.println();
		System.out.println("Rider's menu option");
		System.out.println("1) create Account (must be first thing to do)");
		System.out.println("2) search a ride");
		System.out.println("3) join a ride");
		System.out.println("4) search Driver");
		System.out.println("#) exit");
		System.out.print("Enter your option (enter only a number): ");
		
		String choiceR = s.nextLine();
		System.out.println();
		String startPoint = "";
		String endPoint = "";
		String date = "";
		int d = 0;
		while(choiceR.equals("1") || choiceR.equals("2") || choiceR.equals("3") || choiceR.equals("4"))
		{
			if(choiceR.equals("1"))
			{
				if(d == 0)
				{
					Account acc2 = rider.createAccount();
					rider.activateAccount(acc2);
					d++;
					System.out.println();
					System.out.println("Rider's menu option");
					System.out.println("1) create Account (must be first thing to do and done only once)");
					System.out.println("2) search a ride");
					System.out.println("3) join a ride");
					System.out.println("#) exit");
					System.out.print("Enter your option (enter only a number): ");
					choiceR = s.nextLine();
					System.out.println();
				}
				else if(d != 0)
				{
					System.out.println("Error: you can create Account only once\n");
					System.out.println("Rider's menu option");
					System.out.println("1) create Account (must be first thing to do and done only once)");
					System.out.println("2) search a ride");
					System.out.println("3) join a ride");
					System.out.println("#) exit");
					System.out.print("Enter your option (enter only a number): ");
					choiceR = s.nextLine();
					System.out.println();
				}
			}
			else if(choiceR.equals("2"))
			{
				if(d == 0)
				{
					System.out.println("Error: you must create Account first\n");
					System.out.println("Rider's menu option");
					System.out.println("1) create Account (must be first thing to do and done only once)");
					System.out.println("2) search a ride");
					System.out.println("3) join a ride");
					System.out.println("#) exit");
					System.out.print("Enter your option (enter only a number): ");
					choiceR = s.nextLine();
					System.out.println();
				}
				else if(d != 0)
				{
					System.out.print("Enter the starting point: ");
					startPoint = s.nextLine();
				
					System.out.print("Enter the ending point: ");
					endPoint = s.nextLine();
				
					System.out.print("Enter date (MM-dd-YYYY format): ");
					date = s.nextLine();
				
					while(!(date.substring(2, 3)).equals("-") || !(date.substring(5, 6)).equals("-") || date.length() != 10)
					{
						System.out.print("\nError: the date entered is not in format MM-dd-YYYY\nEnter the correct date: ");
						date = s.nextLine();
					}
					rider.searchRides(startPoint, endPoint, date, system);
					System.out.println();
					System.out.println("Rider's menu option");
					System.out.println("1) create Account (must be first thing to do and done only once)");
					System.out.println("2) search a ride");
					System.out.println("3) join a ride");
					System.out.println("#) exit");
					System.out.print("Enter your option (enter only a number): ");
					choiceR = s.nextLine();
					System.out.println();
				}
			}
			else if(choiceR.equals("3"))
			{
				if(d == 0)
				{
					System.out.println("Error: you must create Account first\n");
					System.out.println("Rider's menu option");
					System.out.println("1) create Account (must be first thing to do and done only once)");
					System.out.println("2) search a ride");
					System.out.println("3) join a ride");
					System.out.println("#) exit");
					System.out.print("Enter your option (enter only a number): ");
					choiceR = s.nextLine();
					System.out.println();
				}
				else if(d != 0)
				{
					Ride r = rider.choosen_ride(system.selectedRides(), system);
					System.out.println("\nThe following ride is chosen\n" + r.toString());
				
					Note note = rider.createNote(r);
					rider.postNoteToDesiredRide(note, system);
					System.out.println("\nShow created notes");
					int count = 1;
					for(int i = 0; i < (system.showAllNotes()).size(); i++)
					{
						System.out.print(count + ") " + ((system.showAllNotes()).get(i)).toString());
						count++;
					}
					System.out.println();
					System.out.println("Rider's menu option");
					System.out.println("1) create Account (must be first thing to do and done only once)");
					System.out.println("2) search a ride");
					System.out.println("3) join a ride");
					System.out.println("#) exit");
					System.out.print("Enter your option (enter only a number): ");
					choiceR = s.nextLine();
					System.out.println();
				}
			}
			else if(choiceR.equals("4"))
			{
				
			}
		}
		System.out.println("=============================================="); 
		System.out.println(); 
		System.out.println("Switching to driver's mode..... Please wait"); 
		System.out.println();
		System.out.println("==============================================");
		driver.receive_link_from_System_to_the_Note(system);
		//Note note = rider.createNote();
		//rider.postNoteToDesiredRide(note);
		s.close();
	}
}
