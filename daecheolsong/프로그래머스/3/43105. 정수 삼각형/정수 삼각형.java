class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        for(int i = 1; i < n ; i++) {
            for(int j = 0; j <= i; j++) {
                int l = 0;
                int r = 0;
                
                if(j == 0) {
                    triangle[i][j] += triangle[i-1][j];
                    continue;
                }
                
                if(j == i) {
                    triangle[i][j] += triangle[i-1][j-1];
                    continue;
                }
                
                if(j - 1 >= 0) {
                    l = triangle[i-1][j-1];
                }
                
                if(j < triangle[i-1].length) {
                    r = triangle[i-1][j];
                } 
                
                
                int choose = Math.max(l,r);
                
                triangle[i][j] += choose; 
            }
        }
        
        for(int i = 0; i < triangle[n-1].length; i++) {
            answer = Math.max(triangle[n-1][i], answer);
        }
        return answer;
    }
}