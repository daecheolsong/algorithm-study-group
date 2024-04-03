class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        
        int [][] dp = new int[n + 1][2];
        
        dp[0][0] = 0;
        dp[0][1] = 1;
    
        for(int i = 1; i <= n; i++) {
            int top = tops[i - 1];
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 10007;
            dp[i][1] = top == 0 ? (dp[i-1][0] + 2 * dp[i-1][1]) % 10007 : (2 * dp[i-1][0] + 3 * dp[i-1][1]) % 10007;
            
        }
        return (dp[n][0] + dp[n][1]) % 10007;
    }
}