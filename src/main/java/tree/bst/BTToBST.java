package main.java.tree.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.java.tree.TreeNode;

class InorderIndex {
	int index = 0;
}

/**
 * algo first take inorder traversal to an array sort that array again do
 * inorder trvaersal of tree and insert array elemnts
 * 
 * @author rdixi3
 *
 */
public class BTToBST {

	public static void inorderArrayStore(TreeNode<Integer> root, List<Integer> inorder) {
		if (root == null)
			return;
		inorderArrayStore(root.getLeft(), inorder);
		inorder.add(root.getData());
		inorderArrayStore(root.getRight(), inorder);
	}

	public static void arrToBST(TreeNode<Integer> root, Integer[] inorder, InorderIndex inorderIndex) {
		if (root == null)
			return;
		arrToBST(root.getLeft(), inorder, inorderIndex);
		root.setData(inorder[(inorderIndex.index++)]);
		arrToBST(root.getRight(), inorder, inorderIndex);
	}
	
	public static TreeNode<Integer> btToBSTUtil(TreeNode<Integer> root){
		List<Integer> arr = new ArrayList<>();
		InorderIndex in=new InorderIndex();
		inorderArrayStore(root, arr);
		Integer[] arrSor = new Integer[arr.size()];
		Arrays.sort(arr.toArray(arrSor));
		arrToBST(root, arrSor, in);
		return root;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(10);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<Integer>(7));
		root.getLeft().setLeft(new TreeNode<Integer>(8));
		root.getLeft().setRight(new TreeNode<Integer>(4));
		System.out.println(root);
		System.out.println(btToBSTUtil(root));

	}
}
