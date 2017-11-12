package main.java.tree;

public class TreeProperties {

	private static int level_Glob = -1;


	public static int size(TreeNode<Integer> node) {
		if (node == null)
			return 0;
		else
			return size(node.getLeft()) + 1 + size(node.getRight());
	}

	public static int height(TreeNode<Integer> node) {
		if (node == null)
			return 0;
		else
			return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
	}

	public static void mirror(TreeNode<Integer> node) {
		if (node == null)
			return;
		mirror(node.getLeft());
		mirror(node.getRight());
		TreeNode<Integer> temp = node.getLeft();
		node.setLeft(node.getRight());
		node.setRight(temp);
	}

	public static boolean isCousin(TreeNode<Integer> root, int first, int second, int level,TreeNode<Integer> PARENT) {
		if (root == null)
			return false;
		if (root.getData() == first) {
			if (level_Glob != -1 && level_Glob == level) {
				 if(PARENT.getLeft()!=null && PARENT.getLeft().getData()==second){
					 return false;
				 }
				 if(PARENT.getRight()!=null && PARENT.getRight().getData()==second){
					 return false;
				 }
				 return true;
			} else {
				level_Glob = level;

			}
		}
		if (root.getData() == second) {
			if (level_Glob != -1 && level_Glob == level) {
				if(PARENT.getLeft()!=null && PARENT.getLeft().getData()==first){
					 return false;
				 }
				 if(PARENT.getRight()!=null && PARENT.getRight().getData()==first){
					 return false;
				 }
				 return true;
			} else {
				level_Glob = level;

			}
		}
		PARENT = root;
		return isCousin(root.getLeft(), first, second, level + 1,PARENT)
				|| isCousin(root.getRight(), first, second, level + 1,PARENT);
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<Integer>(3));
		root.getLeft().setLeft(new TreeNode<Integer>(4));
		root.getLeft().setRight(new TreeNode<Integer>(5));
		root.getRight().setLeft(new TreeNode<Integer>(6));
		root.getRight().setRight(new TreeNode<Integer>(7));
		BinaryTree<Integer> tree = new BinaryTree<Integer>(root);

		System.out.println(tree);

		System.out.println("height =" + height(tree.getRoot()));
		System.out.println("size =" + size(tree.getRoot()));
		
		System.out.println(isCousin(root, 4, 6, 1,new TreeNode<Integer>(null)));
	}

}
