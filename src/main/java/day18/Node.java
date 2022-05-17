package day18;

public class Node {
    private int value;
    private Node rightChild;
    private Node leftChild;

    public Node(int value) {
        this.value = value;
        rightChild = null;
        leftChild = null;
    }

    public int getValue() {
        return value;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }
}
