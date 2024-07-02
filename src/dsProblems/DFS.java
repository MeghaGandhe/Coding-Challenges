package dsProblems;

import java.util.Stack;

public class DFS {
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
		
		root.left = new Node<Integer>(3);
		root.right = new Node<Integer>(2);
		root.left.left = new Node<Integer>(4);
		root.left.right = new Node<Integer>(6);
		root.right.left = new Node<Integer>(7);
		root.right.right = new Node<Integer>(5);
		
		DFS dfs = new DFS();
		
		dfs.traverseDFSPreOrder(root);
		System.out.println();
		System.out.println("Recursively");
		dfs.traverseDFSPreOrderRecursively(root);
		System.out.println();
		dfs.traverseDFSPostOrder(root);
		System.out.println();
		System.out.println("Recursively");
		dfs.traverseDFSPostOrderRecursively(root);
		System.out.println();
		dfs.traverseDFSInOrder(root);
		System.out.println();
		System.out.println("Recursively");
		dfs.traverseDFSInOrderRecursively(root);
	}
	
	public void traverseDFSPreOrder(Node<Integer> root) {
		Stack<Node<Integer>> stack = new Stack<>();
		stack.add(root);
		while(!stack.isEmpty()){
			Node<Integer> temp = stack.pop();
			System.out.print(temp.a);
			if(temp.right!=null)
				stack.push(temp.right);
			if(temp.left != null) {
				stack.push(temp.left);
			}
		}
		
	}
	
	public void traverseDFSPostOrder(Node<Integer> root) {
		Stack<Node<Integer>> stack = new Stack<>();
		while(true) {
			while(root!=null) {
				stack.push(root);
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty()) break;
			root = stack.pop();
			if(!stack.isEmpty() && stack.peek() == root)
				root = root.right;
			else {
				System.out.print(root.a);
				root = null;
			}
			
		}
	}
	
	public void traverseDFSInOrder(Node<Integer> root) {
		Stack<Node<Integer>> stack = new Stack<>();
		Node<Integer> current = root;
		stack.push(root);
		while(!stack.isEmpty()) {
			while(current.left!=null) {
				current = current.left;
				stack.push(current);
			}
			current = stack.pop();
			System.out.print(current.a);
			if(current.right!=null) {
				current = current.right;
				stack.push(current);
			}
			
		}
		
	}
	
	public void traverseDFSPreOrderRecursively(Node<Integer> root) {
		if(root!=null) {
			System.out.print(root.a);
			traverseDFSPreOrderRecursively(root.left);
			traverseDFSPreOrderRecursively(root.right);
		}
	}
	
	public void traverseDFSPostOrderRecursively(Node<Integer> root) {
		if(root!=null) {
			traverseDFSPostOrderRecursively(root.left);
			traverseDFSPostOrderRecursively(root.right);
			System.out.print(root.a);
		}
		
	}
	
	public void traverseDFSInOrderRecursively(Node<Integer> root) {
		if(root!=null) {
			traverseDFSInOrderRecursively(root.left);
			System.out.print(root.a);
			traverseDFSInOrderRecursively(root.right);
		}
		
	}

}
