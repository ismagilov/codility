/**
* https://codility.com/programmers/lessons/15-caterpillar_method/count_triangles/
*/
import java.util.*;

class Solution {
    public int solution(int[] A) {
        if (A.length < 3)
            return 0;
            
        Arrays.sort(A);
        
        int result = 0;
        for (int i = 0; i < A.length - 2; i++) {
            for (int j = i + 1; j < A.length - 1; j++) {
                int k = j + 1;
                while (k < A.length && A[i] + A[j] > A[k])
                    k++;
                
                result += k - j - 1;
            }
        }
        
        return result;
    }
}
