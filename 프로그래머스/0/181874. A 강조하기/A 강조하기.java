import java.util.stream.*;
class Solution {
    public String solution(String myString) {
         return myString.chars()
            .mapToObj(c -> 
                c == 'a' || c == 'A' ? "A" :
                Character.isUpperCase(c) ? String.valueOf((char) (c + 32)) :
                String.valueOf((char) c))
            .collect(Collectors.joining());
    }
}