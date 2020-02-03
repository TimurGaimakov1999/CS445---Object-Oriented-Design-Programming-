package edu.iit.cs445.homework1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AntTest 
{
	@Test
	void test_Ant_moveStr()
	{
		Ant ant = new Ant("Anatoliy");
		assertEquals("Anatoliy Ant is crawling around.", ant.moveStr());
	}
}
