import java.util.*;

class Solution {
    static class Node {
        int id;
        int x, y;
        Node left, right;
        
        public Node(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.left = null;
            this.right = null;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        
        // 노드 정보 저장
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        // y좌표 내림차순, 같으면 x좌표 오름차순으로 정렬
        Arrays.sort(nodes, (a, b) -> {
            if(a.y == b.y) return a.x - b.x;
            return b.y - a.y;
        });
        
        // 트리 구성 - 루트 노드는 정렬 후 첫 번째 노드
        Node root = nodes[0];
        for(int i = 1; i < n; i++) {
            insertNode(root, nodes[i]);
        }
        
        // 전위 순회 결과 저장
        List<Integer> preorderList = new ArrayList<>();
        preorder(root, preorderList);
        
        // 후위 순회 결과 저장
        List<Integer> postorderList = new ArrayList<>();
        postorder(root, postorderList);
        
        // 결과 변환
        int[][] answer = new int[2][n];
        for(int i = 0; i < n; i++) {
            answer[0][i] = preorderList.get(i);
            answer[1][i] = postorderList.get(i);
        }
        
        return answer;
    }
    
    // 노드 삽입
    private void insertNode(Node parent, Node child) {
        if(child.x < parent.x) {  // 왼쪽 자식
            if(parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {  // 오른쪽 자식
            if(parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }
    
    // 전위 순회 (root -> left -> right)
    private void preorder(Node node, List<Integer> result) {
        if(node == null) return;
        result.add(node.id);
        preorder(node.left, result);
        preorder(node.right, result);
    }
    
    // 후위 순회 (left -> right -> root)
    private void postorder(Node node, List<Integer> result) {
        if(node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.id);
    }
}