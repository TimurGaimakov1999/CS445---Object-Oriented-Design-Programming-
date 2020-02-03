package edu.iit.cs445.homework1;

import java.util.ArrayList;

public class Bat extends Creature implements Flyer
{
	private ArrayList<String> stomach;
	
	public Bat(String name)
	{
		super(name);
		stomach = new ArrayList<String>();
	}
	
	public void eat(Thing aThing)
	{
		String convert = aThing.toString();
		if(convert.equals("Ant") || convert.equals("Fly") || convert.equals("Bat") || convert.equals("Tiger"))
		{
			System.out.println(this.toString() + " has just eaten a " + convert + ".");
		}
		else
		{
			System.out.println(this.toString() + " won't eat a " + convert + ".");
			stomach.add(aThing.toString());
		}		
	}
	
	/**
	 * @param Thing
	 * @return a String that indicates whether or not Fly will eat a Thing
	 */
	public String eatStr(Thing aThing)
	{
		String convert = aThing.toString();
		if(convert.equals("Ant") || convert.equals("Fly") || convert.equals("Bat") || convert.equals("Tiger"))
		{
			return this.toString() + " has just eaten a " + convert + ".";
		}
		else
		{
			stomach.add(aThing.toString());
			return this.toString() + " won't eat a " + convert + ".";
		}
	}
	
	public ArrayList<String> showStomach()
	{
		return stomach;
	}
	
	@Override
	public void move() 
	{
		fly();
		flyStr();
	}
	
	public void fly()
	{
		System.out.println(this.toString() + " is swooping through the dark.");
	}
	
	public String flyStr()
	{
		return this.toString() + " is swooping through the dark.";
	}
	
	public void whatDidYouEat()
	{
		if(stomach.size() == 0)
		{ 
			System.out.println(this.toString() + " has had nothing to eat.");
		}
		else
		{
			System.out.println(this.toString() + " has eaten a " + stomach.get(stomach.size() - 1));
		}
	}
	
	public String whatDidYouEat_Str()
	{
		if(stomach.size() == 0)
		{ 
			return this.toString() + " has had nothing to eat.";
		}
		else
		{
			return this.toString() + " has eaten a " + stomach.get(stomach.size() - 1);
		}
	}
}
