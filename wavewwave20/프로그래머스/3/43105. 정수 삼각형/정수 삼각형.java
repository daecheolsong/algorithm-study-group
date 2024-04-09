class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < i+1; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < triangle.length; i++) {
            int tmp = dp[triangle.length-1][i];
            if (tmp > answer) {
                answer = tmp;
            }
        }
        return answer;
    }
}