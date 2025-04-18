class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        
         boolean[][] isPuddle = new boolean[n+1][m+1];
        for (int[] puddle : puddles) {
            isPuddle[puddle[1]][puddle[0]] = true;
        }
        
        dp[1][1] = 1;
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(isPuddle[i][j] || (i==1 &&j==1)) continue;
                
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000007;
            }
        }
        
        return dp[n][m];
    }
}