package org.timur.sar.model;

import java.util.ArrayList;

public class Detail 
{
	private int rid;
	private int sent_by_id;
	private String first_name;
	private String date;
	private int rating;
	private String comment;
	private Location_info location_info;
	private Date_time date_time;
	private Car_info car_info;
	private String picture;
	private int rides;
	private int ratings;
	private double average_rating;
	private ArrayList<Rating> comments_about_driver;
	
	public Detail()
	{
		
	}
	
	public Detail(int rid, int sent_by_id, String first_name,
					String date, int rating, String comment)
	{
		this.rid = rid;
		this.sent_by_id = sent_by_id;
		this.first_name = first_name;
		this.date = date;
		this.rating = rating;
		this.comment = comment;
	}
	
	public Detail(int rid, Location_info location_info, Date_time date_time, Car_info car_info,
					String first_name, String picture, int rides, int ratings, double average_rating,
					ArrayList<Rating> comments_about_driver)
	{
		this.rid = rid;
		this.location_info = location_info;
		this.date_time = date_time;
		this.car_info = car_info;
		this.first_name = first_name;
		this.picture = picture;
		this.rides = rides;
		this.ratings = ratings;
		this.average_rating = average_rating;
		this.comments_about_driver = comments_about_driver;
	}

	public int getRid() 
	{
		return rid;
	}

	public void setRid(int rid) 
	{
		this.rid = rid;
	}

	public int getSent_by_id() 
	{
		return sent_by_id;
	}

	public void setSent_by_id(int sent_by_id) 
	{
		this.sent_by_id = sent_by_id;
	}

	public String getFirst_name() 
	{
		return first_name;
	}

	public void setFirst_name(String first_name) 
	{
		this.first_name = first_name;
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

	public Location_info getLocation_info() {
		return location_info;
	}

	public void setLocation_info(Location_info location_info) {
		this.location_info = location_info;
	}

	public Date_time getDate_time() {
		return date_time;
	}

	public void setDate_time(Date_time date_time) {
		this.date_time = date_time;
	}

	public Car_info getCar_info() {
		return car_info;
	}

	public void setCar_info(Car_info car_info) {
		this.car_info = car_info;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getRides() {
		return rides;
	}

	public void setRides(int rides) {
		this.rides = rides;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public double getAverage_rating() {
		return average_rating;
	}

	public void setAverage_rating(double average_rating) {
		this.average_rating = average_rating;
	}

	public ArrayList<Rating> getComments_about_driver() {
		return comments_about_driver;
	}

	public void setComments_about_driver(ArrayList<Rating> comments_about_driver) {
		this.comments_about_driver = comments_about_driver;
	}
}
