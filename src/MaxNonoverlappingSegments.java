/**
* https://codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/
*/ 
class Solution {
    public int solution(int[] A, int[] B) {
        if (B.length == 0)
            return 0;
            
        int count = 1;
        int lastIdx = 0;
        
        for (int i = 1; i < B.length; i++) {
            if (A[i] > B[lastIdx]) {
                count++;
                lastIdx = i;
            }
        }
        
        return count;
    }
}
