
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int k= Integer.parseInt(br.readLine());
        ArrayList<Integer> ks=new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i <n; i++)
            ks.add(Integer.parseInt(st.nextToken()));

        Collections.sort(ks);
        ArrayList<Integer> distance = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            distance.add(ks.get(i+1)-ks.get(i));
        }
        Collections.sort(distance);
        int sum=0;
        for (int i = 0; i <= distance.size()-k; i++) {
            sum+=distance.get(i);
        }

        System.out.println(sum);

    }
}
