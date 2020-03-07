package practiceCoding;
/*PROBLEM STATEMENT
 * You are given a string that represents time in the format hh:mm. Some of the digits are blank (represented by ?). 
 * Fill in ? such that the time represented by this string is the maximum possible. 
 * Maximum time: 23:59, minimum time: 00:00. You can assume that input string is always valid.
 */
public class MaxTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char input[] = {'?','?',':','?','?'};
		char output[] = input.clone();
		
		//written for testing all cases:-
		/*
		 * 	1. for 1st digit in clock set i <= 2 since first ranges from 0-2 and change the input[i -> 0(since testing for 1st digit)]
		 *  2. for 2ndt digit in clock set i <= 9 since 2nd ranges from 0-9 and change the input[i -> 1(since testing for 2nd digit)]
		 *  3. for 3rd digit in clock set i <= 5 since 3rd ranges from 0-5 and change the input[i -> 3(since testing for 3rd digit)]
		 *  4. for 4th digit in clock set i <= 9 since 4th ranges from 0-9 and change the input[i -> 4(since testing for 4th digit)]
		 * */
		 
		for(int i = 0; i <= 9; i++) {
			input[4] = (char)(i + '0');
			output[4] = (char)(i + '0');
			//System.out.println("input modified = "+input[4]);
			getMaxTime(input, output);
			printOutput(output);
		}
		
//		getMaxTime(input, output);
//		printOutput(output);
	}
	private static void printOutput(char[] output) {
		for(char c : output) {
			System.out.print(c);
		}
		System.out.println();
	}

	private static void getMaxTime(char[] input, char[] output) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < output.length; i++) {
			
			if(i == 0 && input[i] == '?') {
				if(input[1] == '?' || input[1] == '1' || input[1] == '2' || input[1] == '3' || input[1] == '0')
					output[0] = '2';
				else
					output[0] = '1';
			}
			else if(i == 1 && input[i] == '?') {
				if(input[0] == '1' || input[0] == '0' )
					output[1] = '9';
				else
					output[1] = '3';			
			}
			else if(i == 2) {
				output[i] = ':';
			}
			else if(i == 3 && input[i] == '?') {
				output[i] = '5';
			}
			else if(i == 4 && input[i] == '?') {
				output[i] = '9';			
			}
		}
		
	}
	

}
