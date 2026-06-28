class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = -1;
        
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                
                int dist = Math.abs(i - startIndex);
                
                int wrapAroundDist = n - dist;
                
                int currentMin = Math.min(dist, wrapAroundDist);
                
                if (minDistance == -1 || currentMin < minDistance) {
                    minDistance = currentMin;
                }
            }
        }
        
        return minDistance;
    }
}