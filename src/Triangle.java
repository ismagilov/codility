import java.util.*;

/**
* https://codility.com/programmers/lessons/6-sorting/triangle/
*/

class Triangle {
    public int solution(int[] A) {
        Arrays.sort(A);

        if (A.length < 3)
            return 0;

        for (int i = A.length - 1; i >= 2; i--) {
            long a = A[i], b = A[i - 1], c = A[i - 2];

            if (a + b > c && a + c > b && b + c > a)
                return 1;
        }

        return 0;
    }
}
