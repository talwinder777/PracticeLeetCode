
//when xoring the same numbers result in 0. At the end only the different number will remain
//Time Complexity -> Linear

class Solution {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
    }
}