
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
        2018 수들의 합 5 투포인터

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int count=0;
        int left=1;
        int right=1;
        int sum=0;

        while(left<=n){
            if(sum<=n){
                if(sum==n)
                    count++;
                sum+=right;
                right++;
            } else {
                sum-=left;
                left++;
            }
            //System.out.println(left+":left "+right+":right "+sum+":sum");
        }
        System.out.println(count);

    }
}
