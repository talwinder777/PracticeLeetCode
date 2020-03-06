package practiceCoding;


/*PROBLEM STATEMENT
 * https://leetcode.com/discuss/interview-question/364760/        good question
 * 
 * 
 * 
 * Explanation:

		1. edgeCount is of size N+1 hence we can fetch a city node's edges by it's number directly. 
			Example, if the edge is 1-> 4, then edgeCount's state will be [0, 1, 0, 0, 1]
		2. first loop - iterates over A and B arrays and adds edges for both nodes
		3. second loop - iterates over both A and B at the same time, we collect the total count of edges for both A[i] node and B[i] node. Since the edges are bidirectional, 
			the sum will count the same edge twice A[i] -> B[i] and B[i] -> A[i]. So we deduct 1 to remove duplicate. With the example from 1) if the edge is 1-> 4, then edgeCount's 
			state will be [0, 1, 0, 0, 1], sum will be equal to 2 and then we deduct 1 duplicate edge -> total rank is 1.
		4. We compare the current rank for the pair of nodes with the max known value so far, and if the current rank is bigger we save that.
 * */

public class MaxNetworkRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1,2,3,3};
		int B[] = {2,3,1,4};
		int noOfCities = 4;
		System.out.println(maxNetworkRank(A, B, noOfCities));
	}

	private static int maxNetworkRank(int[] a, int[] b, int noOfCities) {
		// TODO Auto-generated method stub
		int maxNumberOfRoads = Integer.MIN_VALUE;
		int localMax = 0;
		
		int[] edgeCount = new int[noOfCities+1];
		for(int i = 0; i < a.length; i++) {
			edgeCount[a[i]]++;
			edgeCount[b[i]]++;
		}
		
		for(int i = 0; i < a.length; i++) {
			//calculating the number of roads for ith pair of cities, storing the maximum in maxNumberOfRoads
			//add number of roads of a[i] + number of roads of b[i]
			localMax = edgeCount[a[i]] + edgeCount[b[i]] - 1;// -1 because since road from a[i] -> b[i] is counted twice, so to remove duplicates -1 is done
			maxNumberOfRoads = Math.max(localMax, maxNumberOfRoads);
		}
		return maxNumberOfRoads;
	}

}
