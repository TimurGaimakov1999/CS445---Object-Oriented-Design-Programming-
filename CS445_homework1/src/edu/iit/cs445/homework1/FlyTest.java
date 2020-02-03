package edu.iit.cs445.homework1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FlyTest 
{
	@Test
	void Fly_test_eat()
	{
		Fly fly = new Fly("Ich");
		Thing food = new Thing("Ant");
		
		assertEquals("Ich Fly won't eat a Ant.", fly.eatStr(food));
	}
	
	@Test
	void Fly_test_flyStr()
	{
		Fly fly = new Fly("Buzz");
		
		assertEquals("Buzz Fly is buzzing around in flight.", fly.flyStr());
	}
	
	@Test
	void Fly_test_whatDidYouEat_Str()
	{
		Fly fly = new Fly("Air");
		Thing food1 = new Thing("Banana");
		Thing food2 = new Thing("Apple");
		
		fly.eatStr(food1);
		fly.eatStr(food2);
		
		assertEquals("Air Fly has eaten a Apple", fly.whatDidYouEat_Str());
	}
}
