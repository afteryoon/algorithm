import java.util.stream.*;
class Solution {
    public String solution(String rny_string) {
        return rny_string.chars()
                .mapToObj(c -> c == 'm' ? "rn" : String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}