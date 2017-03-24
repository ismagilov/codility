/**
* https://codility.com/programmers/lessons/2-arrays/cyclic_rotation/
*/
class Solution {
    public int[] solution(int[] A, int K) {
        if (A.length == 0) return A;
        
        K = K % A.length;
        
        invert(A, 0, A.length - 1);
        invert(A, K, A.length - 1);
        invert(A, 0, K - 1);
        
        return A;
    }
    
    private void invert(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}
