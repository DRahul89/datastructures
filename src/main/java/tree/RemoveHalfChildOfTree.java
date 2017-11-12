package main.java.tree;

public class RemoveHalfChildOfTree {

	public static TreeNode<Integer> removeHalfChild(final TreeNode<Integer> root) {
		if(null== root)
			return null;
		root.setLeft(removeHalfChild(root.getLeft()));
		root.setRight(removeHalfChild(root.getRight()));
		
		if(root.getLeft()==null && root.getRight()==null){
			return root;
		}
		
		if(root.getLeft()==null && root.getRight()!=null){
			return root.getRight();
		}
		if(root.getLeft()!=null && root.getRight()==null){
			return root.getLeft();
		}
		return root;
	}

}
