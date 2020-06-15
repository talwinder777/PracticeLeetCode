class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        
        int count = 0;
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < words.length; i++){
        //System.out.println(words[i]);
            if(map.containsKey(words[i])){
                count += map.get(words[i]);
            }
            else{
                if(checkIfSubSequence(S, words[i])){
                    count++;
                    map.put(words[i], 1);
                }
                else{
                    map.put(words[i], 0);
                }
            }
            
        }
        
        //System.out.println(map);
        return count;
    }
    
    public boolean checkIfSubSequence(String s, String ch){
        
        int chl = ch.length();
        int sl = s.length();
        
        if(chl > sl)
            return false;
        int itrch = 0, itrs = 0;
        
        while(itrch < chl && itrs < sl){
            
            if(ch.charAt(itrch) == s.charAt(itrs)){
                itrch++;
                itrs++;
            }
            else{
                itrs++;
            }
        }
        
        if(itrch != chl)
            return false;
        return true;
    }
}