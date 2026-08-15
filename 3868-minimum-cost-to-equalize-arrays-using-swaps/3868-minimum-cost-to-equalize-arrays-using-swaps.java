import java.util.*;

class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        int[] torqavemin = nums1;
        int n = nums1.length;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int x : nums1) map.put(x, map.getOrDefault(x,0)+1);
        for(int x : nums2) map.put(x, map.getOrDefault(x,0)+1);
        
        for(int v : map.values()){
            if(v % 2 != 0) return -1;
        }
        
        Map<Integer,Integer> c1 = new HashMap<>();
        Map<Integer,Integer> c2 = new HashMap<>();
        
        for(int x : nums1) c1.put(x, c1.getOrDefault(x,0)+1);
        for(int x : nums2) c2.put(x, c2.getOrDefault(x,0)+1);
        
        int diff = 0;
        
        for(int k : map.keySet()){
            int a = c1.getOrDefault(k,0);
            int b = c2.getOrDefault(k,0);
            diff += Math.abs(a-b);
        }
        
        return diff/4;
    }
}