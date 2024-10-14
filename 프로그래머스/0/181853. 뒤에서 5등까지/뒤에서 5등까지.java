import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] num_list) {
        return Arrays.stream(num_list)
                     .boxed()
                     .sorted()
                     .limit(5)
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}