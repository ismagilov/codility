/**
* https://codility.com/programmers/lessons/10-prime_and_composite_numbers/peaks/
*/ 
class Peaks {
    public int solution(int[] A) {
        if (A.length < 3)
            return 0;
        
        int peaks[] = new int[A.length];
        int peaksNum = 0;
        
        for (int i = 1; i <= A.length - 2; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1])
                peaksNum++;
                
            peaks[i] = peaksNum;
        }
        peaks[A.length - 1] = peaksNum;
        
        if (peaksNum < 2)
            return peaksNum;
        
        int blocksNum = peaksNum;    
        do {
            if (A.length % blocksNum != 0) {
                blocksNum--;
                continue;
            }
            
            int blockSize = A.length / blocksNum;
            int rIdx = 0;
            int prevPeaksNum = 0;
            for (rIdx = blockSize; rIdx < A.length + blockSize; rIdx += blockSize) {
                if (peaks[rIdx - 1] == prevPeaksNum)
                    break;
                
                prevPeaksNum = peaks[rIdx - 1];
            }
             
            if (rIdx == A.length + blockSize)
                break;
            else 
                blocksNum--;
        } while (blocksNum != 0);
        
        return blocksNum;
    }
}
