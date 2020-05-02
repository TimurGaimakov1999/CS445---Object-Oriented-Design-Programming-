package org.timur.sar.model;

import java.util.Date;

public class Message 
{
	private int mid;
	private int aid;
	private String message;
	private Date date;
	
	public Message()
	{
		this.mid = (int)(Math.random() * 1000);
	}
	
	public Message(int mid)
	{
		this.mid = mid;
	}

	public Message(int aid, String message)
	{
		this.aid = aid;
		this.message = message;
	}
	
	public Message(int mid, int sent_by_aid, Date date, String message)
	{
		this.mid = mid;
		this.aid = sent_by_aid;
		this.date = date;
		this.message = message;
	}

	public int getMid() 
	{
		return mid;
	}

	public void setMid(int mid) 
	{
		this.mid = mid;
	}

	public int getAid() 
	{
		return aid;
	}

	public void setAid(int aid) 
	{
		this.aid = aid;
	}

	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message) 
	{
		this.message = message;
	}

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}	
}
