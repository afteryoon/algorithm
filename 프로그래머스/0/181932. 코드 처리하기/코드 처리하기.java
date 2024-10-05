import java.io.*;
class Solution {
    public String solution(String code) {
        char mode = '0';
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<code.length(); i++){
            if(code.charAt(i) == '1'){
                mode = mode == '1' ? '0' : '1';
                continue;
            }
            if(mode == '0' && i % 2 == 0){
                sb.append(code.charAt(i));
            }else if (mode == '1' && i % 2 ==1){
                sb.append(code.charAt(i));
            }
        }

        return sb.length() == 0? "EMPTY" :sb.toString();
    }
}