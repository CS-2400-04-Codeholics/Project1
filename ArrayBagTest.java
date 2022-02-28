import java.util.Arrays;
import java.util.Scanner;
public class ResizeableArrayBagTest
{
public static void main(String[] args)
   {
	Scanner scan = new Scanner(System.in);
	   BagInterface<String> bag1 = new ResizeableArrayBag<>();
	   BagInterface<String> bag2 = new ResizeableArrayBag<>();
	   //This adds the letters A, C, E, G, I to the first array.
	   bag1.add("A");
	   bag1.add("B");
	   bag1.add("C");
	   bag1.add("D");
	   bag1.add("E");
	   bag1.add("F");
	   bag1.add("G");

	   bag2.add("G");
	   bag2.add("F");
	   bag2.add("E");
	   bag2.add("H");
	   bag2.add("I");
	   bag2.add("J");
	   bag2.add("K");
	   
	   String prompt = " ";
	   do {
		   System.out.println("Which one would you like to see?:\np = print bag\na = add to the bag\ne = show if the bag is empty\nf = find word\ns = size of the bag\nr = remove something from the bag\nc = clear bag\nq = move onto next bag");
		   prompt = scan.nextLine(); //This scans the user's incoming input from the previous selection and puts it in a switch case.
		   prompt.toLowerCase(); //This scans the user's input and translates it into a lowercase to enable the switch case.
		   
		   switch(prompt) { //The switch case enters the user's inputs and acts depending on the given input.
		   	case "p": //Case P displays the current array for the first array that the user input.
		   		System.out.println("The current bag is: " + bag1 + "\n");
		   		break;
		   	
		   	case "a": //Case A allows the user to add to the first array and scans the given input.
		   		System.out.println("What would you like to add to the bag");
		   		String add = scan.nextLine();
		   		bag1.add(add);
		   		break;
		   		
		   	case "e": //If the first array is empty, Case E alerts the user with a prompt that says it is empty through an if-else.
			   		//If the first array is not empty, Case E alerts the user with a prompt saying that there is something in it through an if-else.
		   		if(bag1.isEmpty()) 
		   		{
		   			System.out.println("Empty Status: This bag is empty. \n");
		   		}
		   		else
		   		{
		   			System.out.println("Empty Status: The bag at least has something in it.\n");
		   		}
		   		break;
		   		
		   	case "f": //Case F prompts the user what they wish to find.
				   	  
		   		System.out.println("What do you want to find?: ");
		   		String word = scan.nextLine();
		   		if(bag1.contains(word))
		   		{
		   			System.out.println("'" + word + "' is in this bag\n");
		   		}
		   		else
		   		{
		   			System.out.println("'" + word + "' is not in this bag :(\n");
		   		}
		   		break;
		   			
		   	case "s": //Case S scans the size of the first array through bag1.size() and prints it.
		   		System.out.println("The size of this bag is " + bag1.getCurrentSize() + "\n");
		   		break;
		   		 
		   	case "r": //Case R prompts the user what is to be removed in the first array.
		   		System.out.println("What would you like to remove?: ");
		   		String remove = scan.nextLine(); //The user input is scanned.
		   		if(bag1.contains(remove)) //If the user input is inside the first array, it is removed and printed that it was removed.
		   		{
		   			bag1.remove(remove);
		   			System.out.println("'" + remove + "' has been removed\n");
		   		}
		   		else //If the user input is not inside the first array, it printed that it is not in present inside the first array.
		   		{
		   			System.out.println("'" + remove + "' is not in this bag, so I can't remove it :(\n");
		   		}
		   		break;
		   		
		   	case "c": //Case C clears the entirety of the first array; however, the user is prompted before and requests confirmation.
		   		System.out.println("Are you sure you want to clear the bag? You will lose all of your inputs ('y' or 'n'): ");
		   		String clear = scan.nextLine();
		   		clear = clear.toLowerCase();
		   		if(clear.equals("y") || clear.equals("yes")) //Through an if-else, Case C scans the input and acts depending on the user's input.
				   	//If the user inputs y, the first array is cleared and prints a cleared message.
		   		{
		   			bag1.clear();
		   			System.out.println("The bag has now been cleared. \n");
		   		}
		   		else if(clear.equals("n") || clear.equals("no")) //If the user inputs n, the first array remains and prints a "kept" message.
		   		{
		   			System.out.println("bag is kept the same\n");
		   		}
		   		else //Case C recognizes false inputs and displays an error message whilist not making any changes to the first array.
		   		{
		   			System.out.println("You didn't put a valid input, bag has not been cleared.\n"); 
		   		}
		   		break;
		   		
		   	case "q": //Case Q allows the user to jump to the second array through a while loop further on.
		   		System.out.println("Moving on to second bag (bag2).\n");
		   		break;
		   		
		   	default: //The code is able to recognize false inputs and displays an error message.
		   		System.out.println("That's not an option, please try again.\n");
		   		break;
		   }
		
	   } while (!(prompt.equals("q")));
	   System.out.println("Now on the second bag.\n");
	   //The user is given a multitude of options for the second bag.
	   do {
		   System.out.println("Which one would you like to see?:\np = print bag\na = add to the bag\ne = show if the bag is empty\nf = find word\ns = size of the bag\nr = remove something from the bag\nc = clear bag\nq = move onto camparing the bags");
		   prompt = scan.nextLine(); //This scans the user's incoming input from the previous selection and puts it in a switch case.
		   prompt.toLowerCase(); //This scans the user's input and translates it into a lowercase to enable the switch case.
		   
		   switch(prompt) { //The switch case enters the user's inputs and acts depending on the given input.
		   	case "p": //Case P displays the current array for the second array that the user input.
		   		System.out.println("The current bag is: " + bag2 + "\n");
		   		break;
		   		
		   	case "a": //Case A allows the user to add to the first array and scans the given input.
		   		System.out.println("What would you like to add to the bag");
		   		String add = scan.nextLine();
		   		bag2.add(add);
		   		break;
		   		
		   	case "e": //If the second array is empty, Case E alerts the user with a prompt that says it is empty through an if-else.
			   //If the sedcon array is not empty, Case E alerts the user with a prompt saying that there is something in it through an if-else.
		   		if(bag2.isEmpty())
		   		{
		   			System.out.println("Empty Status: This bag is empty \n");
		   		}
		   		else
		   		{
		   			System.out.println("Empty Status: The bag at least has something in it.\n");
		   		}
		   		break;
		   		
		   	case "f": //Case F prompts the user what they wish to find.
			   
		   		System.out.println("What do you want to find?: ");
		   		String word = scan.nextLine();
		   		if(bag2.contains(word))
		   		{
		   			System.out.println("'" + word + "' is in this array\n");
		   		}
		   		else
		   		{
		   			System.out.println("'" + word + "' is not in this array :(\n");
		   		}
		   		break;
		   			
		   	case "s": //Case S scans the size of the second array through bag2.size() and prints it.
		   		System.out.println("The size of this array is " + bag2.getCurrentSize() + "\n");
		   		break;
		   		 
		   	case "r": //Case R prompts the user what is to be removed in the second array.
		   		System.out.println("What would you like to remove?: ");
		   		String remove = scan.nextLine(); //The user input is scanned.
		   		if(bag2.contains(remove)) //If the user input is inside the second array, it is removed and printed that it was removed.
		   		{
		   			bag2.remove(remove);
		   			System.out.println("'" + remove + "' has been removed\n");
		   		}
		   		else //If the user input is not inside the second array, it printed that it is not in present inside the second array.
		   		{
		   			System.out.println("'" + remove + "' is not in this array, so I can't remove it :(\n");
		   		}
		   		break;
		   		
		   	case "c": //Case C clears the entirety of the second array; however, the user is prompted before and requests confirmation.
		   		System.out.println("Are you sure you want to clear the array? You will lose all of your beloved inputs (press 'y' or 'n'): ");
		   		String clear = scan.nextLine();
		   		clear = clear.toLowerCase();
		   		if(clear.equals("y") || clear.equals("yes")) //Through an if-else, Case C scans the input and acts depending on the user's input.
				   //If the user inputs y, the second array is cleared and prints a cleared message.
		   		{
		   			bag2.clear();
		   			System.out.println("The bag is gone now \n");
		   		}
		   		else if(clear.equals("n") || clear.equals("no")) //If the user inputs n, the second array remains and prints a "kept" message.
		   		{
		   			System.out.println("bag is kept the same\n");
		   		}
		   		else //Case C recognizes false inputs and displays an error message whilst not making any changes to the second array.
		   		{
		   			System.out.println("You didn't put a valid input, array has not been cleared.\n");
		   		}
		   		break;
		   		
		   	case "q": //Case Q allows the user to compare the first and second array through a while loop further on.
		   		System.out.println("Moving on to comparing\n");
		   		break;
		   		
		   	default: //The code is able to recognize false inputs and displays an error message.
		   		System.out.println("That's not an option, please try again.\n");
		   		break;
		   }
		}while (!(prompt.equals("q")));

System.out.println("Now comparing both bag1 and bag2 with union, intersection, and difference\n");
System.out.println("This is the Union between the bags: " +Arrays.toString(bag1.union(bag2).toArray()));
System.out.println("This is the intersection between the bags: " +Arrays.toString(bag1.intersection(bag2).toArray()));
System.out.println("This is the difference between the bags: " +Arrays.toString(bag1.difference(bag2).toArray()));
//prints out the union intersection and methd
		 } //end main
} //end ResizeableArrayBagTest
