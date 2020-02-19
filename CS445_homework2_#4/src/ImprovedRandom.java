import java.util.Random;

public class ImprovedRandom extends Random
{
	private int num1, num2;
	
	public ImprovedRandom(int num1, int num2)
	{
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int RandomTwo(int num1, int num2)
	{
		Random random = new Random();
		int randomInt = num1 + random.nextInt(num2 - num1);
		return randomInt;
	}
	
	public int getNum1()
	{
		return num1;
	}
	
	public int getNum2()
	{
		return num2;
	}
}
