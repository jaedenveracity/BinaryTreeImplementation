import java.util.ArrayList;

public class BinaryTree {

    BinaryTreeNode rootNode = null;

    public BinaryTree ()
    {

    }

    public BinaryTree (int RootKeyValue)
    {
        rootNode = new BinaryTreeNode(RootKeyValue);
    }

    //Add a new node
    public boolean addNewNode(int KeyValue)
    {
        BinaryTreeNode currentNode = rootNode;

        if(rootNode == null)
        {
            rootNode = new BinaryTreeNode(KeyValue);
            System.out.println("Root node added with a value of: " + rootNode.getNodeKey());
            return true;

        }
        while(currentNode.checkChildNodes(KeyValue) != null)
        {
            //Searches tree next location in the tree where node could go and sets our current position there
            currentNode = currentNode.checkChildNodes(KeyValue);

            //Continues checking the child nodes underneath our current position
            currentNode.checkChildNodes(KeyValue);

        }
        //Once the position is found where the new node needs to go (either right or left), we then verify which side of the node the value needs to go on
        if (KeyValue < currentNode.getNodeKey())
        {
            currentNode.setLeftChildNode(new BinaryTreeNode(KeyValue));
            System.out.println("The new node value: " + KeyValue + ", is less than the current node's value of: " + currentNode.getNodeKey());
            return true;
        }
        else if (KeyValue > currentNode.getNodeKey())
        {
            currentNode.setRightChildNode(new BinaryTreeNode(KeyValue));
            System.out.println("The new node value: " + KeyValue + ", is more than the current node's value of: " + currentNode.getNodeKey());
            return true;
        }
        else {
            System.out.println("Error key already exists in tree");
            return false;

        }
    }

    //print out all nodes
    public void printAllNodes()
    {
        ArrayList<BinaryTreeNode> allNodesList = new ArrayList<>();

        if (this.rootNode != null) {

            BinaryTreeNode currentNode = this.rootNode;

            allNodesList = currentNode.returnChildNodes();

            System.out.println(allNodesList);
        }

        else
        {
            System.out.println(allNodesList);
        }

    }

    //Search for a node
    public BinaryTreeNode findNode(int KeyValue)
    {
        try {
            BinaryTreeNode currentNode = this.rootNode;

            System.out.println("----------SEARCH----------");
            currentNode = currentNode.updatedSearchNode(KeyValue);

            if (currentNode == null) {
                System.out.println(KeyValue + ": was not found within tree");
                System.out.println("--------END-------------");
                return currentNode;
            } else {
                System.out.println(KeyValue + ": was found within tree");
                System.out.println("---------END------------");
                return currentNode;
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("Key Value: " + KeyValue + ", was not found within tree.");
            System.out.println("------------END---------------");
            return null;
        }
    }

    //Delete a node -- cut off whatever is referencing it
    //have it's parent node reference it's child node
    //have it reference no nodes

    public void deleteNode (int KeyValue)
    {
        BinaryTreeNode toDeleteNode = null;
        toDeleteNode = this.findNode(KeyValue);

        if (toDeleteNode != null)
        {
            toDeleteNode = null;
        }
    }

    //Check hello


}
