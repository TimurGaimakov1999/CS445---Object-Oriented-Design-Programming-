package cs445_FinalProject;

public class Account 
{
	private String first_name;
	private String last_name;
	private String cell_phone_number;
	private String picture;
	private boolean isActivated;
	
	public Account(String first_name, String last_name, String cell_phone_number, String picture)
	{
		this.first_name = first_name;
		this.last_name = last_name;
		this.cell_phone_number = cell_phone_number;
		this.picture = picture;
		isActivated = false;
	}
	
	public String getFirstName()
	{
		return first_name;
	}
	
	public String getLastName()
	{
		return last_name;
	}
	
	public String getCell_phone_number()
	{
		return cell_phone_number;
	}
	
	public String toString()
	{
		return "First name:" + first_name + "\nLast name: " + last_name + "\nPhone number: " + cell_phone_number;
	}
	
	public boolean getActivationStatus()
	{
		return isActivated;
	}
	
	public String getPicture()
	{
		return picture;
	}
	
	public void accountActivation()
	{
		isActivated = true;
	}
}
