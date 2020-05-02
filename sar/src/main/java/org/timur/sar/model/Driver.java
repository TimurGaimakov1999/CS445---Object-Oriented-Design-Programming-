package org.timur.sar.model;

import java.util.ArrayList;

public class Driver 
{
	private int aid;
	private String first_name;
	private int number_of_rides;
	private int number_of_ratings;
	private double average_rating;
	private String picture;
	private Detail detail;
	private int rid;
	private ArrayList<Ride> rides;
	private ArrayList<Rating> ratings;
	
	public Driver()
	{
		rides = new ArrayList<Ride>();
		ratings = new ArrayList<Rating>();
	}

	public Driver(int aid, String first_name)
	{
		this.aid = aid;
		this.first_name = first_name;
	}
	
	public Driver(int aid, String first_name, String picture)
	{
		this.aid = aid;
		this.first_name = first_name;
		this.picture = picture;
	}
	
	public Driver(int aid, String first_name, String picture, int rid)
	{
		this.aid = aid;
		this.first_name = first_name;
		this.picture = picture;
		this.rid = rid;
	}
	
	public Driver(int aid, String first_name,  String picture, int number_of_rides, int number_of_ratings, 
			double average_rating)
	{
		this.aid = aid;
		this.first_name = first_name;
		this.picture = picture;
		this.number_of_rides = number_of_rides;
		this.number_of_ratings = number_of_ratings;
		this.average_rating = average_rating;
	}
	
	public Driver(int aid, String first_name, int number_of_rides, int number_of_ratings, 
			double average_rating, Detail detail)
	{
		this.aid = aid;
		this.first_name = first_name;
		this.number_of_rides = number_of_rides;
		this.number_of_ratings = number_of_ratings;
		this.average_rating = average_rating;
		this.detail = detail;
	}
	
	public int getAid() 
	{
		return aid;
	}

	public void setAid(int aid) 
	{
		this.aid = aid;
	}

	public String getFirst_name() 
	{
		return first_name;
	}

	public void setFirst_name(String first_name) 
	{
		this.first_name = first_name;
	}

	public int getNumber_of_rides() 
	{
		return number_of_rides;
	}

	public void setNumber_of_rides(int number_of_rides) 
	{
		this.number_of_rides = number_of_rides;
	}
	
	public int getNumber_of_ratings() 
	{
		return number_of_ratings;
	}

	public void setNumber_of_ratings(int number_of_ratings) 
	{
		this.number_of_ratings = number_of_ratings;
	}

	public double getAverage_rating() 
	{
		return average_rating;
	}

	public void setAverage_rating(double average_rating) 
	{
		this.average_rating = average_rating;
	}

	public Detail getDetail() 
	{
		return detail;
	}

	public void setDetail(Detail detail) 
	{
		this.detail = detail;
	}

	public String getPicture() 
	{
		return picture;
	}

	public void setPicture(String picture) 
	{
		this.picture = picture;
	}

	public int getRid() 
	{
		return rid;
	}

	public void setRid(int rid) 
	{
		this.rid = rid;
	}

	public ArrayList<Ride> getRides()
	{
		return rides;
	}

	public void setRides(ArrayList<Ride> rides) 
	{
		this.rides = rides;
	}	
	
	public void addRide(Ride r)
	{
		rides.add(r);
		number_of_rides++;
	}
	
	public ArrayList<Rating> getRatings()
	{
		return ratings;
	}

	public void setRatings(ArrayList<Rating> ratings) 
	{
		this.ratings = ratings;
	}	
	
	public void addRating(Rating rating)
	{
		ratings.add(rating);
		number_of_ratings++;
	}
}
