import java.util.*;

/**
* https://codility.com/programmers/lessons/15-caterpillar_method/abs_distinct/
*/
class Solution {
    public int solution(int[] A) {
        HashSet<Integer> distincts = new HashSet<>();
        
        for (int i = 0; i < A.length; i++)
            distincts.add(Math.abs(A[i]));
            
        return distincts.size();
    }
}
