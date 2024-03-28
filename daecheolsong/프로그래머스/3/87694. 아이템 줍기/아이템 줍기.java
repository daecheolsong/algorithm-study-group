
class Solution {
    
    int [] mvx = {0, 0, 1, -1};
    int [] mvy = {1, -1, 0, 0};
    
    int answer = Integer.MAX_VALUE;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i < rectangle.length; i++) {
            maxX = Math.max(maxX, rectangle[i][2]);
            maxY = Math.max(maxY, rectangle[i][3]);
        }
        
        int[][] m = new int[2 * maxY + 1][2 * maxX + 1];
        int[][] v = new int[2 * maxY + 1][2 * maxX + 1];
        
        for(int i = 0; i < rectangle.length; i++) {
            int sX = 2 * rectangle[i][0];
            int sY = 2 * rectangle[i][1];
            
            int eX = 2 * rectangle[i][2];
            int eY = 2 * rectangle[i][3];
            
            for(int j = sY; j <= eY; j++) {
                for(int k = sX; k <= eX; k++) {
                    if(j == sY || j == eY) {
                        if(m[j][k] == 0) {
                            m[j][k] = 1;
                        }
                    } else {
                        if(k == sX || k == eX) {
                            if(m[j][k] == 0) {
                                m[j][k] = 1;
                            }
                        } else {
                            m[j][k] = 2;
                        }
                    }
                }
            }
               
        }
        
        dfs(2*characterX , 2*characterY, 2*itemX, 2*itemY, m, v, 0);
        return answer / 2;
    }
    
    public void dfs(int x, int y, int itemX, int itemY, int[][] m, int[][] v, int count) {
        
        if(x == itemX && y == itemY) {
            answer = Math.min(answer, count);
            return;
        }
        
        
        for(int i = 0; i < 4; i ++) {
            int nx = x + mvx[i];
            int ny = y + mvy[i];
            
            if(isIn(nx, ny, m[0].length, m.length) && m[ny][nx] == 1 && v[ny][nx] == 0) {
                v[ny][nx] = 1;
                dfs(nx, ny, itemX, itemY, m, v, count + 1);
                v[ny][nx] = 0;
            }
        }
        
        
    }
    
    public boolean isIn(int nx, int ny, int x, int y) {
        return nx >= 0 && nx < x && ny >= 0 && ny < y;
    }
    
    
}