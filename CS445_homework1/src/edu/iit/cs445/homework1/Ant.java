package edu.iit.cs445.homework1;

public class Ant extends Creature
{
	public Ant(String name) 
	{
		super(name);
	}

	@Override
	public void move() 
	{
		System.out.println(this.toString() + " is crawling around.");	
	}
	
	public String moveStr()
	{
		return this.toString() + " is crawling around.";
	}
}
