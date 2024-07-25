public class Q3
{
    public static void main(String args[])
    {
        int weights[] = {1, 2, 3};
        int values[] = {10, 15, 40};
        int capacity = 6;
        System.out.println(knpDp(weights, values, capacity));
    }
    public static int knpDp(int weights[], int values[], int capacity)
    {
        int n = weights.length;
        int[][] dp = new int[n+1][capacity + 1];

        for(int i = 1; i <= n; i++)
        {
            for(int w = 1; w <= capacity; w++)
            {
                if(weights[i-1] <= w)
                {
                    dp[i][w] = Math.max(values[i-1] + dp[i-1][w - weights[i-1]],dp[i-1][w]);
                }
                else
                {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[n][capacity];
    }
}
