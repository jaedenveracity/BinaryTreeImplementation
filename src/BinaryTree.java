import java.util.ArrayList;

public class BinaryTree {

    private BinaryTreeNode rootNode = null;

    enum TraversalTypes
    {
        INORDER,
        PREORDER,
        POSTORDER
    }

    public BinaryTree ()
    {

    }

    public BinaryTreeNode getRootNode() {
        return rootNode;
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

    public void returnAllNodes(TraversalTypes traversalType)
    {
        if (traversalType == TraversalTypes.POSTORDER)
        {
            this.postOrderTraversal(this.getRootNode());
        }
        else if (traversalType == TraversalTypes.PREORDER)
        {
            this.preOrderTraversal(this.getRootNode());
        }
        else if (traversalType == TraversalTypes.INORDER)
        {
            this.inOrderTraversal(this.getRootNode());
        }
        System.out.println("\n");
    }

    private void postOrderTraversal(BinaryTreeNode rootNode)
    {
        if (rootNode == null)
        {
            return;
        }

        postOrderTraversal(rootNode.getLeftChildNode());
        postOrderTraversal(rootNode.getRightChildNode());
        System.out.print(rootNode.getNodeKey() + ",");
    }

    private void preOrderTraversal(BinaryTreeNode rootNode)
    {
        if (rootNode == null)
        {
            return;
        }
        System.out.print(rootNode.getNodeKey() + ",");
        preOrderTraversal(rootNode.getLeftChildNode());
        preOrderTraversal(rootNode.getRightChildNode());
    }

    private void inOrderTraversal(BinaryTreeNode rootNode)
    {
        if (rootNode == null)
        {
            return;
        }
        inOrderTraversal(rootNode.getLeftChildNode());
        System.out.print(rootNode.getNodeKey() + ",");
        inOrderTraversal(rootNode.getRightChildNode());
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

    public BinaryTreeNode findParentNode(int KeyValue)
    {
        BinaryTreeNode currentNode = this.rootNode;
        BinaryTreeNode parentNode = null;

        while(true)
        {
            if(KeyValue < currentNode.getNodeKey())
            {
                parentNode = currentNode;
                currentNode = currentNode.getLeftChildNode();
            }
            else if (KeyValue > currentNode.getNodeKey())
            {
                parentNode = currentNode;
                currentNode = currentNode.getRightChildNode();
            }
            else if (KeyValue == currentNode.getNodeKey())
            {
                return parentNode;
            }

        }

    }

    //Delete a node -- cut off whatever is referencing it
    //have it's parent node reference it's child node
    //have it reference no nodes

    //TODO: Implement Delete Node and call in Main
    public void deleteNode (int KeyValue)
    {
        System.out.println("Attempting to delete node with key value of: " + KeyValue + ".");

        if (this.findNode(KeyValue) == null)
        {
            System.out.println("The value: " + KeyValue + ", does not exist in the tree.");
            return;
        }

        BinaryTreeNode toDeleteNode = null;
        BinaryTreeNode parentNode = null;
        BinaryTreeNode leftChildNode = null;
        BinaryTreeNode rightChildNode = null;
        BinaryTreeNode nextInOrderNode = null;

        toDeleteNode = this.findNode(KeyValue);
        parentNode = this.findParentNode(KeyValue);
        leftChildNode = toDeleteNode.getLeftChildNode();
        rightChildNode = toDeleteNode.getRightChildNode();



        //Node is a leaf node --------------------
        if (toDeleteNode.getLeftChildNode() == null & toDeleteNode.getRightChildNode() == null)
        {
            if (parentNode.getRightChildNode() == toDeleteNode)
            {

                parentNode.setRightChildNode(null);
            }
            else if (parentNode.getLeftChildNode() == toDeleteNode)
            {
                parentNode.setLeftChildNode(null);
            }
            else if (toDeleteNode == this.getRootNode())
            {
                System.out.println("Node is also the root Node so now the tree is empty!");
                this.rootNode = null;
            }
        }

        //-----------------------------------------

        //Parent is a value - one child either side
        //right of parent
        //root node with one subtree
        if (toDeleteNode == this.getRootNode())
        {
            if (toDeleteNode.getLeftChildNode() == null)
            {
                this.rootNode = toDeleteNode.getRightChildNode();
            }
            else if (toDeleteNode.getRightChildNode() == null)
            {
                this.rootNode = toDeleteNode.getLeftChildNode();
            }
        }
        else if (toDeleteNode.getNodeKey() > parentNode.getNodeKey())
        {
            if (toDeleteNode.getLeftChildNode() == null)
            {
                parentNode.setRightChildNode(toDeleteNode.getRightChildNode());
            }
            if (toDeleteNode.getRightChildNode() == null)
            {
                parentNode.setRightChildNode(toDeleteNode.getLeftChildNode());
            }

        }
        //left of parent
        else if (toDeleteNode.getNodeKey() < parentNode.getNodeKey())
        {
            if (toDeleteNode.getLeftChildNode() == null)
            {
                parentNode.setLeftChildNode(toDeleteNode.getRightChildNode());
            }
            if (toDeleteNode.getRightChildNode() == null)
            {
                parentNode.setLeftChildNode(toDeleteNode.getLeftChildNode());
            }
        }

        //toDeleteNode has two children
        //right of parent -- get next inorder value and replace it

        if (toDeleteNode.getRightChildNode() != null & toDeleteNode.getLeftChildNode() != null)
        {
            System.out.println("Node has a right and left subtree - gonna be fun!");
            System.out.println("Node with value: " + toDeleteNode + " - has a parent value of: " + parentNode + ", a left child with value: " + toDeleteNode.getLeftChildNode() + ", and a right child with value: " + toDeleteNode.getRightChildNode())  ;
            nextInOrderNode = toDeleteNode.getRightChildNode();

            while (nextInOrderNode.getLeftChildNode() != null)
            {
                nextInOrderNode = nextInOrderNode.getLeftChildNode();
            }
            System.out.println("Next in order key value found with a value of: " + nextInOrderNode);

            //Delete reference in tree
            this.deleteNode(nextInOrderNode.getNodeKey());
            this.returnAllNodes(TraversalTypes.INORDER);

            nextInOrderNode.setLeftChildNode(toDeleteNode.getLeftChildNode());
            nextInOrderNode.setRightChildNode(toDeleteNode.getRightChildNode());
            System.out.println("Next in order now has a left child node of: " + nextInOrderNode.getLeftChildNode() + ", and a right child node of: " + nextInOrderNode.getRightChildNode());

            //set parent node to reference nextInOrderNode - remove parent reference
            if (parentNode != null)
            {
                System.out.println("Parent node is not null!");
                System.out.println("Parent node's left child node is: " + parentNode.getLeftChildNode());
                System.out.println("Parent node's right child node is: " + parentNode.getRightChildNode());
                if (parentNode.getLeftChildNode() == toDeleteNode)
                {
                    parentNode.setLeftChildNode(nextInOrderNode);
                    System.out.println("Parent Node with key value: " + parentNode + ", is now referencing as it's left child next in order with key value: " + nextInOrderNode);
                }
                else if (parentNode.getRightChildNode() == toDeleteNode)
                {
                    parentNode.setRightChildNode(nextInOrderNode);
                    System.out.println("Parent Node with key value: " + parentNode + ", is now referencing next in order as it's right child with key value: " + nextInOrderNode);
                }
            }

            //if parent node is null then root references nextInOrderNode
            else if (parentNode == null)
            {
                System.out.println("To delete node is the root of the tree, the root is now referencing nextInOrderNode with value: " + nextInOrderNode);
                this.rootNode = nextInOrderNode;
            }

            //handle children node references

            //dereference toDeleteNode - Garbage collection should pick it up
            toDeleteNode.setRightChildNode(null);
            toDeleteNode.setLeftChildNode(null);

            System.out.println("--------------------------------------");
            System.out.println("After deleting node with value: " + KeyValue);
            this.returnAllNodes(BinaryTree.TraversalTypes.INORDER);
        }

    }

    


}
