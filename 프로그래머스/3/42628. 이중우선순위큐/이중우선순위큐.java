import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> r_pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i=0; i< operations.length; i++){
            String[] commend = operations[i].split(" ");
            if(commend[0].equals("I")){
                pq.offer(Integer.parseInt(commend[1]));
                r_pq.offer(Integer.parseInt(commend[1]));
            }
            else if(commend[0].equals("D") && !pq.isEmpty()){
                if(commend[1].equals("-1")){
                    int tmp =pq.poll();
                    r_pq.remove(tmp);
                }
                    
                if(commend[1].equals("1")){
                    int tmp =r_pq.poll();
                    pq.remove(tmp);
                }
            }
        }
        
        int[] answer = new int[2];
        if(!pq.isEmpty()){
            answer[1]= pq.poll();
            answer[0] = r_pq.poll();
        }else{
            answer[0]= 0;
            answer[1] = 0;
        }
        return answer;
    }
}