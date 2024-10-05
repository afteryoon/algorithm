import java.util.function.BiFunction;
import java.util.*;

class Solution {
    public int solution(String ineq, String eq, int n, int m) {
       Map<String,BiFunction<Integer,Integer,Boolean>> functions =Map.of(
            "<=", (a,b) -> a<=b,
            ">=", (a,b) -> a>=b,
            "<!", (a,b) -> a<b,
            ">!", (a,b) -> a>b
       );
        
        return functions.get(ineq+eq).apply(n,m) ? 1 : 0;
    }
}