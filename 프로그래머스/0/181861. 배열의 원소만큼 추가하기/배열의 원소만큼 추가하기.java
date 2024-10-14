import java.util.stream.*;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        return Arrays.stream(arr)
                     .flatMap(a -> IntStream.generate(() -> a).limit(a))
                     .toArray();
    }
}