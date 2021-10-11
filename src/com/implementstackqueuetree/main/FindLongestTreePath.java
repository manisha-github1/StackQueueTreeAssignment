package com.implementstackqueuetree.main;

import java.util.ArrayList;

import com.implementstackqueuetree.main.FindLongestTreePath.Node;

public class FindLongestTreePath {
	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	private static ArrayList getLongestPath(Node root) {
		// Write the base case of the recursion (if leaf node, create a list with just
		// the data of that node and return the list
		if (root == null) {
			return new ArrayList();
		}

		ArrayList L = getLongestPath(root.left);
		ArrayList R = getLongestPath(root.right);

		// compare the size of L, R, and add the root data to the longer list and return
		// the list
		if (L.size() > R.size()) {

			L.add(root.data);
			return L;

		} else {
			R.add(root.data);
			return R;
		}

	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Node root = new Node(100);
		root.left = new Node(20);
		root.right = new Node(130);
		root.left.left = new Node(10);
		root.left.right = new Node(50);
		root.right.left = new Node(110);
		root.right.right = new Node(140);
		root.left.left.left = new Node(5);

		ArrayList longestPath = getLongestPath(root);
		
		System.out.println("Longest path node count: " + longestPath.size());
		System.out.println(" " );
        
		for (int i = longestPath.size() - 1; i >= 0; i--) {
		if ( i == 0 ) {
            sb.append(longestPath.get(i));
		}
		else {
			sb.append(longestPath.get(i) + " --> ") ;
		}
		}
		
		System.out.print("Longest Path element starting from root element: " + sb);
	}
}
