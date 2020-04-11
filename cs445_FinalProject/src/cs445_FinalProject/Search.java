package cs445_FinalProject;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Search 
{
	private String search_date;
	private int zip_code_Arrival_city; 
	private int zip_code_Departure_city; 
	private String arrival_city;
	private String first_name_of_driver;
	
	private Ride ride;
	private Driver driver;
	private Rating rating;
	private Systems system;
	
	/**
	 * 
	 * This is the base Search constructor
	 */
	public Search(int zip_code_Departure_city, int zip_code_Arrival_city, String search_date, String arrival_city, String first_name_of_driver)
	{
		this.zip_code_Departure_city = zip_code_Departure_city;
		this.zip_code_Arrival_city = zip_code_Arrival_city;
		this.search_date = search_date;
		this.arrival_city = arrival_city;
		this.first_name_of_driver = first_name_of_driver;
	}
	
	/**
	 * 
	 * @param zip_code
	 * @param ride
	 * @param arrival_city
	 * @param driver
	 * @param rating
	 * 
	 * This is the search constructor for a Rider to search information about a Driver
	 */
	public Search(int zip_code_Departure_city, int zip_code_Arrival_city, Ride ride, String arrival_city, Driver driver, Rating rating, String first_name_of_driver)
	{
		this.zip_code_Departure_city = zip_code_Departure_city;
		this.zip_code_Arrival_city = zip_code_Arrival_city;
		this.ride = ride;
		this.driver = driver;
		this.rating = rating;
		
		this.arrival_city = arrival_city;
		this.first_name_of_driver = first_name_of_driver;
	}
	
	public void searchRides(ArrayList<Ride> ride, String departure_city, String arrival_city, String date_of_ride)
	{
		String str = "";
		for(int i = 0; i < ride.size(); i++)
		{
			if(((ride.get(i)).getStarting_Point()).equals(departure_city)
				&& ((ride.get(i)).getEnding_Point()).equals(arrival_city)
				&& ((ride.get(i)).getDate()).equals(date_of_ride))
			{
				str += (ride.get(i)).toString();
			}
		}
		System.out.print(str);
	}
	
	public boolean anyRides(String date_of_ride)
	{
		boolean decision = false;
		if(search_date.equals(date_of_ride))
		{
			decision = true;
		}
		return decision;		
	}
	
	public ArrayList<Integer> dateConversion(String date)
	{
		int month1;
		int day1;
		int year1;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		StringTokenizer st1 = new StringTokenizer(date, "-");
		for(int i = 0; st1.hasMoreTokens(); i++)
		{
			if(i == 0)
			{
				String monthStr = st1.nextToken();
				month1 = Integer.parseInt(monthStr);
				
				String temp = String.format("%02d", month1);
				int formattedMonth = Integer.parseInt(temp);
				arr.add(formattedMonth);
			}
			else if(i == 1)
			{
				String dayStr = st1.nextToken();
				day1 = Integer.parseInt(dayStr);
				
				String temp = String.format("%02d", day1);
				int formattedDay = Integer.parseInt(temp);
				arr.add(formattedDay);
			}
			else if(i == 2)
			{
				String yearStr = st1.nextToken();
				year1 = Integer.parseInt(yearStr);
				
				String temp = String.format("%04d", year1);
				int formattedYear = Integer.parseInt(temp);
				arr.add(formattedYear);
			}
		}
		return arr;
	}
	
	public String getSearchDate()
	{
		return search_date;
	}
	
	public String getFirst_Name_of_Driver()
	{
		return first_name_of_driver;
	}
	
	public int getDepartureZipCode()
	{
		return zip_code_Departure_city;
	}
	
	public int getArrivalZipCode()
	{
		return zip_code_Arrival_city;
	}
	
	public String getArrivalCity()
	{
		return arrival_city;
	}
	
	public Ride getRide()
	{
		return ride;
	}
	
	public Driver getDriver()
	{
		return driver;
	}
	
	public Rating getRating()
	{
		return rating;
	}
	
	public Systems getSystems()
	{
		return system;
	}
	
	public String getStartPoint(Ride ride)
	{
		return ride.getStarting_Point();
	}
	
	public int getNum_of_Ratings(Rating rating)
	{
		return rating.getNumber_of_Ratings();
	}
	
	public double getAverage_Rating(Rating rating)
	{
		return rating.getAverage_Rating();
	}
	
	public String getComment(Rating rating)
	{
		return rating.getComments();
	}
	
	public String getPicture(Driver driver)
	{
		return driver.getPicture();
	}
}
