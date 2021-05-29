package Study;

public class HeightOfTreeUsingRecursion {

	// A binary tree node
	private class Node
	{
	    int data;
	    Node left, right;
	  
	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
	  
    Node root;
    
    int maxDepth(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
  
            return 1+Math.max(lDepth, rDepth);
        }
    }
	      
    /* Driver program to test above functions */
    public static void main(String[] args)
    {
    	HeightOfTreeUsingRecursion tree = new HeightOfTreeUsingRecursion();
  
    	//    	                        1
    	//    	                     /     \   
    	//    	                  2            3
    	//    	                /   \             \
    	//    	             4         5            7
    	//    	                         \
    	//    	                           6
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.right.right = tree.new Node(7);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.left.right.right = tree.new Node(6);
  
        System.out.println(tree.maxDepth(tree.root));
    }
	
}
