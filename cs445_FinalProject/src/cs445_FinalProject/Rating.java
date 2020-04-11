package cs445_FinalProject;

public class Rating
{
	private int number_of_ratings;
	private double average_rating;
	private String comment;
	
	public Rating(int number_of_ratings, double average_rating, String comment)
	{
		this.number_of_ratings = number_of_ratings;
		this.average_rating = average_rating;
		this.comment = comment;
	}
	
	public Rating(int number_of_ratings, double average_rating)
	{
		this.number_of_ratings = number_of_ratings;
		this.average_rating = average_rating;
	}
	
	public int getNumber_of_Ratings()
	{
		return number_of_ratings;
	}
	
	public double getAverage_Rating()
	{
		return average_rating;
	}
	
	public String getComments()
	{
		return comment;
	}
}
