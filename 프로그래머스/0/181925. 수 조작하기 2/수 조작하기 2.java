import java.util.stream.*;

class Solution {
    public String solution(int[] numLog) {
        return IntStream.range(1, numLog.length)
                .mapToObj(i -> {
                    switch(numLog[i] - numLog[i-1]) {
                        case 1: return "w";
                        case -1: return "s";
                        case 10: return "d";
                        case -10: return "a";
                        default: return ""; 
                    }
                })
                .collect(Collectors.joining()); 
    }
}