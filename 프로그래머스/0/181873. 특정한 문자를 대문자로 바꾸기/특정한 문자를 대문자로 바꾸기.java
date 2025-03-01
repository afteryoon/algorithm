import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String my_string, String alp) {
        return my_string.chars()
                .mapToObj(c -> (char)c == alp.charAt(0) ? Character.toUpperCase((char)c) : (char)c)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
                          
}