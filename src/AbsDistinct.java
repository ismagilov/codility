import java.util.*;

/**
* https://codility.com/programmers/lessons/15-caterpillar_method/abs_distinct/
*/
class Solution {
    public int solution(int[] A) {
        int b = 0, e = A.length - 1;
        
        long nums[] = new long[A.length];
        
        for (int i = 0; i < A.length; i++) {
            if (Math.abs((long)A[b]) > Math.abs((long)A[e])) {
                nums[i] = Math.abs((long)A[b]);
                b++;
            } else {
                nums[i] = Math.abs((long)A[e]);
                e--;
            }
        }

        int cnt = 0;
        long prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != prev)
                cnt++;
                
            prev = nums[i];    
        }
                
        return cnt;
    }
}
