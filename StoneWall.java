import java.util.*;

/**
* https://codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
*/

class StoneWall {
    public int solution(int[] H) {
        Stack<Integer> s = new Stack<Integer>();

        int blocks = 0;

        for (int h : H) {
            while (!s.isEmpty() && s.peek() > h)
                s.pop();

            if (s.isEmpty() || s.peek() < h) {
                s.push(h);
                blocks++;
            }
        }

        return blocks;
    }
}
