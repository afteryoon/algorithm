
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String cmd=br.readLine();
            if (cmd.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            boolean flag= true;
            for (int i = 0; i < cmd.length(); i++) {
                char check = cmd.charAt(i);

                if (check == '(' || check == '[' )
                    stack.push(check);
                else if (check == ')' || check == ']') {
                    if (stack.isEmpty()) {
                        flag=false;
                        break;
                    }else {
                        char tmp =stack.peek();
                        if((check==')' && tmp=='[') || (check==']' &&tmp=='(')) {
                            break;
                        }
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty() && flag){
                sb.append("yes"+"\n");
            }else
                sb.append("no"+"\n");
        }


        System.out.println(sb);
    }
}