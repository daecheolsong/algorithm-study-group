class Solution {
    public int solution(int n, int[] tops) {
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = 1;
        if (tops[0] == 1) dp2[0] = 3;
        else dp2[0] = 2;
        
        for (int i = 1; i < n; i++) {
            dp1[i] = (dp1[i-1] + dp2[i-1] ) % 10007;
            dp2[i] = (dp1[i-1] * (tops[i] + 1) + dp2[i-1] * (tops[i] + 2)) % 10007;
        }
        
        int answer = dp1[n-1] + dp2[n-1];
        return answer % 10007;
    }
}