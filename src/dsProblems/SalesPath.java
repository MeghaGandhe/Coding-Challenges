package dsProblems;

import java.util.*;

class SalesPath {
 
  static class Node {
      
    int cost;
    Node[] children;
    Node parent;

    Node(int cost) {
      this.cost = cost;
      children = null;
      parent = null;
    }
  }
        
    int getCheapestCost(Node rootNode) {
      // your code goes here
      if(rootNode == null)
        return 0;
      if(rootNode.children == null)
        return rootNode.cost;
      /**PriorityQueue<Node> queue = new PriorityQueue<>((a,b) ->
        a.cost - b.cost
      );*/
      Queue<Node> queue = new LinkedList<>();
      queue.add(rootNode);
      int min = Integer.MAX_VALUE;
      while(!queue.isEmpty()){
        Node current = queue.poll();
        if(current.children == null) {
        	min = Math.min(min, current.cost);
        }else {
	        Node[] children = current.children;
	        for(int i =0;i<children.length;i++){
	          children[i].cost = children[i].cost + current.cost;
	          queue.add(children[i]);
	        }
        }
      }
      return min;    
    }
    
  /*********************************************
   * Driver program to test above method     *
   *********************************************/

  public static void main(String[] args) {

    Node rootNode = new Node(0);
    rootNode.children = new Node[3];
    rootNode.children[0] = new Node(5);
    rootNode.children[1] = new Node(3);
    rootNode.children[2] = new Node(6);
    rootNode.children[0].children = new Node[1];
    rootNode.children[0].children[0] = new Node(4);
    rootNode.children[1].children = new Node[2];
    rootNode.children[1].children[0] = new Node(2);
    rootNode.children[1].children[1] = new Node(0);
    rootNode.children[2].children = new Node[2];
    rootNode.children[2].children[0] = new Node(1);
    rootNode.children[2].children[1] = new Node(5);
    rootNode.children[1].children[0].children = new Node[1];
    rootNode.children[1].children[0].children[0] = new Node(1);
    rootNode.children[1].children[1].children = new Node[1];
    rootNode.children[1].children[1].children[0] = new Node(10);
    rootNode.children[1].children[0].children[0].children = new Node[1];
    rootNode.children[1].children[0].children[0].children[0] = new Node(1);

    System.out.println("cheapest Path = " + new SalesPath().getCheapestCost(rootNode));


  }
}
