package day18;

public class BinaryTree {
    private Node rootNode;

    public BinaryTree() {
        rootNode = null; //изначально дерево пустое
    }

    public Node getRootNode() {
        return rootNode;
    }

    private Node insert(int value, Node currentNode) {
        if(currentNode == null)
            return new Node(value); //добавили в пустое дерево первый узел, он стал корневым
        if (value < currentNode.getValue()) { //для дальнейших добавлений узлов проверяем условие: значение добавляемого узла меньше корневого узла?
            currentNode.setLeftChild(insert(value,currentNode.getLeftChild())); //если да, то добавляемый узел становится левым потомком корневого узла
        } else if (value > currentNode.getValue()) { //значение добавляемого узла больше корневого узла?
            currentNode.setRightChild(insert(value, currentNode.getRightChild())); // если да, то добавляемый узел становится правым потомком корневого узла
        }else
            return currentNode;
        return currentNode;
    }

    public void addNode(int value) {
        rootNode = insert(value, rootNode);
    }

    public void dfs(Node node) {
        if (node != null) {
            dfs(node.getLeftChild()); // выводим левых потомков
            System.out.print(node.getValue() + " ");
            dfs(node.getRightChild()); // выводим правых потомков
        }
    }
}
