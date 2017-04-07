import java.util.*;

/**
* https://codility.com/programmers/lessons/17-dynamic_programming/min_abs_sum/
*/
class Solution {
    public int solution(int[] A) {
        int sum = 0;
        
        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]);
            sum += A[i];
        }
        
        int[] dp = new int[sum + 1];
        
        dp[0] = 1;
        
        for (int a = 0; a < A.length; a++) {
            for (int s = sum; s >= 0; s--) {
                if (dp[s] == 1 && s + A[a] <= sum)
                    dp[s + A[a]] = 1;
            }
        }
        
        int maxIdx = sum / 2;
        int maxSubsum = 0;
        for (int i = maxIdx; i >= 0; i--) {
            if (dp[i] == 1) {
                maxSubsum = i;
                break;
            }
        }
        
        return Math.abs(sum - 2 * maxSubsum);
    }
}
