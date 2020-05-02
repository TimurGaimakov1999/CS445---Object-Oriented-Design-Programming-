package org.timur.sar.model;

import java.util.*;

//import org.timur.sar.database.DatabaseClass;

public class Account 
{
	private int aid;
	private String first_name;
	private String last_name;
	private String name;
	private String phone;
	private String picture;
	private boolean is_active;
	private Date date_created;
	private ArrayList<Rating> ratings;
	private int number_of_ratings;
	
	//private ArrayList<Rating> ratings_list = DatabaseClass.getRatingsList();
	
	public Account()
	{
		this.aid = (int)(Math.random() * 1000);
		ratings = new ArrayList<Rating>();
	}
	
	public Account(String first_name, String last_name, String phone, 
			String picture, boolean is_active) 
	{
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.picture = picture;
		this.is_active = is_active;
	}
	
	public Account(int aid, String first_name, String last_name, String phone, 
			String picture, boolean is_active, int number_of_ratings) 
	{
		this.aid = aid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.picture = picture;
		this.is_active = is_active;
		this.number_of_ratings = number_of_ratings;
	}
	
	public Account(int aid, String name, Date date_created, boolean is_active)
	{
		this.aid = aid;
		this.name = name;
		this.date_created = new Date();
		this.is_active = is_active;
	}
	
	public Account(int aid)
	{
		this.aid = aid;
	}
	
	public Account(int aid, String first_name, String picture, int number_of_ratings)
	{
		this.aid = aid;
		this.first_name = first_name;
		this.picture = picture;
		this.number_of_ratings = number_of_ratings;
	}
	
	public Account(int aid, String first_name)
	{
		this.aid = aid;
		this.first_name = first_name;
	}

	public int getAccountID() 
	{
		return aid;
	}

	public void setAccountID(int aid) 
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

	public String getLast_name() 
	{
		return last_name;
	}

	public void setLast_name(String last_name) 
	{
		this.last_name = last_name;
	}

	public String getPhone() 
	{
		return phone;
	}

	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPicture() 
	{
		return picture;
	}

	public void setPicture(String picture) 
	{
		this.picture = picture;
	}

	public boolean isIs_active() 
	{
		return is_active;
	}

	public void setIs_active(boolean is_active) 
	{
		this.is_active = is_active;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public Date getDate_created() 
	{
		return date_created;
	}

	public void setDate_created(Date date_created) 
	{
		this.date_created = date_created;
	}
	
	public boolean matchesId(int aid) 
    {
        return (aid == this.aid);
    }

	public ArrayList<Rating> getRatings() 
	{
		return ratings;
	}

	public void setRatings(ArrayList<Rating> ratings) 
	{
		this.ratings = ratings;
	}
	
	
	public int getNumber_of_ratings() 
	{
		return number_of_ratings;
	}

	public void setNumber_of_ratings(int number_of_ratings) 
	{
		this.number_of_ratings = number_of_ratings;
	}

	public void addRating(Rating r)
	{
		ratings.add(r);
		number_of_ratings++;
	}
	
	public double calculateAverageRating()
	{
		int sum = 0;
		for(int i = 0; i < ratings.size(); i++)
		{
			sum += (ratings.get(i)).getRating();
		}
		return (sum/ number_of_ratings);
	}
}
