public class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int initialOnes = 0;
        int prevZeroBlock = 0;
        int currentZeroBlock = 0;
        int maxGain = 0;
        boolean hasMultipleZeroBlocks = false;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                initialOnes++;
                
                if (currentZeroBlock > 0) {
                    if (prevZeroBlock > 0) {
                        hasMultipleZeroBlocks = true;
                        
                        maxGain = Math.max(maxGain, prevZeroBlock + currentZeroBlock);
                    }

                    prevZeroBlock = currentZeroBlock;
                    currentZeroBlock = 0;
                }
            } else {
                currentZeroBlock++;
            }
        }
        
        if (currentZeroBlock > 0 && prevZeroBlock > 0) {
            hasMultipleZeroBlocks = true;
            maxGain = Math.max(maxGain, prevZeroBlock + currentZeroBlock);
        }
        
        if (!hasMultipleZeroBlocks) {
            return initialOnes;
        }
        
        return initialOnes + maxGain;
    }
}