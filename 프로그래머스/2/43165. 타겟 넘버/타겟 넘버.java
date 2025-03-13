import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
      
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int index = cur[0];
            int sum = cur[1];

            if(index == numbers.length) {
                if(sum == target ) answer++;
                continue;
            }
            int size = q.size();
            q.add(new int[] {index+1,sum+numbers[index]});
            q.add(new int[]{index+1,sum-numbers[index]});
        }
        
        return answer;
    }
}