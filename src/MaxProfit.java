/**
* https://codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
*/

class MaxProfit {
    public int solution(int[] A) {
        if (A.length == 0)
            return 0;

        int profit = 0;
        int min = A[0];

        for (int price : A) {
            profit = Math.max(profit, price - min);
            min = Math.min(min, price);
        }

        return profit;
    }
}
