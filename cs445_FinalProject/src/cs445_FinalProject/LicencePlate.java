package cs445_FinalProject;

public class LicencePlate 
{
	private String licencePlate_number;
	private String state;
	
	public LicencePlate(String licencePlate_number, String state)
	{
		this.licencePlate_number = licencePlate_number;
		this.state = state;
	}
	
	public String getNumber()
	{
		return licencePlate_number;
	}
	
	public void setNumber(String licencePlate_number)
	{
		this.licencePlate_number = licencePlate_number;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
}
