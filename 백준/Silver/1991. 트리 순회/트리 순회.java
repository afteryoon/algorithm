
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
        }
    }

    static Node[] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[26];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root  = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if(tree[root -'A'] == null) {
                tree[root - 'A'] = new Node(root);
            }
            if(left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[root-'A'].left = tree[left - 'A'];
            }
            if(right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[root-'A'].right = tree[right - 'A'];
            }
        }

        preorder(tree[0]);
        sb.append("\n");
        inorder(tree[0]);
        sb.append("\n");
        postorder(tree[0]);

        System.out.println(sb);

    }
    public static void preorder(Node node) {
        if(node == null) return;
        sb.append(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if(node == null) return;
        inorder(node.left);
        sb.append(node.data);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.data);
    }
}
