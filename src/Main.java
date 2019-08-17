public class Main {

    public static void main(String[] args) {

        boolean success = false;

        BinaryTreeNode checkedNode = null;
        BinaryTree testBinaryTree = new BinaryTree();

        System.out.println(testBinaryTree.addNewNode(15));
        System.out.println(testBinaryTree.addNewNode(22));
        System.out.println(testBinaryTree.addNewNode(8));
        System.out.println(testBinaryTree.addNewNode(45));
        System.out.println(testBinaryTree.addNewNode(37));
        System.out.println(testBinaryTree.addNewNode(75));
        System.out.println(testBinaryTree.addNewNode(42));
        System.out.println(testBinaryTree.addNewNode(42));
        System.out.println(testBinaryTree.addNewNode(12));
        System.out.println(testBinaryTree.addNewNode(19));
        System.out.println(testBinaryTree.addNewNode(89));
        System.out.println(testBinaryTree.addNewNode(33));
        System.out.println(testBinaryTree.addNewNode(45));
        System.out.println(testBinaryTree.addNewNode(64));
        System.out.println(testBinaryTree.addNewNode(59));
        System.out.println(testBinaryTree.addNewNode(1));
        System.out.println(testBinaryTree.addNewNode(46));
        System.out.println(testBinaryTree.addNewNode(3));
        System.out.println(testBinaryTree.addNewNode(55));
        System.out.println(testBinaryTree.addNewNode(5));

        testBinaryTree.printAllNodes();

        checkedNode = testBinaryTree.findNode(14);
        testBinaryTree.findNode(37);
        testBinaryTree.findNode(100);
        testBinaryTree.findNode(89);
        testBinaryTree.findNode(55);

        testBinaryTree.deleteNode(55);

        //testBinaryTree.printAllNodes();


    }
}

