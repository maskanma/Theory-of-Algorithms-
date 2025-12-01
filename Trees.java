import java.util.*;

public class Trees {

    // ===== БІНАРНЕ ДЕРЕВО ПОШУКУ (BST) =====
    static class BST {
        static class Node {
            int key;
            Node left, right;

            Node(int key) {
                this.key = key;
            }
        }

        Node root;

        void insert(int key) {
            root = insertRec(root, key);
        }

        private Node insertRec(Node node, int key) {
            if (node == null) return new Node(key);
            if (key < node.key) {
                node.left = insertRec(node.left, key);
            } else if (key > node.key) {
                node.right = insertRec(node.right, key);
            }
            return node;
        }

        void delete(int key) {
            root = deleteRec(root, key);
        }

        private Node deleteRec(Node node, int key) {
            if (node == null) return null;

            if (key < node.key) {
                node.left = deleteRec(node.left, key);
            } else if (key > node.key) {
                node.right = deleteRec(node.right, key);
            } else {
                // найден узел
                if (node.left == null) return node.right;
                if (node.right == null) return node.left;
                // два потомка: берём мінімум справа
                Node minRight = minNode(node.right);
                node.key = minRight.key;
                node.right = deleteRec(node.right, minRight.key);
            }
            return node;
        }

        private Node minNode(Node node) {
            while (node.left != null) node = node.left;
            return node;
        }

        void preorder() {
            preorderRec(root);
            System.out.println();
        }

        private void preorderRec(Node node) {
            if (node == null) return;
            System.out.print(node.key + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }

        void inorder() {
            inorderRec(root);
            System.out.println();
        }

        private void inorderRec(Node node) {
            if (node == null) return;
            inorderRec(node.left);
            System.out.print(node.key + " ");
            inorderRec(node.right);
        }

        void postorder() {
            postorderRec(root);
            System.out.println();
        }

        private void postorderRec(Node node) {
            if (node == null) return;
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.key + " ");
        }
    }

    // ===== ЧЕРВОНО-ЧОРНЕ ДЕРЕВО (RBT) =====
    static class RedBlackTree {
        private static final boolean RED = true;
        private static final boolean BLACK = false;

        static class Node {
            int key;
            boolean color;
            Node left, right, parent;

            Node(int key, boolean color) {
                this.key = key;
                this.color = color;
            }
        }

        private Node root;

        public void insert(int key) {
            Node z = new Node(key, RED);
            Node y = null;
            Node x = root;

            while (x != null) {
                y = x;
                if (z.key < x.key) {
                    x = x.left;
                } else if (z.key > x.key) {
                    x = x.right;
                } else {
                    return; // дубликаты не вставляем
                }
            }

            z.parent = y;
            if (y == null) {
                root = z;
            } else if (z.key < y.key) {
                y.left = z;
            } else {
                y.right = z;
            }

            fixInsert(z);
        }

        private void fixInsert(Node z) {
            while (z.parent != null && z.parent.color == RED) {
                if (z.parent == z.parent.parent.left) {
                    Node y = z.parent.parent.right; // дядя
                    if (y != null && y.color == RED) {
                        z.parent.color = BLACK;
                        y.color = BLACK;
                        z.parent.parent.color = RED;
                        z = z.parent.parent;
                    } else {
                        if (z == z.parent.right) {
                            z = z.parent;
                            leftRotate(z);
                        }
                        z.parent.color = BLACK;
                        z.parent.parent.color = RED;
                        rightRotate(z.parent.parent);
                    }
                } else {
                    Node y = z.parent.parent.left; // дядя
                    if (y != null && y.color == RED) {
                        z.parent.color = BLACK;
                        y.color = BLACK;
                        z.parent.parent.color = RED;
                        z = z.parent.parent;
                    } else {
                        if (z == z.parent.left) {
                            z = z.parent;
                            rightRotate(z);
                        }
                        z.parent.color = BLACK;
                        z.parent.parent.color = RED;
                        leftRotate(z.parent.parent);
                    }
                }
            }
            root.color = BLACK;
        }

        private void leftRotate(Node x) {
            Node y = x.right;
            x.right = y.left;
            if (y.left != null) {
                y.left.parent = x;
            }
            y.parent = x.parent;
            if (x.parent == null) {
                root = y;
            } else if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
            y.left = x;
            x.parent = y;
        }

        private void rightRotate(Node x) {
            Node y = x.left;
            x.left = y.right;
            if (y.right != null) {
                y.right.parent = x;
            }
            y.parent = x.parent;
            if (x.parent == null) {
                root = y;
            } else if (x == x.parent.right) {
                x.parent.right = y;
            } else {
                x.parent.left = y;
            }
            y.right = x;
            x.parent = y;
        }

        public void preorder() {
            preorderRec(root);
            System.out.println();
        }

        private void preorderRec(Node node) {
            if (node == null) return;
            System.out.print(node.key + (node.color == RED ? "R " : "B "));
            preorderRec(node.left);
            preorderRec(node.right);
        }

        public void inorder() {
            inorderRec(root);
            System.out.println();
        }

        private void inorderRec(Node node) {
            if (node == null) return;
            inorderRec(node.left);
            System.out.print(node.key + (node.color == RED ? "R " : "B "));
            inorderRec(node.right);
        }

        public void postorder() {
            postorderRec(root);
            System.out.println();
        }

        private void postorderRec(Node node) {
            if (node == null) return;
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.key + (node.color == RED ? "R " : "B "));
        }
    }

    public static void main(String[] args) {
        int[] keys = {11, 42, 67, 55, 65, 78, 25, 50, 69};

        BST bst = new BST();
        RedBlackTree rbt = new RedBlackTree();

        for (int k : keys) {
            bst.insert(k);
            rbt.insert(k);
        }

        System.out.println("BST inorder:");
        bst.inorder();

        System.out.println("BST preorder:");
        bst.preorder();

        System.out.println("BST postorder:");
        bst.postorder();

        System.out.println();

        System.out.println("RBT inorder (key+color):");
        rbt.inorder();

        System.out.println("RBT preorder (key+color):");
        rbt.preorder();

        System.out.println("RBT postorder (key+color):");
        rbt.postorder();

        bst.delete(67);
        bst.delete(25);
        bst.delete(42);

        System.out.println();
        System.out.println("BST inorder после удаления 67, 25, 42:");
        bst.inorder();
    }
}
