import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        List<Integer> list = Arrays.asList(a, b, c, d);
        Map<Integer, Long> map = list.stream()
            .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        
        List<Map.Entry<Integer, Long>> sortedEntries = map.entrySet().stream()
            .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
            .collect(Collectors.toList());

        int n = map.size();
        switch (n) {
            case 1:
                return 1111 * a;
            case 2:
                if (sortedEntries.get(0).getValue() == 3) {
                    int p = sortedEntries.get(0).getKey();
                    int q = sortedEntries.get(1).getKey();
                    return (int) Math.pow(10 * p + q, 2);
                } else {
                    int p = map.keySet().stream().max(Integer::compare).get();
                    int q = map.keySet().stream().min(Integer::compare).get();
                    return (p + q) * Math.abs(p - q);
                }
            case 3:
                int p = sortedEntries.stream()
                    .filter(entry -> entry.getValue() == 2)
                    .findFirst().get().getKey();
                return list.stream().filter(i -> i != p).reduce(1, (x, y) -> x * y);
            default:
                return list.stream().min(Integer::compare).get();
        }
    }
}