import java.util.*;
import java.util.*;

class Solution {
    
    class Process {
        
        int location;
        int priority;
        
        Process (int location,int priority){
            this.location = location;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Process> pq = new PriorityQueue<>((p1,p2)-> p2.priority-p1.priority);
        Queue<Process> q = new LinkedList<>();
        
        for (int i=0; i<priorities.length; i++) {
            Process p = new Process(i,priorities[i]);
            pq.add(p);
            q.add(p);
        }
        
        while(!q.isEmpty()){
            Process now = q.poll();
            if(now.priority >= pq.peek().priority){
                answer++;
                pq.poll();
                if(now.location == location)
                    return answer;
            }else{
                q.add(now);
            }
        }
        return answer;
    }
}