
public class binaryTree {
	Node root;

	// This constructor sets the tree to null so there's nothing in it
	public binaryTree() {
		root = null;
	}

	//This method adds values
	public void addNode(int value) {
		// Goes into another method where it sets the "root" with it's value
		root = addNode(root,value);
	}

	//This method adds a value in the tree using the nodes
	public Node addNode(Node node, int value) {
		//If the tree is empty then this value is the root
		if(node == null) {
			node = new Node(value);
		}
		/*Else if the value is less than the current root
		 *then it goes to the left root and then
		 *it goes through the method again recursively
		 */
		else {
			if (value < node.getValue())
				node.left = addNode(node.left,value);
			/*
			 * If the value is greater than the current node's value
			 * then it goes to the right root and then it goes through
			 * the method again recursively
			 */
			if (value > node.getValue())
				node.right = addNode(node.right,value);
			/*
			 * If the value is equal to a value already in the tree
			 * then it prints out that the value is already in it
			 */
			if (value == node.getValue())
				System.out.println(value + " Already exits! Duplicated values are not allowed");
		}
		return node;
	}

	//This method calls upon the removeNode method
	public void removeNode(int value) {
		root = removeNode(root, value);
	}
	//This method uses the root to help find the value i.e points to current Root
	public Node removeNode(Node root, int value){
		//If root is equal to null then there's nothing in the tree
		if (root == null) {
			System.out.println("That does not exist!");
			return root;
		}
		//If the value is less than current's root value goes to the left
		if(value < root.value)
			root.left = removeNode(root.left, value);
		//If the value is greater than the current's root value goes to the right
		else if (value > root.value)
			root.right = removeNode(root.right, value);

		// If the root value is equal to the value then goes into this
		else {
			//nodes with one child or no child
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;

			//Node with two children
			/*
			*
			*	The method below deletes the left most node on the
			* 	right subtree!!!
			* 	It does so by finding the value of the left most right node
			*/
			root.value = minValue(root.right);
			//Deletes the successor
			root.right = removeNode(root.right, root.value);
		}
		return root;
	}

	// gets the min value
	public int minValue(Node root){
		int minValue = root.value;
		while(root.left != null) {
			minValue = root.left.value;
			root = root.left;
		}
		return minValue;
	}
	// This method gets the inorder and prints it out
	public void getInorder() {
		System.out.print("In-order: ");
		getInorder(root);
		System.out.println();
	}
	//This method is the method that actually gets the values of the nodes
	private void getInorder(Node root) {
		// Checks if it is null or not
		if(root != null) {
			// recursively go through the tree
			// With printing in the middle ie inorder
			getInorder(root.getLeftNode());
			System.out.print(root.getValue() + " ");
			getInorder(root.getRightNode());

		}
	}
	//This method is the method that prints out the Post Order and goes into another method
	public void getPostOrder() {
		System.out.print("Post-Order: ");
		getPostOrder(root);
		System.out.println();
	}
	//This method is the one that actually gets the values of the tree in
	//Post order
	private void getPostOrder(Node root) {
		//Checks if it isn't null
		if (root != null) {
			//Recursively go through the tree with it printing in the end
			// thus post order
			getPostOrder(root.getLeftNode());
			getPostOrder(root.getRightNode());
			System.out.print(root.getValue() + " ");
		}
	}

	//This method prints out the pre order
	public void getPreOrder() {
		System.out.print("Pre-Order: ");
		getPreOrder(root);
		System.out.println();
	}
	//Again this is the one that actually prints out the nodes in preorder
	private void getPreOrder(Node root) {
		//Checks if it is null if it is null then it's done in that one recursion
		//root.getValue is first this time because it's pre order
		if (root != null) {
			System.out.print(root.getValue() + " ");
			getPreOrder(root.getLeftNode());
			getPreOrder(root.getRightNode());
		}
	}


}
/*
 * This class allows the binary tree to traverse itself
 * with left,right and setting the value
 */
class Node{
	Node left;
	Node right;
	int value;
/*
 * The default constructor that sets left,right,and value to null
 * or zero
 */
	public Node() {
		left = null;
		right = null;
		value = 0;
	}

//This constructor sets the value

	public Node(int value) {
		this.value = value;
	}
//This method sets the value of value
	public void setValue(int value) {
		this.value = value;
	}
//This getter returns the value
	public int getValue() {
		return value;
	}
//This setter method sets the left node
	public void setLeftNode(Node node) {
		left = node;
	}
//This setter method sets the right node
	public void setRightNode(Node node) {
		right = node;
	}
//This getter method returns the left node
	public Node getLeftNode() {
		return left;
	}
//This getter method returns the right node
	public Node getRightNode(){
		return right;
	}

}



