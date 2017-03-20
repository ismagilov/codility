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
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks[peaksNum] = i;
                peaksNum++;
            }
        }
        
        if (peaksNum == 0)
            return 0;
        
        int blocksNum = peaksNum;    
        do {
            if (A.length % blocksNum != 0) {
                blocksNum--;
                continue;
            }
            
            int blockSize = A.length / blocksNum;
            int blocksIdx = 0;
            for (blocksIdx = 0; blocksIdx < blocksNum; blocksIdx++) {
                if (peaks[blocksIdx] < blockSize * blocksIdx || 
                peaks[blocksIdx] > blockSize * blocksIdx + blockSize - 1) {
                    break;
                }
            }
             
            if (blocksIdx == blocksNum)
                break;
            else 
                blocksNum--;
        } while (blocksNum != 0);
        
        return blocksNum;
    }
}
