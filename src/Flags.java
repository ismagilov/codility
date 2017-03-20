/**
* https://codility.com/programmers/lessons/10-prime_and_composite_numbers/flags
*/
public class Flags {
    public int solution(int[] A) {
        if (A.length < 3)
            return 0;
        
        int[] peaks = new int[A.length];
        int peaksNum = 0;
        int firstPeak = -1, lastPeak = -1;
        for (int i = 1; i <= A.length - 2; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks[peaksNum] = i;
                
                if (peaksNum == 0)
                    firstPeak = peaks[peaksNum];
                lastPeak = peaks[peaksNum];
                
                peaksNum++;
            }
        }
        
        if (peaksNum < 2)
            return peaksNum;
            
        int maxFlags = (int)Math.sqrt(lastPeak - firstPeak) + 1;
            
        int result = 0;
        for (int mf = 1; mf <= maxFlags; mf++) {
            int flags = 1;
            int prevP = 0;
        
            int f = 0;
            int p = 1;
            while (flags < mf && p < peaksNum) {
                if (peaks[p] - peaks[prevP] >= mf) {
                    flags++;    
                    prevP = p;
                }
                
                p++;
            }
            
            if (flags == mf)
                result = Math.max(result, flags);
        }
        
        return result;
    }
}
