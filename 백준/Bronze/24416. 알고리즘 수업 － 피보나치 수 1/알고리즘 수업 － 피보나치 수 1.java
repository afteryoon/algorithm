
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int arr[];
    static int count1=0;
    static int count2=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        arr=new int[n+1];
        fibonacci(n);
        fib(n);
        System.out.println(count1);
        System.out.println(count2);

    }
    private static int fibonacci(int n){
        if(n<=2) {
            count1++;
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    private static int fib(int n){
        if(n<=2)    return 1;

        arr[1]=arr[2]=1;
        int count=0;
        for (int i = 3; i <=n; i++) {
            count2++;
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
