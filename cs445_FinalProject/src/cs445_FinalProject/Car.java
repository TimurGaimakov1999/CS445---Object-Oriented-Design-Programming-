package cs445_FinalProject;

public class Car 
{
	private String make;
	private String model;
	private String color;
	private LicencePlate plate;
	
	public Car(String make, String model, String color, 
			LicencePlate plate)
	{
		this.make = make;
		this.model = model;
		this.color = color;
		this.plate = plate;
	}
	
	public String getMake()
	{
		return make;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public String getPlateNumber()
	{
		return plate.getNumber();
	}
	
	public String getPlateState()
	{
		return plate.getState();
	}
}
