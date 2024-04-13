
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=n%5;
        int bag=n/5;

        if(n==4 || n==7){
            System.out.println(-1);
        }
        else if(m==0){
            System.out.println(bag);
        } else if (m==1 || m==3) {
            System.out.println(bag+1);
        }else if (m==2 || m==4){
            System.out.println(bag+2);
        }

    }

}
