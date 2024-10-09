import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        return Arrays.stream(queries)
            .mapToInt(q -> findMin(arr,q[0],q[1],q[2]))
            .toArray();
    }
    
    public int findMin(int[] arr, int s, int e,int k){
       return IntStream.rangeClosed(s, e)
            .map(i -> arr[i])
            .filter(value -> value > k)
            .min()
            .orElse(-1);
    }
}