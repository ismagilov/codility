/**
* https://codility.com/programmers/lessons/12-euclidean_algorithm/common_prime_divisors/
*/
class Solution {
    public int solution(int[] A, int[] B) {
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            int d = gcd(A[i], B[i]);
            
            int a = A[i], b = B[i];
            int c = d;
            while (c != 1) {
                a = a / c;
                
                c = gcd(a, d);
            }
            
            c = d;
            while (c != 1) {
                b = b / c;
                
                c = gcd(b, d);
            }
            
            if (a == 1 && b == 1)
                cnt++;
        }
        
        return cnt;
    }
    
    private int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }
}
