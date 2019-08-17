import java.util.ArrayList;

public class BinaryTreeNode {

    private BinaryTreeNode leftChildNode;
    private BinaryTreeNode rightChildNode;
    private int nodeKey;

    public BinaryTreeNode()
    {
        leftChildNode = null;
        rightChildNode = null;
        int nodeKey = -1;
    }

    public BinaryTreeNode(int keyValue)
    {
        leftChildNode = null;
        rightChildNode = null;
        nodeKey = keyValue;
    }

    public BinaryTreeNode getLeftChildNode() {
        return leftChildNode;
    }

    public void setLeftChildNode(BinaryTreeNode leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public BinaryTreeNode getRightChildNode() {
        return rightChildNode;
    }

    public void setRightChildNode(BinaryTreeNode rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    public int getNodeKey() {
        return this.nodeKey;
    }

    public void setNodeKey(int nodeKey) {
        this.nodeKey = nodeKey;
    }

    public BinaryTreeNode checkChildNodes(int KeyValue)
    {
        if(this.getLeftChildNode() != null & KeyValue < this.getNodeKey())
        {
            return this.getLeftChildNode();
        }
        else if (this.getRightChildNode() != null & KeyValue > this.getNodeKey())
        {
            return this.getRightChildNode();
        }
        else
        {
            return null;
        }

    }

    public ArrayList<BinaryTreeNode> returnChildNodes() {

        ArrayList<BinaryTreeNode> allNodes = new ArrayList<>();
        BinaryTreeNode currentNode = this;

        if (currentNode == null) {
            System.out.println("Root value is null, nothing being returned.");
            return allNodes;
        }

        allNodes.add(currentNode);

        BinaryTreeNode.getChildNodes(allNodes, currentNode);


        return allNodes;

    }

    public static void getChildNodes(ArrayList<BinaryTreeNode> passedList, BinaryTreeNode rootNode)
    {
        BinaryTreeNode currentNode = rootNode;

        if (currentNode.getLeftChildNode() != null)
        {
            currentNode = currentNode.getLeftChildNode();
            passedList.add(currentNode);

            BinaryTreeNode.getChildNodes(passedList, currentNode);

        }

        currentNode = rootNode;

        if (currentNode.getRightChildNode() != null)
        {
            currentNode = currentNode.getRightChildNode();
            passedList.add(currentNode);

            BinaryTreeNode.getChildNodes(passedList, currentNode);
        }
    }

    /*

    public BinaryTreeNode searchNode(int KeyValue)
    {
        BinaryTreeNode currentNode = this;
        System.out.println("Current node's value is: " + currentNode.getNodeKey());


            if (KeyValue == currentNode.getNodeKey()) {
                System.out.println("Match was found returning the node.");
                return currentNode;

            } else if (KeyValue < currentNode.getNodeKey()) {
                System.out.println("The key value: " + KeyValue + ", is less than our current node's key value of: " + currentNode.getNodeKey() + ". Continuing the search.");
                currentNode = currentNode.getLeftChildNode();
                currentNode.searchNode(KeyValue);

            } else if (KeyValue > currentNode.getNodeKey()) {
                System.out.println("The key value: " + KeyValue + ", is more than our current node's key value of: " + currentNode.getNodeKey() + ". Continuing the search.");
                currentNode = currentNode.getRightChildNode();
                currentNode.searchNode(KeyValue);

            }

            return null;

    }
     */

    public BinaryTreeNode updatedSearchNode(int KeyValue) throws NullPointerException
    {
        BinaryTreeNode currentNode = this;
        boolean found = false;
        boolean noValueInTree = false;

        while (!found | !noValueInTree)
        {
            if (KeyValue < currentNode.getNodeKey())
            {
                System.out.println("Key Value: " + KeyValue + " is less than current node's key of: " + currentNode.getNodeKey() + ". Continuing search.");
                currentNode = currentNode.getLeftChildNode();
            }
            else if (KeyValue > currentNode.getNodeKey())
            {
                System.out.println("Key Value: " + KeyValue + " is more than current node's key of: " + currentNode.getNodeKey() + ". Continuing search.");
                currentNode = currentNode.getRightChildNode();
            }
            else if (KeyValue == currentNode.getNodeKey())
            {
                return currentNode;
            }
            else
            {
                noValueInTree = true;
            }


        }

        return null;
    }

    @Override
    public String toString()
    {
        return Integer.toString(this.getNodeKey());
    }

}
