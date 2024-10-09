import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        Arrays.stream(queries)
            .forEach(query -> swap(arr,query[0],query[1]));
        return arr;
    }
    public void swap(int[] arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}