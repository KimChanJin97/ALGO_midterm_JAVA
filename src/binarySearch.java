import java.util.Scanner;

// 이진트리검색
public class binarySearch {
    static public node root;
    static int size = 0;
    static int sum = 0;
    public static void main(String[] args)
    {
        root = null;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int k = sc.nextInt();
            size = 0;
            sum = 0;
            binarySearch b = new binarySearch();
            for(int j = 0; j < k; j++){
                b.insert(sc.nextInt());
            }
            b.getSize(root);
            b.sumOfweight(root);
            System.out.println(size);
            System.out.println(b.getHeight(root));
            System.out.println(sum);
            System.out.println(b.maxPathWeight(root)+root.data);
            b.mirror(root);
            b.preOrder(root);
            System.out.println();
            b.inorder(root);
            System.out.println();
            b.postorder(root);
            System.out.println();
            b.destruct();
            if(root == null) System.out.println(0);
            else System.out.println(1);
        }
    }
    public void mirror(node fnode){
        if (fnode == null) return;
        mirror(fnode.left);
        mirror(fnode.right);
        fnode.swap();
    }
    public void destruct(){
        root = null;
    }
    public void sumOfweight(node fnode){
        if(fnode != null){
            sum += fnode.data;
            sumOfweight(fnode.left);
            sumOfweight(fnode.right);
        }
    }
    public int maxPathWeight(node fnode){
        if(fnode.left == null && fnode.right == null){
            return 0;
        }
        else if(fnode.left == null){
            return fnode.right.data + maxPathWeight(fnode.right);
        }
        else if(fnode.right == null){
            return fnode.left.data + maxPathWeight(fnode.left);
        }
        else{
            return Math.max(fnode.left.data + maxPathWeight(fnode.left), fnode.right.data + maxPathWeight(fnode.right));
        }

    }
    public int getHeight(node fnode){
        if(fnode == null) return -1;
        return Math.max(getHeight(fnode.left), getHeight(fnode.right)) + 1;
    }
    class node
    {
        public int data;
        public node left;
        public node right;
        private node(int data){
            this.data = data;
        }
        public void swap(){
            node tmp = this.left;
            this.left = this.right;
            this.right = tmp;
        }
    }

    public void insert(int data)
    {
        node newNode = new node(data);
        if(root == null){
            root = newNode;
        }
        else{
            node focusNode = root;
            node parent;
            while (true){
                parent = focusNode;
                if(data < parent.data){
                    focusNode = parent.left;
                    if(focusNode == null){
                        parent.left = newNode;
                        return;
                    }
                }
                else{
                    focusNode = parent.right;
                    if(focusNode == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    public void getSize(node fnode){
        if(fnode != null){
            size++;
            getSize(fnode.left);
            getSize(fnode.right);
        }
    }
    public void inorder(node fnode){
        if(fnode != null){
            inorder(fnode.left);
            System.out.print(fnode.data + " ");
            inorder(fnode.right);
        }
    }
    public void preOrder(node fnode){
        if(fnode != null){
            System.out.print(fnode.data  + " ");
            preOrder(fnode.left);
            preOrder(fnode.right);
        }
    }
    public void postorder(node fnode){
        if(fnode != null){
            postorder(fnode.left);
            postorder(fnode.right);
            System.out.print(fnode.data + " ");
        }
    }
}