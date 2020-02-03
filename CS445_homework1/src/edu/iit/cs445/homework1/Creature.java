package edu.iit.cs445.homework1;

import java.util.ArrayList;

public abstract class Creature extends Thing
{	
	private ArrayList<String> stomach;
	
	public Creature(String name) 
	{
		super(name);
		stomach = new ArrayList<String>();
	}
	
	public void eat(Thing aThing)
	{
		System.out.println(this.toString() + " has just eaten a " + aThing.toString() + ".");
		stomach.add(aThing.toString());
	}
	
	public String eatStr(Thing aThing)
	{
		stomach.add(aThing.toString());
		return this.toString() + " has just eaten a " + aThing.toString() + ".";
	}
	
	public abstract void move();
	
	public ArrayList<String> showStomach()
	{
		return stomach;
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