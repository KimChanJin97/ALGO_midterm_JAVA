package config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this(val, null, null);
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class main {
    Node root;

    private Node insertRecursive(Node curr, int val) {
        if (curr == null)
            return new Node(val);

        if (val < curr.val)
            curr.left = this.insertRecursive(curr.left, val);
        else if (val > curr.val)
            curr.right = this.insertRecursive(curr.right, val);
        else
            return curr;

        return curr;
    }

    public void insert(int val) {
        this.root = this.insertRecursive(this.root, val);
    }

    public void preOrder(Node curr) {
        if (curr == null)
            return;
        else {
            System.out.print(curr.val + " ");
            this.preOrder(curr.left);
            this.preOrder(curr.right);
        }
    }

    public void inOrder(Node curr) {
        if (curr == null)
            return;
        else {
            this.inOrder(curr.left);
            System.out.print(curr.val + " ");
            this.inOrder(curr.right);
        }
    }

    public void postOrder(Node curr) {
        if (curr == null)
            return;
        else {
            this.postOrder(curr.left);
            this.postOrder(curr.right);
            System.out.print(curr.val + " ");
        }
    }

    public int size(Node curr) {
        if (curr == null)
            return 0;
        else {
            int left = this.size(curr.left);
            int right = this.size(curr.right);
            return left + right + 1;
        }
    }

    public int height(Node curr) {
        if (curr == null)
            return -1;
        else {
            int left = this.height(curr.left);
            int right = this.height(curr.right);
            int result = (left > right) ? left : right;
            return result + 1;
        }
    }

    public int sumOfWeight(Node curr) {
        if (curr == null)
            return 0;
        else {
            int left = this.sumOfWeight(curr.left);
            int right = this.sumOfWeight(curr.right);
            return left + right + curr.val;
        }
    }

    public int maxPathWeight(Node curr) {
        if (curr == null)
            return 0;
        else {
            int left = this.maxPathWeight(curr.left);
            int right = this.maxPathWeight(curr.right);
            return (left >= right) ? left + curr.val : right + curr.val;
        }
    }

    public void swap(Node node) {
        if (node == null)
            return;

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public void mirror(Node curr) {
        if (curr == null)
            return;
        this.swap(curr);
        this.mirror(curr.left);
        this.mirror(curr.right);
    }

    public Node destruct(Node curr) {
        if (curr != null) {
            this.destruct(curr.left);
            this.destruct(curr.right);

            curr = null;
        }
        return curr;
    }

    public void solve(main temp) {
        System.out.println(temp.size(temp.root));
        System.out.println(temp.height(temp.root));
        System.out.println(temp.sumOfWeight(temp.root));
        System.out.println(temp.maxPathWeight(temp.root));

        temp.mirror(temp.root);

        temp.preOrder(temp.root);
        System.out.println();
        temp.inOrder(temp.root);
        System.out.println();
        temp.postOrder(temp.root);
        System.out.println();

        temp.root = temp.destruct(temp.root);
        if (temp.root == null)
            System.out.println(0);
        else
            System.out.println(1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            main bst = new main();
            bst.root = null;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            for (int i = 0; i < num; i++) {
                int val;
                val = Integer.parseInt(st.nextToken());
                bst.insert(val);
            }

            bst.solve(bst);
        }

        br.close();
    }
}