class Solution {
    
    int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        dfs(emoticons.length, users, emoticons, new int[]{10, 20, 30, 40}, new int[emoticons.length], 0);
        return answer;
    }
    
    public void dfs(int n, int[][] users, int[] emoticons, int[] discounts, int[] pickDiscounts, int depth) {
        
        if(depth == n) {
            
            int plusJoin = 0;
            int totalBuyCost = 0;
            
            for(int [] user : users) {
                int userPickDiscount = user[0];
                int userMaxBuyCost = user[1];
                
                
                int buyCost = 0;
                
                for(int i = 0 ; i < n ;i ++) {
                    if(pickDiscounts[i] < userPickDiscount) {
                        continue;
                    }
                
                    int disEmoticon = (emoticons[i] * (100 - pickDiscounts[i])) / 100;
                    buyCost += disEmoticon;
                }
                
                if(userMaxBuyCost <= buyCost) {
                    plusJoin++;
                } else {
                    totalBuyCost += buyCost;
                }
                
            }
            
              if(plusJoin > answer[0]) {
                answer[0] = plusJoin;
                answer[1] = totalBuyCost;
              } else if(plusJoin == answer[0]) {
                  if(totalBuyCost > answer[1]) {
                      answer[1] = totalBuyCost;
                  }
              } 
            
            return;
        }
        
        
        
        
        for(int i = 0; i < 4; i++) {
            pickDiscounts[depth] = discounts[i]; 
            dfs(n, users, emoticons, discounts, pickDiscounts, depth + 1);
        }
        
    }
}