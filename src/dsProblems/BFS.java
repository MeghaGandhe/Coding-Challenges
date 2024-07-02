package dsProblems;

import java.util.LinkedList;
import java.util.Queue;
/**
 * BFS with linkedlist implementation
 * @author megha
 *
 */

public class BFS {
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
		
		root.left = new Node<Integer>(3);
		root.right = new Node<Integer>(2);
		root.left.left = new Node<Integer>(4);
		root.left.right = new Node<Integer>(6);
		root.right.left = new Node<Integer>(7);
		root.right.right = new Node<Integer>(5);
		
		BFS bfs = new BFS();
		
		bfs.traverseBFSIteratively(root);
		System.out.println();
		bfs.traverseBFSRecurssively(root);
		
	}
	
	public void traverseBFSIteratively(Node<Integer> root) {
		Queue<Node<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node<Integer> temp = queue.poll();
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
			System.out.print(temp.a);
		}
	}
	
	public void traverseBFSRecurssively(Node<Integer> root) {
		Queue<Node<Integer>> queue = new LinkedList<>();
		queue.add(root);
		printRecursively(queue);
	}
	
	public void printRecursively(Queue<Node<Integer>> queue) {
		Node<Integer> temp = queue.poll();
		if(temp!=null){
			System.out.print(temp.a);
			queue.add(temp.left);
			queue.add(temp.right);
			printRecursively(queue);
		}
	}

}
