package org.timur.sar.model;

public class Rating 
{
	private int rid;
	private int sid;
	private int sent_by_id;
	private int rating;
	private String comment;
	
	public Rating()
	{
		this.sid = (int)(Math.random() * 1000);
	}
	
	public Rating(int rid, int sent_by_id, int rating, String comment)
	{
		this.rid = rid;
		this.sent_by_id = sent_by_id;
		this.rating = rating;
		this.comment = comment;
	}
	
	public Rating(int sid)
	{
		this.sid = sid;
	}

	public int getRid() 
	{
		return rid;
	}

	public void setRid(int rid) 
	{
		this.rid = rid;
	}

	public int getSid() 
	{
		return sid;
	}

	public void setSid(int sid) 
	{
		this.sid = sid;
	}

	public int getSent_by_id() 
	{
		return sent_by_id;
	}

	public void setSent_by_id(int sent_by_id) 
	{
		this.sent_by_id = sent_by_id;
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
