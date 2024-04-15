
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(dp(n));
    }
    private static long dp(int n){
        if (n<=2){
            return 1;
        }
        long[] dp=new long[n+1];
        dp[1]=1;
        dp[2]=1;

        for (int i = 3; i <=n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
