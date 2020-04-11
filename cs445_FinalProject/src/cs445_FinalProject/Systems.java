package cs445_FinalProject;

import java.util.ArrayList;

public class Systems
{
	private ArrayList<Note> notes;
	private ArrayList<Ride> rides;
	private ArrayList<Ride> selected_rides;
	private ArrayList<Ride> selected_ride_by_Rider;
	private Account account;
	private ArrayList<User> users;
	
	public Systems()
	{
		notes = new ArrayList<Note>();
		rides = new ArrayList<Ride>();
		users = new ArrayList<User>();
		selected_rides = new ArrayList<Ride>();
		selected_ride_by_Rider = new ArrayList<Ride>();
	}
	
	public void receiveNoteFromRider(int num_people, String pickUp, String dropOff, String link)
	{
		Note note = new Note(num_people, pickUp, dropOff, link);
		notes.add(note);
	}
	
	public void receiveRideFromDriver(Ride ride)
	{
		rides.add(new Ride(ride.getStarting_Point(), ride.getEnding_Point(), ride.getDate(),
				ride.getDeparture_Time(), ride.getMax_people(), ride.getAmount()));
	}
	
	public void receiveSelectedRidesFromRider(Ride ride)
	{
		selected_rides.add(new Ride(ride.getStarting_Point(), ride.getEnding_Point(), ride.getDate(),
				ride.getDeparture_Time(), ride.getMax_people(), ride.getAmount()));
	}
	
	public void receiveSelectedRideFromRider(Ride ride)
	{
		selected_ride_by_Rider.add(new Ride(ride.getStarting_Point(), ride.getEnding_Point(), ride.getDate(),
				ride.getDeparture_Time(), ride.getMax_people(), ride.getAmount()));
	}
	
	public ArrayList<Note> showAllNotes()
	{
		return notes;
	}
	
	public ArrayList<Ride> showAllRides()
	{
		return rides;
	}
	
	public ArrayList<Ride> selectedRides()
	{
		return selected_rides;
	}
	
	public ArrayList<Ride> selectedRide()
	{
		return selected_ride_by_Rider;
	}
	
	public void sendNotificationToDriverByLink(Phone phone)
	{
		String link = showAllNotes().get(0).getLink();
		phone.Driver_receives_a_link_to_Note(link, selected_ride_by_Rider.get(0));
	}
	
	public void addDriver(Driver driver)
	{
		users.add(driver);
	}
	
	public boolean verify_Phone_numbers(Account acc, Phone phone)
	{
		boolean decision = false;
		if(acc.getCell_phone_number().equals(phone.getPhoneNumber()))
		{
			decision = true;
		}
		else
		{
			decision = false;
		}
		return decision;
	}
	
	public void send_link_to_UserPhone_to_activate_his_Account(Phone phone, Account acc)
	{
		String link = "www." + (int)(Math.random() * 10000) + ".com";
		if(phone.isConfirmed(link))
		{
			System.out.println("Your account has been activated.");
			acc.accountActivation();
			addAccount(acc);
		}
	}
	
	public void addAccount(Account acc)
	{
		account = new Account(acc.getFirstName(), acc.getLastName(), acc.getCell_phone_number(), acc.getPicture());
	}
	
	public Account getAccount()
	{
		return account;
	}
}
