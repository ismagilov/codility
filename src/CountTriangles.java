import java.util.*;

/**
* https://codility.com/programmers/lessons/15-caterpillar_method/count_triangles/
*/
class Solution {
    public int solution(int[] A) {
        if (A.length < 3)
            return 0;
            
        Arrays.sort(A);
        
        int result = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int j = i + 1;
            int k = j + 1;
            
            while (j < A.length - 1) {
                if (k < A.length && A[i] + A[j] > A[k]) {
                    k++;    
                } else {
                    result += k - j - 1;
                    j++;
                }       
            }
        }
        
        return result;
    }
}
