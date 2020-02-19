package edu.iit.cs445.homework2;

public class Food 
{
	private String food;
	
	public Food(String food)
	{
		this.food = food;
	}
	
	public String eat(String food)
	{
		return "This animal has just eaten a " + food;
	}
}
