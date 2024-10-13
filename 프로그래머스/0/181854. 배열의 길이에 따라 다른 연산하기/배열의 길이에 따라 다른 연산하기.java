import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int n) {
          IntStream.range(0, arr.length)
            .filter(i -> i % 2 != arr.length % 2)
            .forEach(i -> arr[i] += n);
        return arr;
    }
}