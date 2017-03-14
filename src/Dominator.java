/**
* https://codility.com/programmers/lessons/8-leader/dominator/
*/ 

class Dominator {
    public int solution(int[] A) {
        int size = 0;
        int candIndex = -1;

        for (int i = 0; i < A.length; i++) {
            if (size == 0) {
                candIndex = i;
                size++;
            } else {
                if (A[candIndex] == A[i]) {
                    size++;
                } else {
                    size--;
                }
            }
        }

        int leader;
        if (size > 0)
            leader = A[candIndex];
        else
            return -1;

        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (leader == A[i])
                cnt++;
        }

        return (cnt > A.length / 2) ? candIndex : -1;
    }
}
