import java.util.stream.*;
class Solution {
    public int solution(int a, int b, int c) {
        int count = 1;
        if(a == b || a == c){
            count++;
        }
        if(b == c){
                count++;
        }
        int answer = a+b+c;
        if(count >= 2){
            answer *= (a*a + b*b + c*c);
        }
        if(count >= 3){
            answer *= (a*a*a + b*b*b + c*c*b);
        }
        
        return answer;
    }
}