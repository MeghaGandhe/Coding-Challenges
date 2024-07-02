package dsProblems;

public class Node<T> {
	T a;
	Node<T> left;
	Node<T> right;
	
	public Node(){
		left = null;
		right = null;
	}
	public Node(T a) {
		this.a = a;
		left = null;
		right = null;
	}

}
