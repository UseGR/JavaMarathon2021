package day18;

public class Task3 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(20);
        binaryTree.addNode(150);
        binaryTree.addNode(23);
        binaryTree.addNode(27);
        binaryTree.addNode(24);
        binaryTree.addNode(8);
        binaryTree.addNode(14);
        binaryTree.addNode(11);
        binaryTree.addNode(16);
        binaryTree.addNode(5);
        binaryTree.addNode(22);
        binaryTree.addNode(15);
        binaryTree.addNode(18);

        if (binaryTree.getRootNode() != null) {
            binaryTree.dfs(binaryTree.getRootNode().getLeftChild());
            System.out.print(binaryTree.getRootNode().getValue() + " ");
            binaryTree.dfs(binaryTree.getRootNode().getRightChild());
        }
    }
}