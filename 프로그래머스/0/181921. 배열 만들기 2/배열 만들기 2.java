import java.util.*;
import java.util.stream.*;
class Solution {
    static List<Integer> list = new ArrayList<>();
    public List<Integer> solution(int l, int r) {
        IntStream.rangeClosed(l,r)
            .filter(i -> i%5==0)
            .forEach(i -> check(String.valueOf(i)));
        return list.isEmpty()? Arrays.asList(-1) : list;
    }
    
    public void check(String i){
        if (i.chars().allMatch(ch -> ch == '0' || ch == '5')) {
            list.add(Integer.parseInt(i));
        }
    }
}