/**
* https://codility.com/programmers/lessons/13-fibonacci_numbers/fib_frog/
*/
class Solution {
    public int solution(int[] A) {
        int fibs[] = new int[26];
        
        int N = A.length;
        int reached[] = new int[A.length];
        
        fibs[0] = 0;
        fibs[1] = 1;
        for (int i = 2; i < fibs.length; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
            
            if (fibs[i] - 1 == N)
                return 1;
                
            if (fibs[i] <= N && A[fibs[i] - 1] == 1)    
                reached[fibs[i] - 1] = 1;   
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (reached[i] == 0)
                continue;
            
            for (int f = 2; f < fibs.length; f++) {
                int next = i + fibs[f];
                
                if (next == N) {
                    min = Math.min(min, reached[i] + 1);
                    break;
                }
                
                if (next > N || A[next] == 0)
                    continue;
                    
                if (reached[next] == 0 || reached[next] > reached[i] + 1)
                    reached[next] = reached[i] + 1;
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
