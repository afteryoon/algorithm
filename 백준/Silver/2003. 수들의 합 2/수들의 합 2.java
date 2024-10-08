
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());

        int[] arr= new int[n];
        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int left=0;
        int right=0;
        int count=0;
        int sum=0;

        while (true){
            if(sum>=m){
                if (sum==m)
                    count++;
                sum-=arr[left++];
            } else if (right==n) {
                break;
            }else {
                sum+=arr[right++];
            }
           // System.out.println(right+":right "+left+":left "+sum+":sum ");
        }


        System.out.println(count);
    }
}
