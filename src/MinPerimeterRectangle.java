/**
* https://codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/
*/
public class MinPerimeterRectangle {
    public int solution(int N) {
        long min = Long.MAX_VALUE;
        
        long i = 1;
        while (i * i < N) {
            if (N % i == 0) {
                long f1 = N / i;
                long f2 = N / f1;
                long p = 2 * (f1 + f2);
                
                if (p < min)
                    min = p;
            }
            
            i++;
        }
        
        if (i * i == N) {
            long p = 4 * i;       
            if (p < min)
                min = p;
        }
        
        return (int)min;
    }
}
