import java.util.*;

/**
* https://codility.com/programmers/lessons/15-caterpillar_method/count_distinct_slices/
*/
class Solution {
    
    public int solution(int M, int[] A) {
        int[] counters = new int[M + 1];
        int result = 0;
        
        int b = 0;
        int e = 0;
        while (e < A.length) {            
            while (e < A.length && counters[A[e]] < 1) {
                counters[A[e]]++;
                e++;
            } 
            
            result += sum(e - b);            
            b = e;
            
            Arrays.fill(counters, 0);
        }   
        
        return result;
    }
    
    private int sum(int n) {
        return (n * n  + n) / 2;
    }
}
