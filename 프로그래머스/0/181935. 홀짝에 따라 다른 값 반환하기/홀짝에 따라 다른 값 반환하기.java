import java.util.stream.*;

class Solution {
    public int solution(int n) {
        return IntStream.rangeClosed(n % 2 == 0 ? 2 : 1, n)
                        .filter(i -> i % 2 == n % 2)
                        .map(i -> n % 2 == 0 ? i * i : i)
                        .sum();
    }
}