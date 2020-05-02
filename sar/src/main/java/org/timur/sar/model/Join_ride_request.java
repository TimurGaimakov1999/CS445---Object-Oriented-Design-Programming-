package org.timur.sar.model;

public class Join_ride_request 
{
	private int aid;
	private int jid;
	private int passengers;
	private Boolean ride_confirmed;
	private Boolean pickup_confirmed;
	
	public Join_ride_request()
	{
		this.jid = (int)(Math.random() * 1000);
	}

	public Join_ride_request(int aid, int passengers, Boolean ride_confirmed, Boolean pickup_confirmed) 
	{
		this.aid = aid;
		this.passengers = passengers;
		this.ride_confirmed = ride_confirmed;
		this.pickup_confirmed = pickup_confirmed;
	}

	public Join_ride_request(int aid, Boolean ride_confirmed) 
	{
		this.aid = aid;
		this.ride_confirmed = ride_confirmed;
	}
	
	public Join_ride_request(int jid) 
	{
		this.jid = jid;
	}
	
	public int getAid() 
	{
		return aid;
	}

	public void setAid(int aid) 
	{
		this.aid = aid;
	}

	public int getJid() 
	{
		return jid;
	}

	public void setJid(int jid) 
	{
		this.jid = jid;
	}

	public int getPassengers() 
	{
		return passengers;
	}

	public void setPassengers(int passengers) 
	{
		this.passengers = passengers;
	}

	public Boolean getRide_confirmed() 
	{
		return ride_confirmed;
	}

	public void setRide_confirmed(Boolean ride_confirmed) 
	{
		this.ride_confirmed = ride_confirmed;
	}

	public Boolean getPickup_confirmed() 
	{
		return pickup_confirmed;
	}

	public void setPickup_confirmed(Boolean pickup_confirmed) 
	{
		this.pickup_confirmed = pickup_confirmed;
	}
}
