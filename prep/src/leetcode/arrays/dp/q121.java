package leetcode.arrays.dp;

public class q121 {

  public int maxProfit(int[] prices) {

    int maxSoFar = prices[prices.length - 1];
    int maxProfitSofar = 0;

    for (int i = prices.length - 2; i >= 0; i--) {
      maxProfitSofar = Math.max(maxProfitSofar, Math.max(0, maxSoFar - prices[i]));
      maxSoFar = Math.max(maxSoFar, prices[i]);
    }

    return maxProfitSofar;
  }

}
