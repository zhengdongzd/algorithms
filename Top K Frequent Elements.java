// O(n) algorihtm with the Bucket Sort
//

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] buc = new List[nums.length + 1];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int i : nums){
            if(hm.containsKey(i)){
                hm.put(i, hm.get(i)+1);
            }
            else{
                hm.put(i, 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if(buc[entry.getValue()]==null){
                buc[entry.getValue()] = new ArrayList<Integer>(); 
            }
            buc[entry.getValue()].add(entry.getKey());
        }
        
        List<Integer> res = new ArrayList<Integer>();
        
        for(int pos = buc.length - 1; (pos > 0)&&(res.size()<k); pos--){
            if(buc[pos]!=null){
                res.addAll(buc[pos]);
            }
        }
        
        return res;
        
    }
}