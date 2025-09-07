package AVLTree;

public class Node<T> {
    private int key;
    private T value;
    private Node<?> left;
    private Node<?> right;
    private int height;
    private int balance;

    public Node(int key, T value) {
        this.key = key;
        this.value = value;
        this.height = 0;
    }

    public Node<?> getLeft() {
        return left;
    }

    public Node<?> getRight() {
        return right;
    }

    public void setLeft(Node<?> left) {
        this.left = left;
    }

    public void setRight(Node<?> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return getKey() == node.getKey();
    }

    public static int calculateHeight(Node<?> node) {
        if (node != null) {
            return node.height;
        }
        return 0;
    }

    public static int calculateBalance(Node<?> node) {
        if (node != null) {
            return (node.right.getHeight() - node.left.getHeight());
        }
        return 0;
    }

    /*
    Left rotate: When root balance is greater than 1
    1. Left node of root's right becomes temp
    2. Root becomes right node's left
    3. Temp becomes original root's right
    4. Set heights for new root and original root
     */
    public static Node<?> rotateLeft(Node<?> root) {
        Node<?> newRoot = root.getRight();
        Node<?> temp = newRoot.getLeft();
        newRoot.setLeft(root);
        root.setRight(temp);
        root.setHeight(Math.max(root.getLeft().getHeight(), root.getRight().getHeight()) + 1);
        newRoot.setHeight(Math.max(newRoot.getLeft().getHeight(), newRoot.getRight().getHeight()) + 1);
        return newRoot;
    }

    /*
    Opposite of left rotate
     */
    public static Node<?> rotateRight(Node<?> root) {
        Node<?> newRoot = root.getLeft();
        Node<?> temp = newRoot.getRight();
        newRoot.setRight(root);
        root.setLeft(temp);
        root.setHeight(Math.max(root.getLeft().getHeight(), root.getRight().getHeight()) + 1);
        newRoot.setHeight(Math.max(newRoot.getLeft().getHeight(), newRoot.getRight().getHeight()) + 1);
        return newRoot;
    }

    public static Node<?> rotateLR(Node<?> root) {
        rotateLeft(root.getLeft());
        return rotateRight(root);
    }

    public static Node<?> rotateRL(Node<?> root) {
        rotateRight(root.getRight());
        return rotateLeft(root);
    }

    public static Node<?> rebalance(Node<?> root) {
        root.setBalance(calculateBalance(root));
        // Check if root is right-heavy and unbalanced
        if (root.getBalance() > 1) {
            // Additionally, check if root's right child is left-heavy for RL rotation
            if (root.getRight().getBalance() < 0) {
                return rotateRL(root);
            }
            return rotateLeft(root);
        }
        // Check if root is left-heavy and unbalanced
        else if (root.getBalance() < 1) {
            // Additionally, check if root's left child is right-heavy for LR rotation
            if (root.getLeft().getBalance() > 0) {
                return rotateLR(root);
            }
            return rotateRight(root);
        }
        return root;
    }

}
