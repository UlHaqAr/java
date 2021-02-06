package Test;

import java.util.*;

public class BreadthFirstSearchWithNode {
  
	public static class Node
	  {
	    String name;
	    List<Node> connections = new ArrayList<Node>();
	    
	    public Node(String name)
	    {
	      this.name = name;
	    }
	    
	    public void addConnection(Node name)
	    {
	      this.connections.add(name);
	    }
	    
	    public boolean equals(Node x)
	    {
	      return this.name.equalsIgnoreCase(x.name);
	    }
	  }
	
  public static void main(String[] args) {
    
	BreadthFirstSearchWithNode.Node A = new BreadthFirstSearchWithNode.Node("A");
	BreadthFirstSearchWithNode.Node B = new BreadthFirstSearchWithNode.Node("B");
    BreadthFirstSearchWithNode.Node C = new BreadthFirstSearchWithNode.Node("C");
    BreadthFirstSearchWithNode.Node D = new BreadthFirstSearchWithNode.Node("D");
    BreadthFirstSearchWithNode.Node E = new BreadthFirstSearchWithNode.Node("E");
    
    A.addConnection(B);
    A.addConnection(C);
    
    B.addConnection(D);
    C.addConnection(D);
    
    B.addConnection(B);
    
    B.addConnection(E);
    
    System.out.println(findPath(A,D));
  }
  
  static int findPath(Node root, Node dest)
  {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    int count =0;
    Set<Node> visited = new HashSet<>();
    
    while(!q.isEmpty())
    {
      Node n = q.poll();
      
      if(n.equals(dest)) count++;
      
      if(!visited.contains(n) && n.connections != null)
      {
           for(Node x: n.connections)
          {
            q.add(x); 
          }
      }
      visited.add(n);
    }
    
    return count;
  }
  
}