import java.util.*;

class Solution {
    public String solution(String input_string) {
        String answer= "";
        Set<Character> set = new TreeSet<>();
        char [] chars = input_string.toCharArray();
        int mid = chars.length/2;
        
        for(int i = 0; i < chars.length ; i++) {
            int s = i;
            int e = chars.length -1;
            
            char lch = chars[s];
            while(s < e) {
                char rch = chars[e];
                
                if(lch == rch) {
                    for(int j = s; j <= e; j++) {
                        if(chars[j] != lch) {
                            set.add(lch);
                            break;
                        }
                    }
                }
                e--;
            }
        }
        
        for(Character str : set) {
            answer += str;
        }
        
        return set.isEmpty() ? "N" : answer;
    }
}