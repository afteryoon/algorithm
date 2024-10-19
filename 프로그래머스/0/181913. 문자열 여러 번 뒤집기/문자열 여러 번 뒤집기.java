import java.util.*;

class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        Arrays.stream(queries)
            .forEach(query -> {
                int s = query[0];
                int e = query[1];
                String revers = new StringBuilder(sb.substring(s, e + 1)).reverse().toString();
                sb.replace(s, e + 1, revers);
            });
        
        return sb.toString();  
    }
}
