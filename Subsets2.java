class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        makeSubsets(res, nums, 0, new ArrayList<Integer>(), new HashSet<>());
        
        return res;
    }
    
    public void makeSubsets(List<List<Integer>> res, int[] nums, int index, List<Integer> in, Set<List<Integer>> s){
           
        if(!s.contains(in)){
            res.add(new ArrayList<>(in));
            s.add(new ArrayList<>(in));}
        for(int i = index; i < nums.length; i++){
            in.add(nums[i]);
            //System.out.println("i = "+i+"index ="+ index+" list = "+in);
            makeSubsets(res, nums, i+1, in, s);
            in.remove(in.size()-1);
            //System.out.println("after i = "+i+"index ="+ index+" list = "+in);
        }
    }
    /*
    Without using set
    
    class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        process(nums, new ArrayList<Integer>(), 0, res);
        return res;
    }
    
    public void process(int[] nums, List<Integer> temp, int index, List<List<Integer>> res){
        res.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            process(nums, temp, i + 1, res);
            temp.remove(temp.size() - 1);
        }
    }
}
    
    */
}