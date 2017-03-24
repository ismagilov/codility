/**
* https://codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/
*/
class Solution {
    public int solution(int N, int M) {
        //result = least common multiple / M = (M * N / gcd(N, M)) / M = N / gcd(N,M)
        return N / gcd(N, M);
    }
    
    private int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }
}
