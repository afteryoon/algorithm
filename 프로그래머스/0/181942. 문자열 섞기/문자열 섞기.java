import java.io.*;
import java.util.stream.*;
class Solution {
    public String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0,str1.length())
            .forEach(i -> sb.append(str1.charAt(i)).append(str2.charAt(i)));
        return sb.toString();
    }
}