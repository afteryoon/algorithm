import java.util.*;
class Solution {
    int[] arr;
    int answer=0;
    int check;
    
    public int solution(int[] numbers, int target) {
        arr = numbers;
        check = target;
        
        dfs(0,0);
        return answer;
    }
    
    public void dfs(int index, int sum){
        if(index == arr.length){
            if(sum == check)
                answer++;
            return;
        }
        
        dfs(index+1, sum+arr[index]);
        dfs(index+1, sum-arr[index]);
        
    }
}