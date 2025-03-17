import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<int []> q = new LinkedList();
       for(int i=0; i<progresses.length; i++) {
           q.add(new int[]{progresses[i], speeds[i]});
       }
        int day = 0;
        List<Integer> list = new LinkedList<>();
        while(!q.isEmpty()) {
            day++;
            int n = 0;
            while(!q.isEmpty() && q.peek()[0]+ q.peek()[1]*day >= 100) {
                n++;
                q.poll();
            }
            if(n>0) list.add(n);
        }

        
       return list.stream().mapToInt(Integer::intValue).toArray();
    }
}