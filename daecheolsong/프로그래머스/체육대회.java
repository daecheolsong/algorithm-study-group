class Solution {
    int answer = 0;
    public int solution(int[][] ability) {
        
        int n = ability.length;
        int [] mIdx = new int[n];
        for(int i = 0; i < n ; i ++) {
            mIdx[i] = i;
        }
        int [] v = new int[n];
        int m = ability[0].length;
        int [] sMIdx = new int[m];
        dfs(m, n, 0, mIdx, sMIdx, v, ability);
        return answer;
    }
    
    
    public void dfs(int m ,int n, int depth, int[] mIdx, int[] sMIdx, int[] v, int[][] ability) {
        
        if(depth == m) {
            int sum = 0;
            
            for(int i = 0; i < m; i++) {
                sum += ability[sMIdx[i]][i];
            }
   
            answer = Math.max(answer, sum);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(v[i] == 0) {
                v[i] = 1;
                sMIdx[depth] = mIdx[i];
                dfs(m, n, depth + 1, mIdx, sMIdx, v, ability);
                v[i] = 0;
            }
        }
        
    }
}