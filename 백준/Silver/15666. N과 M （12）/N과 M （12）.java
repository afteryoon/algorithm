

import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static int [] arr,result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        backtrack(0, 0);

        System.out.print(sb);

    }

    static void backtrack(int depth, int start) {
        if(depth == m ) {
            for (int i=0; i< m; i++ ) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for (int i=start; i<n; i++ ) {
            if(prev != arr[i]) {
                result[depth] = arr[i];
                prev = arr[i];
                backtrack(depth+1,i);
            }
        }

    }

}
