
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    1026 보물
    메모리
    시간
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int [] arrS=new int[n];
        int [] arrRS=new int[n];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arrS[i]=Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arrRS[i]=Integer.parseInt(st.nextToken());

        Arrays.sort(arrS);
        Arrays.sort(arrRS);

        int sum=0;
        for (int i = 0; i <n; i++) {
            sum+=arrS[i]*arrRS[(n-1)-i];
        }
        System.out.println(sum);
    }
}
