import java.util.*;

/**
* https://codility.com/programmers/lessons/17-dynamic_programming/number_solitaire/
*/
class Solution {
    public int solution(int[] A) {
        int[] max = new int[A.length];
        
        Arrays.fill(max, Integer.MIN_VALUE);
        
        max[0] = A[0];
        max[1] = A[0] + A[1];
        for (int i = 2; i < max.length; i++) {
            for (int d = 1; d <= 6; d++) {
                if (i - d >= 0)
                    max[i] = Math.max(max[i], A[i] + max[i - d]);
            }
        }
        
        return max[A.length - 1];
    }
}
