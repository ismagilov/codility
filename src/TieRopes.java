/**
* https://codility.com/programmers/lessons/16-greedy_algorithms/tie_ropes/
*/
class Solution {
    public int solution(int K, int[] A) {
        int len = 0;
        int count = 0;
        
        for (int i = 0; i < A.length; i++) {
            len += A[i];
            
            if (len >= K) {
                count++;
                len = 0;
            }
        }
        return count;
    }
}
