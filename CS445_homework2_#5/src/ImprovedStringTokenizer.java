import java.util.StringTokenizer;
import java.util.ArrayList;

public class ImprovedStringTokenizer
{
	private String sentence;
	
	public ImprovedStringTokenizer(String sentence)
	{
		this.sentence = sentence;
	}
	
	public ArrayList<String> returnString(String sentence)
	{
		StringTokenizer st = new StringTokenizer(sentence);
		ArrayList<String> arr = new ArrayList<String>();
		
		while(st.hasMoreTokens())
		{
			sentence = st.nextToken();
			arr.add(sentence);
		}
		return arr;
	}
	
	public String getSentence()
	{
		return sentence;
	}
}
