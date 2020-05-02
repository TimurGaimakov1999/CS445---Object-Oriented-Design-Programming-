package org.timur.sar.model;

public class Comments_about 
{
	private int rid;
	private String date;
	private int rating;
	private String comment;
	
	public Comments_about()
	{
		
	}

	public Comments_about(int rid, String date, int rating, String comment)
	{
		this.rid = rid;
		this.date = date;
		this.rating = rating;
		this.comment = comment;
	}

	public int getRid() 
	{
		return rid;
	}

	public void setRid(int rid) 
	{
		this.rid = rid;
	}

	public String getDate() 
	{
		return date;
	}

	public void setDate(String date) 
	{
		this.date = date;
	}

	public int getRating() 
	{
		return rating;
	}

	public void setRating(int rating) 
	{
		this.rating = rating;
	}

	public String getComment() 
	{
		return comment;
	}

	public void setComment(String comment) 
	{
		this.comment = comment;
	}
}
