package edu.iit.cs445.homework1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BatTest 
{
	@Test
	void Bat_test_eat()
	{
		Bat bat = new Bat("Com");
		Thing food = new Thing("Ant");
		
		assertEquals("Com Bat has just eaten a Ant.", bat.eatStr(food));
	}
	
	@Test
	void Bat_test_flyStr()
	{
		Bat bat = new Bat("Buzz");
		
		assertEquals("Buzz Bat is swooping through the dark.", bat.flyStr());
	}
	
	@Test
	void Bat_test_whatDidYouEat_Str()
	{
		Bat bat = new Bat("Air");
		Thing food1 = new Thing("Banana");
		Thing food2 = new Thing("Apple");
		
		bat.eatStr(food1);
		bat.eatStr(food2);
		
		assertEquals("Air Bat has eaten a Apple", bat.whatDidYouEat_Str());
	}
}
