/**
* https://codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/
*/
class CountSemiprimes {
    public int[] solution(int N, int[] P, int[] Q) {
        int factors[] = new int[N + 1];
        factors[0] = 0;
        factors[1] = 1;
        
        int i = 2;
        while (i * i <= N) {
            if (factors[i] == 0) {
                int k = i * i;
                while(k <= N) {
                    if (factors[k] == 0)
                        factors[k] = i;
                    k += i;
                }
            }
            i++;
        }
        
        int semiNum[] = new int[N + 1];
        int num = 0;
        for (i = 1; i < semiNum.length; i++) {
            if (factors[i] != 0) {
                int f2 = i / factors[i];
                if (factors[f2] == 0)
                    num++;
            }
            
            semiNum[i] = num;    
        }
        
        int result[] = new int[P.length];
        
        for (int j = 0; j < result.length; j++)
            result[j] = semiNum[Q[j]] - semiNum[P[j] - 1];
        
        return result;
    }
}
