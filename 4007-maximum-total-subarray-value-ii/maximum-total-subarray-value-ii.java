class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        long totalSubarrays = (long) n * (n + 1) / 2;
        long kSmall = totalSubarrays - k; 
        
        long low = 0;
        int minVal = nums[0], maxVal = nums[0];
        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }
        long high = (long) maxVal - minVal;
        long maxDiff = high;
        
        long vStar = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long[] res = countLessThan(nums, mid);
            if (res[0] <= kSmall) {
                vStar = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        // Calculate the sum of the elements strictly less than vStar
        long[] resVStar = countLessThan(nums, vStar);
        
        // Calculate the total sum of all subarrays (using maxDiff + 1 acts as infinity)
        long[] resTotal = countLessThan(nums, maxDiff + 1); 
        
        long totalSum = resTotal[1];
        
        // Top K Sum = Total Sum - (Sum of elements strictly less than vStar) 
        //             - (vStar * remaining elements needed to discard)
        long ans = totalSum - resVStar[1] - vStar * (kSmall - resVStar[0]);
        
        return ans;
    }
    
    // Returns [count of subarrays with (max - min) < V, sum of their (max - min) values]
    private long[] countLessThan(int[] nums, long V) {
        int n = nums.length;
        long count = 0;
        long sum = 0;
        
        // Arrays acting as fast Monotonic Deques (storing indices)
        int[] maxDq = new int[n];
        int maxHead = 0, maxTail = 0;
        
        int[] minDq = new int[n];
        int minHead = 0, minTail = 0;
        
        long sumMax = 0;
        long sumMin = 0;
        int L = 0;
        
        for (int r = 0; r < n; r++) {
            // 1. Maintain Monotonic Decreasing Deque for Maximums
            while (maxTail > maxHead && nums[maxDq[maxTail - 1]] <= nums[r]) {
                int idx = maxDq[--maxTail];
                int prev = (maxTail > maxHead) ? maxDq[maxTail - 1] : L - 1;
                sumMax -= (long) nums[idx] * (idx - prev);
            }
            int prevMax = (maxTail > maxHead) ? maxDq[maxTail - 1] : L - 1;
            sumMax += (long) nums[r] * (r - prevMax);
            maxDq[maxTail++] = r;
            
            // 2. Maintain Monotonic Increasing Deque for Minimums
            while (minTail > minHead && nums[minDq[minTail - 1]] >= nums[r]) {
                int idx = minDq[--minTail];
                int prev = (minTail > minHead) ? minDq[minTail - 1] : L - 1;
                sumMin -= (long) nums[idx] * (idx - prev);
            }
            int prevMin = (minTail > minHead) ? minDq[minTail - 1] : L - 1;
            sumMin += (long) nums[r] * (r - prevMin);
            minDq[minTail++] = r;
            
            // 3. Shrink the window from the left if the difference exceeds our threshold V
            while (L <= r && nums[maxDq[maxHead]] - nums[minDq[minHead]] >= V) {
                sumMax -= nums[maxDq[maxHead]];
                if (maxDq[maxHead] == L) {
                    maxHead++;
                }
                
                sumMin -= nums[minDq[minHead]];
                if (minDq[minHead] == L) {
                    minHead++;
                }
                
                L++;
            }
            
            // 4. Add the valid window configuration to our counters
            count += (r - L + 1);
            sum += (sumMax - sumMin);
        }
        
        return new long[]{count, sum};
    }
}