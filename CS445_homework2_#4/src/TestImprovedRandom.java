
public class TestImprovedRandom 
{
	public static void main(String[] args)
	{
		ImprovedRandom rnd = new ImprovedRandom(3, 11);
		
		System.out.println("The random number between " + rnd.getNum1() 
				+ " and " + rnd.getNum2() + " is " 
				+ rnd.RandomTwo(rnd.getNum1() , rnd.getNum2()));
	}
}
