import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        IntStream.range(0,a.length())
            .mapToObj(i -> a.charAt(i)+"\n")
            .forEach(System.out::print);
    }
}