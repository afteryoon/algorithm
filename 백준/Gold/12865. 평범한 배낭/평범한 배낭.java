import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,k;
    static int[][] arr;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

       n=Integer.parseInt(st.nextToken());
       k=Integer.parseInt(st.nextToken());
       dp = new int[k + 1];
       arr=new int[n][2];
       for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }
        knapsack();

        System.out.println(dp[k]);
    }

    public static void knapsack(){
        for(int i=0; i<n; i++){
            int weight = arr[i][0];
            int value = arr[i][1];

            for(int w=k; w>=weight; w--){
                dp[w] = Math.max(dp[w],dp[w-weight]+value);
            }
        }

    }
}
