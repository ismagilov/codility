/**
* https://codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/
*/

class MaxDoubleSliceSum {
    public int solution(int[] A) {
        int maxLeft[] = new int[A.length];
        int maxRight[] = new int[A.length];

        for (int i = 1; i <= A.length - 2; i++) {
            maxLeft[i] = Math.max(A[i], maxLeft[i - 1] + A[i]);
        }

        for (int i = A.length - 2; i >= 1; i--) {
            maxRight[i] = Math.max(A[i], maxRight[i + 1] + A[i]);
        }

        int maxSlice = 0;
        for (int i = 1; i <= A.length - 2; i++) {
            int slice = Math.max(0, maxLeft[i] - A[i]) + Math.max(0, maxRight[i] - A[i]);
            maxSlice = Math.max(maxSlice, slice);
        }

        return maxSlice;
    }
}
