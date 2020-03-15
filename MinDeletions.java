package practiceCoding;

import java.util.*;
/*PROBLEM STATEMENT
 * Given a string s consisting of n lowercase letters, you have to delete the minimum number of characters from s so that every letter in s 
 * appears a unique number of times. We only care about the occurrences of letters that appear at least once in result.
 * 
 * 
 * Input: "eeeeffff"
Output: 1
Explanation:
We can delete one occurence of 'e' or one occurence of 'f'. Then one letter will occur four times and the other three times.


Input: "aabbffddeaee"
Output: 6
Explanation:
For example, we can delete all occurences of 'e' and 'f' and one occurence of 'd' to obtain the word "aabbda".
Note that both 'e' and 'f' will occur zero times in the new word, but that's fine, since we only care about the letter that appear at least once.
 * */

public class MinDeletions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abcdef";
		int res = minDeletions(input);
		System.out.println(res);
	}

	private static int minDeletions(String input) {
		// TODO Auto-generated method stub
		int maxFrequencyOfCharacter = 1;
		
		// make map of characters frequency and also along the way note down the maximum freq
		HashMap<Character, Integer> charFrequency = new HashMap<>();
		for(char c : input.toCharArray()) {
			if(charFrequency.containsKey(c)) {
				charFrequency.put(c, charFrequency.get(c) + 1);
				maxFrequencyOfCharacter = Math.max(maxFrequencyOfCharacter, charFrequency.get(c));
			}
			else {
				charFrequency.put(c, 1);
			}
		}
		
		//Array noting the number of time a particular frequency has occurred
		int repetitionOfFrequency[] = new int[maxFrequencyOfCharacter+1];
		
		for(int freq : charFrequency.values()) {
			repetitionOfFrequency[freq]++;
		}
		
		
		int res = 0;
		while(maxFrequencyOfCharacter > 0) {
			int addToLowerIndex = repetitionOfFrequency[maxFrequencyOfCharacter] > 1 ? repetitionOfFrequency[maxFrequencyOfCharacter] - 1 : 0;
			//adding to res only if the current value of array is greater than 1
			res += repetitionOfFrequency[maxFrequencyOfCharacter] > 1 ? repetitionOfFrequency[maxFrequencyOfCharacter] - 1 : 0;
			repetitionOfFrequency[maxFrequencyOfCharacter - 1] += addToLowerIndex;
			maxFrequencyOfCharacter--;
		}
		return res;
	}

}
