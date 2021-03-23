

import java.util.ArrayList;

public class BinarySearchTree <T extends Comparable<T>> {
   
    private class Node {
        private T data;
        private Node leftChild;
        private Node rightChild;

        public Node(T data) {
            this.data = data;
            leftChild = rightChild = null; 
        }
    }
    private Node root;
    public BinarySearchTree() {
        root = null;
    }

    public void addElement(T data) {
        if(root == null) {
            root = new Node(data);
        }
        else {
            add(root, data);
        }
    }

    private Node add(Node node, T data) {
        if(node == null)
            node = new Node(data);
        else if(data.compareTo(node.data) < 0)
            node.leftChild = add(node.leftChild, data);
        else if(data.compareTo(node.data) > 0)
            node.rightChild = add(node.rightChild, data);
        return node;
    }

    public void removeElement(T data) {
        root = remove(root, data);
    }

    public Node remove(Node node, T data) {
        if(node == null){
			return null;	//value wasn't found
        }
		if(data.compareTo(node.data) < 0)
			node.leftChild = remove(node.leftChild, data);	//go left
		else if(data.compareTo(node.data) > 0)
			node.rightChild = remove(node.rightChild, data);	//go right
		else
		{
			if(node.rightChild == null)
				return node.leftChild;
			if(node.leftChild == null)
				return node.rightChild;
			Node temp = findMin(node.rightChild);
			node.data = temp.data;
			node.rightChild = remove(node.rightChild, temp.data);	//removes duplicate info
		}
		return node;
    }

    public Node findMin (Node node) {
        if(node == null) return null;
        if(node.leftChild == null) return node;
        else return findMin(node.leftChild);
    }

    public boolean search(T data)
	{
		return recursiveSearch(root, data);
	}
	private boolean recursiveSearch(Node node, T data)
	{
		if(node == null)	//if the node is a leaf
			return false;
		if(node.data.compareTo(data) == 0)
			return true;
		else if(data.compareTo(node.data) < 0)
			return recursiveSearch(node.leftChild, data);
		else 
			return recursiveSearch(node.rightChild, data);
	}
    public void printInOrder()
	{
		printInOrder(root); 
	}
	private void printInOrder(Node aNode)
	{
		if(aNode == null)
		{
			return; 
		}
		printInOrder(aNode.leftChild); 
		System.out.println(aNode.data);
		printInOrder(aNode.rightChild); 
	}

    public ArrayList<T> getarraylist() {
        ArrayList<T> ret = new ArrayList<T>();
        return ret;  //  TODO add functionality
    }

}