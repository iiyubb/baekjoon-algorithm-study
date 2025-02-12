package BOJ_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Node{
    char val;
    Node left;
    Node right;
    public Node(char val) {
        this.val = val;
    }
}

public class 트리순회_이유빈 {
    static Map<Character, Node> tree = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.putIfAbsent(parent, new Node(parent));

            Node parentNode = tree.get(parent);

            if (left != '.') {
                parentNode.left = new Node(left);
                tree.put(left, parentNode.left);
            }

            if(right != '.') {
                parentNode.right = new Node(right);
                tree.put(right, parentNode.right);
            }
        }

        //각각 순회 저장
        preOrder(tree.get('A'));
        sb.append("\n");
        inOrder(tree.get('A'));
        sb.append("\n");
        postOrder(tree.get('A'));

        System.out.println(sb);
    }

    // 전위 순회 (루트 -> 왼쪽 -> 오른쪽)
    static void preOrder(Node node) {
        if (node == null) return;
        sb.append(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위 순회 (왼쪽 -> 루트 -> 오른쪽)
    static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        sb.append(node.val);
        inOrder(node.right);
    }

    // 후위 순회 (왼쪽 -> 오른쪽 -> 루트)
    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.val);
    }
}