import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class Test_ImprovedStringTokenizer 
{
	@Test
	void test_returnString()
	{
		ImprovedStringTokenizer improve = new ImprovedStringTokenizer("This class is easy");
		ArrayList<String> arr = new ArrayList<String>();
		int beginIndex = 0, endIndex = 0;
		for(int i = 0; i < improve.getSentence().length(); i++)
		{
			if(improve.getSentence().charAt(i) == ' ') //checks for the white spaces between words to separate
			{
				String str = improve.getSentence().substring(beginIndex, endIndex);
				beginIndex = endIndex + 1;
				arr.add(str);
			}
			else if(i == improve.getSentence().length() - 1) //checks for the last letter in the string to separate the last word
			{
				String str = improve.getSentence().substring(beginIndex, endIndex + 1);
				arr.add(str);
			}
			endIndex++;
		}
		assertEquals(arr, improve.returnString(improve.getSentence()));
	}
}
