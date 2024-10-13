import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        return Arrays.stream(num_list)
                     .boxed()
                     .sorted()
                     .skip(5)
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}