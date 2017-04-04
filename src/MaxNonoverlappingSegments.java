/**
* https://codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/
*/ 
class Solution {
    public int solution(int[] A, int[] B) {
        if (B.length == 0)
            return 0;
            
        int count = 0;
        int mostLeft = B[B.length - 1] + 1;
        for (int i = B.length - 1; i >= 0; i--) {
            if (B[i] < mostLeft) {
                count++;
                mostLeft = A[i];
            } else if (A[i] < mostLeft) {
                mostLeft = A[i];
            }
        }
        
        return count;
    }
}
