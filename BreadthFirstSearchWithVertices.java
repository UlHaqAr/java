package Test;

import java.io.*;
import java.util.*;

public class BreadthFirstSearchWithVertices {
	
	    private int numOfVertices;   // No. of vertices
	    private List<Integer>[] listOfConnections; //Adjacency Lists
	 
	    BreadthFirstSearchWithVertices(int v)
	    {
	        numOfVertices = v;
	        listOfConnections = new LinkedList[v];
	        for (int i=0; i<v; ++i)
	            listOfConnections[i] = new LinkedList();
	    }
	 
	    void addEdge(int v,int w)
	    {
	        listOfConnections[v].add(w);
	    }
	 
	    void BFS(int s)
	    {
	        boolean visited[] = new boolean[numOfVertices];
	        LinkedList<Integer> queue = new LinkedList<>();
	 
	        visited[s]=true;
	        queue.add(s);
	 
	        while (!queue.isEmpty())
	        {
	            s = queue.poll();
	            System.err.println(s);
	            Iterator<Integer> i = listOfConnections[s].listIterator();
	            while (i.hasNext())
	            {
	                int n = i.next();
	                if (!visited[n])
	                {
	                    visited[n] = true;
	                    queue.add(n);
	                }
	            }
	        }
	    }
	 
	    public static void main(String args[])
	    {
	    	BreadthFirstSearchWithVertices g = new BreadthFirstSearchWithVertices(4);
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	        g.BFS(2);
	    }
}
