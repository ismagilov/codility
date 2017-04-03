import java.util.*;

/**
* https://codility.com/programmers/lessons/15-caterpillar_method/count_distinct_slices/
*/
class Solution {
    public int solution(int M, int[] A) {
        int result = 0;
        
        int[] counters = new int[M + 1];
        
        int b = 0;
        int e = 0;
        while(b < A.length) {            
            while(e < A.length && counters[A[e]] == 0) {
                counters[A[e]] = 1;
                e++;
            }
            
            result += e - b;
            if (result > 1000000000)
                return 1000000000;
            
            counters[A[b]] = 0;
            b++;
        }
        
        return result;
    }
}
