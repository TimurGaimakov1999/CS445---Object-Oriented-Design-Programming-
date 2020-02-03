package edu.iit.cs445.homework1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Tiger extends Creature
{	
	public Tiger(String name) 
	{
		super(name);
	}

	@Override
	public void move()
	{
		System.out.println(this.toString() + " has just pounced.");
	}
	
	public String moveStr()
	{
		return this.toString() + " has just pounced.";
	}
}