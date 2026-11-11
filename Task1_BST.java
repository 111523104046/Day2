
public class Task1_BST {

    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    static Node root = null;

    // INSERT
    static Node insert(Node root, int value) {

        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        }
        else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // SEARCH
    static boolean search(Node root, int key) {

        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // FIND HEIGHT (measured in edges)
    static int height(Node root) {

        if (root == null) {
            return -1;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // INORDER TRAVERSAL
    static void inorder(Node root) {

        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String args[]) {

        int hubs[] = {50, 30, 70, 20, 40, 60, 80};

        System.out.println("LOGISTICS HUB BST");

        for (int hub : hubs) {
            root = insert(root, hub);
        }

        System.out.print("Hub Codes: ");
        inorder(root);

        int key = 40;

        System.out.println("\n\nSearching Hub: " + key);

        if (search(root, key)) {
            System.out.println("Hub Found");
        }
        else {
            System.out.println("Hub Not Found");
        }

        System.out.println("Tree Height: " + height(root));

        // Sorted input example
        Node sortedRoot = null;

        int sorted[] = {10, 20, 30, 40, 50};

        for (int value : sorted) {
            sortedRoot = insert(sortedRoot, value);
        }

        System.out.println("Height with sorted input: "
                + height(sortedRoot));
    }
}
