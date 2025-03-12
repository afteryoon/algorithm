import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1; i<=Math.sqrt(yellow); i++) {
            if(yellow%i ==0) {
                int w = yellow/i;
                if(w*2 + i*2  == brown-4) 
                    return new int[]{w+2,i+2};
            }
        }
        
        return null;
    }
}