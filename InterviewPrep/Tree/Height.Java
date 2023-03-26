    //Function to find the height of a binary tree.
    int height(Node node) 
    {
        // code here 
        if (node==null) return 0;
        return Math.max(1+height(node.left),1+height(node.right));
    }
