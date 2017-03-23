/**
* https://codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible/
*/
class CountNonDivisible {
    public int[] solution(int[] A) {
        int[] nonDivs = new int[A.length]; 
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i == j) continue;
                
                if (A[i] < A[j] || A[i] % A[j] != 0)
                    nonDivs[i]++;
            }
        }
        
        return nonDivs;
    }
}
