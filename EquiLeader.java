/**
* https://codility.com/programmers/lessons/8-leader/equi_leader/
*/

class EquiLeader {
    public int solution(int[] A) {
        int eqLeaders = 0;
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
        if (size == 0)
            return eqLeaders;

        leader = A[candIndex];
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (leader == A[i])
                cnt++;
        }

        if (cnt <= A.length / 2)
            return eqLeaders;

        int lcnt = 0, rcnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (leader == A[i]) {
                lcnt++;
                rcnt = cnt - lcnt;
            }

            if (lcnt > (i + 1) / 2 && rcnt > (A.length - i - 1) / 2)
                eqLeaders++;
        }

        return eqLeaders;
    }
}
