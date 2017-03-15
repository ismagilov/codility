/**
* https://codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
*/

class MaxSliceSum {
    public int solution(int[] A) {
        int max = A[0], slice = A[0];

        for (int i = 1; i < A.length; i++) {
            max = Math.max(A[i], max + A[i]);
            slice = Math.max(slice, max);
        }

        return slice;
    }
}
