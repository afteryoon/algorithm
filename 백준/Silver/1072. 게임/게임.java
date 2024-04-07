import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = calculatePercent(x, y);

        int min = 0;
        int max = 1_000_000_000;
        int result = -1;
        while(min <= max){
            int mid = (max + min)/2;
            int win_percent = calculatePercent(x+mid, y+mid);

            if(win_percent > z){
                result = mid;
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }
        
        br.close();

        System.out.println(result);
    }

    static int calculatePercent(int x, int y){
        return (int)((long)y * 100 /x);
    }
}