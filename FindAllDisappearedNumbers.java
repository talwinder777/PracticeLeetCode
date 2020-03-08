class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //Approach
        /*if iterating through array we will never able to access the missing number index like since 5 and 6 are missing we will never see that index in the array
          So. Keep on negating the number until the end of the array.
          Last look for positve values indexes
        */
        List<Integer> missing = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int number = nums[i];
            //if number is negative so to reach that index make it positve
            if(number < 0)
                number = -1 * number;
            
            if(nums[number - 1] > 0)
                nums[number - 1] = -1 * nums[number - 1];
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                missing.add(i+1);
        }
        return missing;
    }
}