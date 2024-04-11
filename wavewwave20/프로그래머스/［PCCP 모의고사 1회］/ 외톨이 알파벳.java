import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String input_string) {
        String answer = "";
        HashMap<Character, Integer> dic = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();
        
        char prev = input_string.charAt(0);
        char current;
        
        for (int i =1; i<input_string.length()+1; i++) {
            
            if(i == input_string.length()) {
                current = 'A';
            }
            else {
                current = input_string.charAt(i);
            }
            if (prev != current) {
                if(!dic.containsKey(prev)) {
                    dic.put(prev, 1);
                }
                else {
                    dic.put(prev, 2);
                }
            }
            
            prev = current;
        }
        
        
        for (char c : dic.keySet()) {
            if (dic.get(c) == 2) {
                list.add(c);
            }
        }
        if (list.size() == 0) {
            return "N";
        }
        
        Collections.sort(list);
        for (char c : list) {
            answer += Character.toString(c);
        }
        
        return answer;
    }
}
