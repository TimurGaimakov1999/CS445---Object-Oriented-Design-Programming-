package edu.iit.cs445.homework1;

public class TestCreature 
{
	public static final int THING_COUNT = 6;
	public static final int CREATURE_COUNT = 10;
	
	public static void main(String[] args)
	{	
		Thing[] thing = new Thing[8];
		thing[0] = new Thing("Banana");
		thing[1] = new Thing("Orange");
		thing[2] = new Thing("Meat");
		thing[3] = new Thing("Ant");
		thing[4] = new Tiger("Alex");
		thing[5] = new Ant("Bob");
		thing[6] = new Fly("Clara");
		thing[7] = new Bat("Dan");
		
		
		Creature[] creature = new Creature[4];
		creature[0] = new Tiger("Alex");
		creature[1] = new Ant("Anatoliy");
		creature[2] = new Fly("Fire");
		creature[3] = new Bat("Art");
		
		
		System.out.println("Things: \n");
		for (int i = 0; i < thing.length; i++)
		{
			System.out.println(thing[i].toString());
		}
		
		System.out.println("\n\nCreatures: \n");
		for (int i = 0; i < creature.length; i++)
		{
			System.out.println(creature[i].toString());
			creature[i].move();
		}
	}
}
