package practiceCoding;

/* package codechef; // don't place package name! */
// CREDIT GOES TO mjrockz2811(solution provider)

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

/*PROBLEM STATEMENT
 * Given a string, what is the minimum number of adjacent swaps required to convert a string into a palindrome. If not possible, return -1.
   Practice online: https://www.codechef.com/problems/ENCD12
   
 /**
     * Algorithm:
     *     1. First check the given string is a jumbled/shuffled palindrome or not.
     *     2. Next have two pointers p1 at 0 and p2 at s.length - 1 and start iterating.
     *     3. If chars at both the pointers are same then just shrink the window (increase the p1 and decrease the p2).
     *     4. or Else
     *          a. find the matching pair and swap the char to p2 index (increase swap count while swapping) and finally shrink the window.
     *          b. if not found just swap once with adjacent index and increase the swap count (do not shrink the window here)
     *     5. Print the Swap Count
     *
     * Time Complexity: O(n) to find Palindrome + [ O(n) for two pointer iteration * O(n) for checking and swapping ] so => O(n^2)
     * Space Complexity: O(n)
     *
     */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner in = new Scanner(System.in);
		String s = in.next();
		while(!s.equals("0")){
		    //System.out.println(getNoOfSwaps(s));
		    if(getNoOfSwaps(s) == -1)
		        System.out.println("Impossible");
		    else
		        System.out.println(getNoOfSwaps(s));
		    s = in.next();
		}
	}
	 private static int getNoOfSwaps(String s) {
        if(s == null || s.length() == 0) return -1;
        int totalSwaps = 0;

        if(isShuffledPalindrome(s)) {
            char[] chars = s.toCharArray();
            int p1 = 0, p2 = chars.length - 1;

            while(p2 > p1) {
                if(chars[p1] != chars[p2]) {
                    int k = p2;
                    while(k > p1 && chars[k] != chars[p1]) k--;

                    if(k == p1) { //When no matching character found
                        swap(chars, p1, p1 + 1);
                        totalSwaps++;

                    } else { //When Matching character found swap until K reaches p2 position
                        while(k < p2) {
                            swap(chars, k, k + 1);
                            totalSwaps++;
                            k++;
                        }
                        p1++; p2--;
                    }
                } else {
                    p1++; p2--; //When the characters are equal move on
                }
            }
            return totalSwaps;
        }
        else return -1;
    }
    
     private static void swap(char[] chars, int k, int i) {
        char temp = chars[k];
        chars[k] = chars[i];
        chars[i] = temp;
    }
    
    private static boolean isShuffledPalindrome(String s) {
        int [] occurrence = new int[26];
        int oddCount = 0;
        //System.out.println("s = "+s);
        for(int i = 0; i < s.length(); i++) occurrence[s.charAt(i) - 'a']++;
        for (int value : occurrence) if (value % 2 != 0) oddCount++;
        return oddCount <= 1;
    }
}

