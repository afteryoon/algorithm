import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville){
            pq.add(n);
        }
        
        while(pq.peek()<K){
            if(pq.size() ==1){
                return -1;
            }
            
            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.offer(s1+s2*2);
            answer++;
        }
        
        return answer;
    }
}