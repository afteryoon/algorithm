import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
       Arrays.stream(queries)
            .forEach(q -> change(arr, q[0],q[1],q[2]));
        return arr;
    }
    
    public void change(int[] arr , int s, int e, int k){
        IntStream.rangeClosed(s,e)
            .filter(i -> i % k == 0)
            .forEach(i -> arr[i]+=1);
    }
}