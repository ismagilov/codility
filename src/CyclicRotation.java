/**
* https://codility.com/programmers/lessons/2-arrays/cyclic_rotation/
*/
class Solution {
    public int[] solution(int[] A, int K) {
        if (A.length == 0) return A;
        
        K = K % A.length;

        int exchs = 0;
        int startIdx = 0;
        while (exchs < A.length) {
            int curIdx = startIdx;
            int cur = A[curIdx];
            do {
                int nextIdx = (curIdx + K) % A.length;
                int tmp = A[nextIdx];
                A[nextIdx] = cur;
                exchs++;
                
                cur = tmp;
                curIdx = nextIdx;
            } while (curIdx != startIdx);
            
            startIdx++;
        }
        
        return A;
    }
}
