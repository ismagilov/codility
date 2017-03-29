/** 
* https://codility.com/programmers/lessons/14-binary_search_algorithm/nailing_planks/
*/
class Solution {
    public int solution(int[] A, int[] B, int[] C) {
        int beg = 0;
        int end = C.length - 1;
        
        int result = -1;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (areAllNailed(A, B, C, mid)) { //go right
                end = mid - 1; //go left
                result = mid + 1;
            } else {
                beg = mid + 1;
            }    
        }
        
        return result;
    }
    
    private boolean areAllNailed(int[] A, int[] B, int[] C, int lastNailIdx) {
        int nailed = 0;
        
        int max = 2 * C.length + 1;
        int[] nailsSum = new int[max];
        
        for (int i = 0; i <= lastNailIdx; i++)
            nailsSum[C[i]]++;
        
        for (int i = 1; i < max; i++)
            nailsSum[i] = nailsSum[i] + nailsSum[i - 1];
        
        for (int i = 0; i < A.length; i++)
            if (nailsSum[B[i]] - nailsSum[A[i] - 1] == 0)
                return false;
        
        return true;
    }
}
