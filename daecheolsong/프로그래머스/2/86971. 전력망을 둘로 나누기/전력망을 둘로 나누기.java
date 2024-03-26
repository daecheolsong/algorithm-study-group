import java.util.*;
class Solution {
    
    int answer = Integer.MAX_VALUE;
    int cnt = 1;
    public int solution(int n, int[][] wires) {

    
        int[][] m = new int[n + 1][n + 1];
        int[][] v = new int[n + 1][n + 1];
        
        
        for(int i = 0 ; i < wires.length ; i++) {
            m[wires[i][0]][wires[i][1]] = 1;
            m[wires[i][1]][wires[i][0]] = 1;
        }
        
        
        for(int i = 0; i < wires.length ; i ++) {
            m[wires[i][0]][wires[i][1]] = 0;
            m[wires[i][1]][wires[i][0]] = 0;
            
            boolean isTrace = false;
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k ++) {
                    if(m[j][k] == 1 && v[j][k] == 0) {
    
                        trace(j, m, v);
                        isTrace = true;
                        break;
                    }
                }
                if(isTrace) {
                    break;
                }
            }
            
            answer = Math.min(answer, Math.abs(2 * cnt - n));
            m[wires[i][0]][wires[i][1]] = 1;
            m[wires[i][1]][wires[i][0]] = 1;
            cnt = 1;
            v = new int[n + 1][n + 1];            
        }
        
        
        return answer;
    }
    
    public void trace(int start, int[][] m, int[][] v) {
        
        
        for(int i = 1; i < m.length; i ++) {
            if(m[start][i] == 1 && v[start][i] == 0) {
                v[start][i] = 1;
                v[i][start] = 1;
                cnt ++;
                trace(i, m , v);
            }
        }
        
    }
}