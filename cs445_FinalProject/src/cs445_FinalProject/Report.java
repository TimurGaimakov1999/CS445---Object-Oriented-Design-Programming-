package cs445_FinalProject;

public class Report 
{
	private String start_date;
	private String end_date;
	private int departure_zip_code;
	private int arrival_zip_code;
	
	public Report(String start_date, String end_date, int departure_zip_code, int arrival_zip_code)
	{
		this.start_date = start_date;
		this.end_date = end_date;
		this.departure_zip_code = departure_zip_code;
		this.arrival_zip_code = arrival_zip_code;
	}
	
	public String getStartDate()
	{
		return start_date;
	}
	
	public String getEndDate()
	{
		return end_date;
	}
	
	public int getDepartureZipCode()
	{
		return departure_zip_code;
	}
	
	public int getArrivalZipCode()
	{
		return arrival_zip_code;
	}
}
