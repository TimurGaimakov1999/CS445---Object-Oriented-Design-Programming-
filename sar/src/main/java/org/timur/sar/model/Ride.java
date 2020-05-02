package org.timur.sar.model;

public class Ride 
{
	private int aid;
	private int rid;
	private Location_info location_info;
	private Date_time date_time;
	private Car_info car_info;
	private int max_passengers;
	private double amount_per_passenger;
	private String conditions;
	
	public Ride()
	{
		this.rid = (int)(Math.random() * 1000);
	}
	
	public Ride(int aid, Location_info location_info, Date_time date_time, Car_info car_info,
			int max_passengers, double amount_per_passenger, String conditions)
	{
		this.aid = aid;
		this.location_info = location_info;
		this.date_time = date_time;
		this.car_info = car_info;
		this.max_passengers = max_passengers;
		this.amount_per_passenger = amount_per_passenger;
		this.conditions = conditions;
	}
	
	public Ride(int rid, Location_info location_info, Date_time date_time)
	{
		this.rid = rid;
		this.location_info = location_info;
		this.date_time = date_time;
	}
	
	public Ride(int rid)
	{
		this.rid = rid;
	}

	public int getAid() 
	{
		return aid;
	}

	public void setAid(int aid) 
	{
		this.aid = aid;
	}

	public int getRid() 
	{
		return rid;
	}

	public void setRid(int rid) 
	{
		this.rid = rid;
	}

	public Location_info getLocation_info() 
	{
		return location_info;
	}

	public void setLocation_info(Location_info location_info) 
	{
		this.location_info = location_info;
	}

	public Date_time getDate_time() 
	{
		return date_time;
	}

	public void setDate_time(Date_time date_time) 
	{
		this.date_time = date_time;
	}

	public Car_info getCar_info() 
	{
		return car_info;
	}

	public void setCar_info(Car_info car_info) 
	{
		this.car_info = car_info;
	}

	public int getMax_passengers() 
	{
		return max_passengers;
	}

	public void setMax_passengers(int max_passengers) 
	{
		this.max_passengers = max_passengers;
	}

	public double getAmount_per_passenger() 
	{
		return amount_per_passenger;
	}

	public void setAmount_per_passenger(double amount_per_passenger) 
	{
		this.amount_per_passenger = amount_per_passenger;
	}

	public String getConditions() 
	{
		return conditions;
	}

	public void setConditions(String conditions) 
	{
		this.conditions = conditions;
	}
	
	public boolean matchesId(int rid) 
    {
        return (rid == this.rid);
    }
}
