import java.io.*;
import java.util.stream.*;
class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0,index_list.length)
            .forEach(i ->sb.append(my_string.charAt(index_list[i])));
        
        return sb.toString();
    }
}