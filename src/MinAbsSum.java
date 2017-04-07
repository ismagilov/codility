import java.util.*;

/**
* https://codility.com/programmers/lessons/17-dynamic_programming/min_abs_sum/
* https://codility.com/media/train/solution-min-abs-sum.pdf
*/
class Solution {
    public int solution(int[] A) {
        int sum = 0;
        int maxA = 0;
        
        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]);
            sum += A[i];
            maxA = Math.max(maxA, A[i]);
        }

        int[] cntAs = new int[maxA + 1];
        for (int i = 0; i < A.length; i++)
            cntAs[A[i]]++;
        
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for (int a = 0; a < cntAs.length; a++) {
            if (cntAs[a] == 0)
                continue;
                
            for (int s = 0; s <= sum; s++) {
                if (dp[s] >= 0)
                    dp[s] = cntAs[a];
                else if (s - a >= 0 && dp[s - a] > 0)
                    dp[s] = dp[s - a] - 1; 
            }
        }
        
        int maxIdx = sum / 2;
        int maxSubsum = 0;
        for (int i = maxIdx; i >= 0; i--) {
            if (dp[i] >= 0) {
                maxSubsum = i;
                break;
            }
        }
        
        return Math.abs(sum - 2 * maxSubsum);
    }
}
