package cs445_FinalProject;

import java.util.Scanner;

public class Phone 
{
	private String phoneNumber;
	
	public Phone(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public boolean isConfirmed(String message)
	{
		boolean dec = false;
		System.out.println("Your phone received the following link to activate your account: " + message);
		System.out.print("Click? (Y/N): ");
		Scanner scan = new Scanner(System.in);
		String verified = scan.nextLine();
		while(!verified.equalsIgnoreCase("Y") && !verified.equalsIgnoreCase("N"))
		{
			System.out.println("You entered incorrect option (only Y/N). Try again");
			System.out.println("Your phone received the following link to activate your account: " + message);
			System.out.print("Click? (Y/N): ");
			verified = scan.nextLine();
			System.out.println();
		}
		if(verified.equalsIgnoreCase("Y"))
		{
			dec = true;
		}
		else if(verified.equalsIgnoreCase("N"))
		{
			dec = false;
		}
		scan.close();
		return dec;
	}
	
	public void Driver_receives_a_link_to_Note(String link, Ride r)
	{
		System.out.println("Congradulations. Someone is interested to join your ride\n" + r.toString());
		System.out.println("Your phone received the following link to see Rider's Note: " + link);
		System.out.print("Click? (Y/N): ");
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
}
