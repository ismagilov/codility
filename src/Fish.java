import java.util.*;

/**
* https://codility.com/programmers/lessons/7-stacks_and_queues/fish/
*/
class Fish {
    public int solution(int[] A, int[] B) {
        Stack<Integer> s = new Stack<Integer>();

        for (int next = 0; next < B.length; next++) {
            if (s.isEmpty()) {
                s.push(next);
                continue;
            }

            s.push(next);
            int last = s.pop(), beforeLast = s.pop();
            if (B[beforeLast] == 1 && B[last] == 0) {
                while (true) {
                    if (B[beforeLast] == 1 && B[last] == 0) {
                        if (A[beforeLast] < A[last])
                            s.push(last);
                        else
                            s.push(beforeLast);
                    } else {
                        s.push(beforeLast);
                        s.push(last);

                        break;
                    }

                    if (s.size() > 1) {
                        last = s.pop();
                        beforeLast = s.pop();
                    } else {
                        break;
                    }
                }
            } else {
                s.push(beforeLast);
                s.push(last);
            }
        }

        return s.size();
    }
}
