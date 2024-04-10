import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        List<Set<Integer>> cases = new ArrayList<>();
        cases.add(Set.of());
        
        for(int i = 1; i <= 8; i++) {
            
            int first = N;
            
            for(int j = 1; j < i; j++ ) {
                first += N * (int)Math.pow(10, j);
            }
            HashSet<Integer> caze = new HashSet<>();
            caze.add(first);
            cases.add(caze);
            
            int s = 1;
            int e = i - 1;
            
            while(s <= e) {
                
                Set<Integer> lowCases = cases.get(s);
                Set<Integer> highCases = cases.get(e);
                
                for(int lowCase : lowCases) {
                    for(int highCase : highCases) {
                        if(lowCase > highCase) {
                            caze.add(lowCase - highCase);           
                        }
                        if(highCase > lowCase) {
                            caze.add(highCase - lowCase);
                        }
                        
                        if(lowCase >= highCase) {
                            caze.add(lowCase / highCase);
                        }
                        
                        if(lowCase <= highCase) {
                            caze.add(highCase / lowCase);
                        }
                        caze.add(lowCase + highCase);
                        caze.add(lowCase * highCase);
                    }
                }
                
                s++;
                e--;
            }
            
            if(caze.contains(number)) {
                return i;
            }
        }
        
        
        return -1;
    }
}