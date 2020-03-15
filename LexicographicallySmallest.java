package practiceCoding;

public class LexicographicallySmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcyfzd";
		String s1 = "abcd";//aybzd
		
		String res = smallestString("a");
		System.out.println(res);
	}

	private static String smallestString(String s) {
		// TODO Auto-generated method stub
		
		
		for(int i = 0; i < s.length(); i++) {
			
			if(i + 1 < s.length() && s.charAt(i) > s.charAt(i+1))
			{
				return s.substring(0, i) + s.substring(i+1, s.length());
			}
			
		}
		
		
		return s.substring(0,s.length()-1);
		
	}

}
