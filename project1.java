import java.util.Scanner;

public class project1 {
	public static void main(String[] args) {
		// get the binaryTree class
		binaryTree tree = new binaryTree();
		Scanner keyboard = new Scanner(System.in);
		// userInput is to get user's input set to ' ' to initialize it
		char userInput = ' ';

		// gets the line of integers and then converts it into a integer
		System.out.println("Please enter values:");
		String str = keyboard.nextLine();
		// puts it into an array using the " " splitter
		String[] token = str.split(" ");
		//use the enhance for loop to add the nodes to the tree
		for(String s : token) {
			tree.addNode(Integer.parseInt(s));
		}

		// prints the pre, in, and post order
		tree.getPreOrder();
		tree.getInorder();
		tree.getPostOrder();

		//While the input isn't 'E' or 'e' present the user with a menu
		do {
			System.out.println("Main Menu");
			System.out.println("A: Add a Value");
			System.out.println("R: Remove a Value");
			System.out.println("E: Exit the program");
			System.out.print("What command would like to run? ");
			userInput = keyboard.next().charAt(0);
			// If the use puts 'e' or 'E' then quit the program
			if(userInput == 'e' || userInput == 'E') {
				System.out.println("Exit!");
				break;
			}
			//The switches help with the user's choices
			switch(userInput){
			// lets 'a' be a valid choice
			case 'a': case 'A':
				System.out.print("Please enter a value to add: ");
				tree.addNode(keyboard.nextInt());
				tree.getInorder();
				System.out.println();
				break;
			// lets 'r' be a valid choice
			case 'r': case 'R':
				System.out.print("Please enter a value to remove: ");
				tree.removeNode(keyboard.nextInt());
				tree.getInorder();
				System.out.println();
				break;
			// lets 'e' be a void choice
			case 'e': case 'E':
				System.out.println("Exit!");
				break;
			// the default makes sure that what you put is a valid choice
			default:
				System.out.println("Please enter a valid choice");

			}

		}
		while (userInput != 'E' || userInput != 'e');


	}
}
