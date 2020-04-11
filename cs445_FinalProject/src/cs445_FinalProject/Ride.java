package cs445_FinalProject;

public class Ride 
{
	private String start_Point;
	private String end_Point;
	private String date;
	private String departure_time;
	private int max_people;
	private double amount;
	private String pickUp_place;
	private String dropOff_place;

	
	public Ride()
	{
		RideMethod(start_Point, end_Point, date, 
				departure_time, max_people);
	}
	
	/**
	 * 
	 * @param start_Point
	 * @param end_Point
	 * @param date
	 * @param departure_time
	 * @param max_people
	 * @param amount
	 * 
	 * This is a Ride that a Driver can post
	 */
	public Ride(String start_Point, String end_Point, String date, 
			String departure_time, int max_people, double amount)
	{
		this.start_Point = start_Point;
		this.end_Point = end_Point;
		this.date = date;
		this.departure_time = departure_time;
		this.max_people = max_people;
		this.amount = amount;
	}
	
	public Ride(String start_Point, String end_Point, String date,
			String departure_time, int max_people)
	{
		this.start_Point = start_Point;
		this.end_Point = end_Point;
		this.date = date;
		this.departure_time = departure_time;
		this.max_people = max_people;
		amount = 0.00;
	}
	
	public void RideMethod(String start_Point, String end_Point, String date,
			String departure_time, int max_people)
	{
		this.start_Point = start_Point;
		this.end_Point = end_Point;
		this.date = date;
		this.departure_time = departure_time;
		this.max_people = max_people;
		amount = 0;
	}
	
	public Ride(String start_Point, String end_Point, String date)
	{
		this.start_Point = start_Point;
		this.end_Point = end_Point;
		this.date = date;
	}
	
	public String getStarting_Point()
	{
		return start_Point;
	}
	
	public String getEnding_Point()
	{
		return end_Point;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getDeparture_Time()
	{
		return departure_time;
	}
	
	public int getMax_people()
	{
		return max_people;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public String getPickUp_place()
	{
		return pickUp_place;
	}
	
	public String getDropOff_place()
	{
		return dropOff_place;
	}
	
	public String toString()
	{
		return "Departure city: " + start_Point + "     \t" + "Arrival city: " + end_Point + "     \t" +
				"Date: " + date + "     \t" + "Departure time: " + departure_time + "     \t" +
				"Max people: " + max_people + "     \t" + "Amount: " + amount + "\n";
	}
	
	public int spaceLeft(Note n)
	{
		return max_people - n.getNumber_of_People();
	}
}

