
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[] arr=new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int answer=0;
        int temp=1;
        for (int i = n-1; i >=0; i--) {
            answer=Math.max(answer,arr[i]*temp);
            temp++;
        }
        System.out.println(answer);

    }
}
