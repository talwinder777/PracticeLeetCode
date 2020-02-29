package practiceCoding;
import java.util.*;
import java.util.Map.Entry;
public class NumbersWithEqualDigitSumM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {51, 17, 71, 42}; 
//		int[] arr = {42, 33, 60}; 
		int[] arr = {51, 17, 7}; 
		
		
		int result = getMaxSumPair(arr);
		System.out.println(result);
	}

	private static int getMaxSumPair(int[] arr) {
		// TODO Auto-generated method stub
		
		Map<Integer, List<Integer>> m = new HashMap<>();
		
		for(int number : arr) {
			int digitSum = getDigitSum(number);
			if(!m.containsKey(digitSum)) {
				m.put(digitSum, new ArrayList<Integer>());
				
			}
//			else {
//				m.get(digitSum).add(number);
//			}
			m.get(digitSum).add(number);
		}
		if(m.size() == arr.length)
			return -1;
		int maximum = Integer.MIN_VALUE;
		
		for(Entry<Integer, List<Integer>> entry : m.entrySet()) {
			List<Integer> l = entry.getValue();
			Collections.sort(l);
			int size = l.size();
			
			if(size > 1)
				maximum = Math.max(l.get(l.size()-1) + l.get(l.size()-2), maximum);
		}
		return maximum;
	}

	private static int getDigitSum(int number) {
		// TODO Auto-generated method stub
		//int q = number;
		int sum = 0;
		while(number > 0) {
			
			int r = number % 10;
			sum += r;
			number = number / 10;
		}
		
		return sum;
	}

}
