//O(n) with extra memory
class Solution {
    public int majorityElement(int[] nums) {
        int lengthOfArray = nums.length;
        
        if(lengthOfArray == 1)
            return nums[0];
        
        Map<Integer, Integer> frequencyOfElements = new HashMap<>();
        
        for(int i = 0; i < lengthOfArray; i++){
            
            if(!frequencyOfElements.containsKey(nums[i])){
                frequencyOfElements.put(nums[i], 1);
            }
            else{
                frequencyOfElements.put(nums[i], frequencyOfElements.get(nums[i]) + 1);
                if(frequencyOfElements.get(nums[i]) > (lengthOfArray/2))
                    return nums[i];
            }
        }
        return 0;
    }
}

/*

O(n) without extra memory

Refered from leetcode

Boyer Moore Voting Algorithm
Essentially, what Boyer-Moore does is look for a suffix sufsuf of nums where suf[0]suf[0] is the majority element in that suffix. To do this, we maintain a count, which is incremented whenever we see an instance of our current candidate for majority element and decremented whenever we see anything else. Whenever count equals 0, we effectively forget about everything in nums up to the current index and consider the current number as the candidate for majority element. It is not immediately obvious why we can get away with forgetting prefixes of nums - consider the following examples (pipes are inserted to separate runs of nonzero count).

[7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]

class Solution {
    public int majorityElement(int[] nums) {
        int majElIndex = 0;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[majElIndex])
                count++;
            else
                count--;
            if(count == 0){
                majElIndex = i;
                count = 1;
            }
        }
        return nums[majElIndex];
    }
}
*/