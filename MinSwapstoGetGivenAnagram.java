package practiceCoding;

public class MinSwapstoGetGivenAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s1 = {'a','b','c','d'};
		char[] s2 = {'c','d','a','b'};
		
		int minSwaps = getMinSwaps(s1, s2);
		System.out.println(minSwaps);
	}

	private static int getMinSwaps(char[] s1, char[] s2) {
		// TODO Auto-generated method stub
		int len = s2.length;
		int i = 0, j = 0, res = 0;
		
		while(i < len) {
			j = i;//j(corresponds to s1) is the index of the Char at ith position in s2
			
//			basically have to reach this below state
//			a b c d  c b a d
//			    j    i 
			
			// loops finds the invalid position of (char of s2) in s1
			while(s1[j] != s2[i]) {
				j += 1;
			}
			
			//once found the invalid position, move the character in s1 to its exact poisition that is ith position
//			basically have to reach this below state
//			c a b d  c b a d
//			j        i 
			
			while(j > i) {
				swap(j, j-1, s1);
				j -= 1;
				res += 1;
			}
			i += 1;
		}
		return res;
	}

	private static void swap(int i, int j, char[] s1) {
		// TODO Auto-generated method stub
		char temp = s1[i];
		s1[i] = s1[j];
		s1[j] = temp;
	}

}
