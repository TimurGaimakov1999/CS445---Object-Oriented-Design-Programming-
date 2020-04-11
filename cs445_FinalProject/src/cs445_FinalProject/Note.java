package cs445_FinalProject;

public class Note 
{
	private String link;
	private String pickUp;
	private String dropOff;
	private int number_of_passengers;
	
	/**
	 * 
	 * @param number_of_passengers
	 * @param ride
	 * 
	 * This is the note for Riders to submit to Drivers
	 */
	public Note(int number_of_passengers, String pickUp, String dropOff)
	{
		this.number_of_passengers = number_of_passengers;
		this.pickUp = pickUp;
		this.dropOff = dropOff;
		link = "www." + (int)(Math.random() * 10000 + 1) + ".com";
	}
	
	public Note(int number_of_passengers, String pickUp, String dropOff, String link)
	{
		this.number_of_passengers = number_of_passengers;
		this.pickUp = pickUp;
		this.dropOff = dropOff;
		this.link = link;
	}
	
	public void setNote(int number_of_passengers, String pickUp, String dropOff)
	{
		this.number_of_passengers = number_of_passengers;
		this.pickUp = pickUp;
		this.dropOff = dropOff;
	}
	
	public int getNumber_of_People()
	{
		return number_of_passengers;
	}
	
	public String getPickUp()
	{
		return pickUp;
	}
	
	public String getDropOff()
	{
		return dropOff;
	}
	
	public String getLink()
	{
		return link;
	}
	
	public void sendNote_with_link_to_System(Systems sys)
	{
		int num_passengers = getNumber_of_People();
		String pickUps = getPickUp();
		String dropOffs = getDropOff();
		String links = getLink();
		
		sys.receiveNoteFromRider(num_passengers, pickUps, dropOffs, links); // System receives a Note
	}
	
	public String toString()
	{
		return "Number of people: " + number_of_passengers + "     \t" + "Pick up: " + pickUp + "     \t" +
				"Drop off: " + dropOff + "\n";
	}
}
