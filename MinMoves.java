package practiceCoding;

/*PROBLEM STATEMENT
 * https://leetcode.com/discuss/interview-question/398026/ ------ at this link
 * */

// Time complexity - O(n)
public class MinMoves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int minMoves = getMinMoves("aaabb");
		System.out.println(minMoves);
	}

	private static int getMinMoves(String string) {
		// TODO Auto-generated method stub
		
		int minMoves = 0;
		for(int i = 0; i < string.length(); i++) {
			
			int runningLength = 1;
			//calculate for how long the consecutive seq goes on and then just divide by 3
			while(i+1 < string.length() && string.charAt(i) == string.charAt(i+1)) {
				runningLength++;
				i++;
			}
			
			minMoves += runningLength / 3;
		}
		
		return minMoves;
	}
	

}
