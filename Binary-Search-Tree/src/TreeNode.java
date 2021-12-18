/**
 * Represents a generic node within a binary tree architecture.
 * @author Bill Lee
 */
public class TreeNode<T> {
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;

	/**
	 * Constructs a node with the given data and no children.
	 * @param data the data to be contained in this node
	 */
	public TreeNode(T data) {
		this.data = data;
	}

	/**
	 * Constructs a node with the given data and children.
	 * @param data the data to be contained in this node.
	 * @param left the left child of this node, may be null
	 * @param right the right child of this node, may be null
	 */
	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public T getData() {
		return data;
	}

	public void setLeft(TreeNode<T> left) {
		try {
			this.left = left;
		} catch (NullPointerException e) {
		}
	}

	public void setRight(TreeNode<T> right) {
		try {
			this.right = right;
		} catch (NullPointerException e) {
		}
	}

	@Override
	public String toString() {
		return data.toString();
	}
}