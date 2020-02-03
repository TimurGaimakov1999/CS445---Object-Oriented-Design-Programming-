package edu.iit.cs445.homework1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TigerTest 
{
	@Test
	void test_Tiger_moveStr()
	{
		Tiger meow = new Tiger("Pinky");
		assertEquals("Pinky Tiger has just pounced.", meow.moveStr());
	}
}
