/**
* https://codility.com/programmers/lessons/4-counting_elements/frog_river_one/
*/
class Solution {
    public int solution(int X, int[] A) {
        int[] xs = new int[X];
        int cnt = 0;
        
        int i = 0;
        for (i = 0; i < A.length; i++) {
            if (xs[A[i] - 1] == 0) {
                xs[A[i] - 1] = 1;
                cnt++;
                
                if (cnt == X)
                    break;
            }
        }
        
        return (i == A.length) ? -1 : i;
    }
}
