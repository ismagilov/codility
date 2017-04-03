import java.util.*;

/**
* https://codility.com/programmers/lessons/15-caterpillar_method/min_abs_sum_of_two/
*/
class Solution {
    public int solution(int[] A) {
        int b = 0;
        int e = A.length - 1;
        
        int min = Math.abs(A[e] + A[b]);
        
        Arrays.sort(A);
        
        while (b <= e) {
            while (e >= b) {
                int curMin = Math.abs(A[b] + A[e]);   
                
                min = Math.min(min, curMin);
                
                if (e - 1 < 0 || Math.abs(A[b] + A[e - 1]) > curMin)
                    break;
                else
                    e--;
            }
            
            b++;
        }
        
        return min;
    }
}

