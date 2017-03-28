/**
* https://codility.com/programmers/lessons/13-fibonacci_numbers/ladder/
*/
class Solution {
    public int[] solution(int[] A, int[] B) {
        int max = 0;
        for (int i = 0; i < A.length; i++)
            max = Math.max(A[i], max);
                    
        max += 2;
        int fib[] = new int[max];
        fib[0] = 0;
        fib[1] = 1;
        int maxFib = 1 << 30;
        for (int i = 2; i < max; i++)
            fib[i] = (fib[i - 1] + fib[i - 2]) % maxFib;
        
        int result[] = new int[A.length];
        for (int i = 0; i < result.length; i++)
            result[i] = fib[A[i] + 1] % (1 << B[i]);
            
        return result;
    }
}
