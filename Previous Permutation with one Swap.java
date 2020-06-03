class Solution {
    public int[] prevPermOpt1(int[] A) {
        //Key things
       
        
        // The part which is strictly incresing from backside is always the last exhausted permutation
        // eg 1 4 3 2. this means that we when we are exploring options for 1.....4 3 2 is the last permutation we can achieve. 
        // in order to guess the next permutation for 1 4 3 2
        // 1) we need to find the next greatest number after 1 and swap those number i:e 2 4 3 1(last permutation for 2)
         //2) In order to find the smallest and next permuation we need to reverse the order of 4 3 1 to 1 4 3
        
        
        
        
        
        
        /*
        The Solution is just the opposite of finding the next permutation
            1) go towards left till the array is stricly decreasing in order to find the number say "a" for which the possibilities are being explored
            2) Now find the largest smaller number than a
            3) Swap these number to find your res
        */
        int i;
        
        //go towards left till the array is stricly decreasing
        for(i = A.length - 1; i > 0; i--){
            //System.out.println("i = "+i)
            if(A[i-1] <= A[i])
                continue;
            else
                break;
        }
        if(i == 0)
            return A;
        int number = A[i-1]; //store the number and find the next number which is largest in the array from i+1 pos to length but also smaller than this number
        int l = i-1;
        
        int r = i-1;
        
        for(int j = i; j < A.length; j++){
            if(A[j] < number){
               r = j;
                // in order the skip the probable duplicate next numbers
               while(j + 1 < A.length && A[j + 1] == A[j])
                   j++;
            }
        }
        
        //System.out.println("r = "+r);
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
        return A;
    }
}