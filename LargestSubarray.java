package practiceCoding;

import java.util.Arrays;

public class LargestSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {1,4,3,2,5};
		int lengthOfSubArray = 2;
		int index = getLargestSubArray(input, lengthOfSubArray);
		for(int i = index; i < index + lengthOfSubArray; i++) {
			System.out.print(input[i]);
		}
	}

	private static int getLargestSubArray(int[] input, int k) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		int startIndexOfSubArray = 0;
		for(int i = 0; i < input.length - k + 1; i++) {
			if(input[i] > max) {
				max = input[i];
				startIndexOfSubArray = i;
			}
		}
		System.out.println("max = "+max+" i "+startIndexOfSubArray);
		return startIndexOfSubArray;
	}

}
