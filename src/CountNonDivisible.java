/**
* https://codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible/
*/
class CountNonDivisible {
    public int[] solution(int[] A) {
        int[] nonDivs = new int[A.length]; 
        
        int [] count = new int[2 * A.length + 1];
        for (int i = 0; i < A.length; i++)
            count[A[i]]++;
        
        for (int i = 0; i < A.length; i++) {
            int k = 1;
            int divs = 0;
            while (k * k <= A[i]) {
                if (A[i] % k == 0) {
                    divs += count[k];
                 
                    int k2 = A[i] / k;
                    if (k2 != k)
                        divs += count[k2];
                }
                
                k++;
            }
            
            nonDivs[i] = A.length - divs;
        }
        
        return nonDivs;
    }
}
