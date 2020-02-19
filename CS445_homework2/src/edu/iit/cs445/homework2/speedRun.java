package edu.iit.cs445.homework2;

public class speedRun 
{
	private int speed;
	private Food food;
	
	public speedRun(int speed)
	{
		this.speed = speed;
	}
	
	public int runFaster(int speed)
	{
		speed = speed + 10;
		return speed;
	}
}
