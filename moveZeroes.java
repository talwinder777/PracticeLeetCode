//Time Complexity -> O(n)
class Solution {
    /*
    Since the order of the elements must remain same so just put all the integers values to the front. Once you do that put all the left zeroes in the tail
    */
    public void moveZeroes(int[] nums) {
        int positionToPutAt = 0, pointerLookingForInteger = 0;
        
        while(pointerLookingForInteger < nums.length){
            //putting all non zeroe values to the front of array
            if(nums[pointerLookingForInteger] != 0){
                nums[positionToPutAt++] = nums[pointerLookingForInteger];
            }
            pointerLookingForInteger++;
        }
        //inserting zeroes at the left out posititions
        while(positionToPutAt < nums.length){
            nums[positionToPutAt++] = 0;
        }
    }
}