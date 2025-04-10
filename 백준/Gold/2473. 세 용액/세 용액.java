import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] solutions = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            solutions[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(solutions);
        
        long[] answer = new long[3];
        long minDiff = Long.MAX_VALUE;
        
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                long sum = solutions[i] + solutions[left] + solutions[right];
                long diff = Math.abs(sum);
                
                if (diff < minDiff) {
                    minDiff = diff;
                    answer[0] = solutions[i];
                    answer[1] = solutions[left];
                    answer[2] = solutions[right];
                }
                
                if (sum < 0) {
                    left++;
                } 
                
                else if (sum > 0) {
                    right--;
                } 
               
                else {
                    i = n;
                    break;
                }
            }
        }
        

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}