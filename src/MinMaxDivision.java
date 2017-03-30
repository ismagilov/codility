/** 
* https://codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/
*/
class Solution {
    public int solution(int K, int M, int[] A) {
        int minSum = A[0];
        int maxSum = 0;
        
        for (int i = 0; i < A.length; i++) {
            maxSum += A[i];
            minSum = Math.min(minSum, A[i]);
        }
        
        int beg = minSum;
        int end = maxSum;
        int result = 0;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            
            if (blocksNumber(A, mid) <= K) {
                result = mid;
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        
        return result;
    }
    
    private int blocksNumber(int[] A, int maxSum) {
        int blocks = 0;
        int blockSum = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (blockSum + A[i] > maxSum) {
                blocks++;
                blockSum = A[i];
            } else {
                blockSum += A[i];
            }
        }
        
        return blocks + 1;
    }
}
