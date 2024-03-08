import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Constructor
    BinaryTree() {
        root = null;
    }

    // Preorder traversal
    void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Inorder traversal
    void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Postorder traversal
    void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Insertion operation
    void inp(Node node, int no) {
        if (node == null)
            return;
        if (no < node.data) {
            if (node.left == null) {
                node.left = new Node(no);
            } else {
                inp(node.left, no);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(no);
            } else {
                inp(node.right, no);
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            BinaryTree tree = new BinaryTree();
            Scanner sc = new Scanner(System.in);
            System.out.println("What is the maximum size of your array?");
            int max = sc.nextInt();
            int[] arr = new int[max];
            for (int i = 0; i < arr.length; i++) {
                System.out.println("Enter a number");
                arr[i] = sc.nextInt();
            }
            tree.root = new Node(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                tree.inp(tree.root, arr[i]);
            }

            System.out.println("Preorder traversal:");
            tree.preorder(tree.root);
            System.out.println("\nInorder traversal:");
            tree.inorder(tree.root);
            System.out.println("\nPostorder traversal:");
            tree.postorder(tree.root);
            System.out.println("Would you like to reuse? 1.) Yes 2.) No");
            int dec = sc.nextInt();
            if (dec != 1) {
                break;
            }
        }
    }
}
