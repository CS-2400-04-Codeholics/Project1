import java.util.Arrays;
/**
 * Resizeable Array Bag Test
 * @author Jonathan Marquez
 */
public class ArrayBagTest
{
	/**
	 * Array Bag Main Method
	 * @param args
	 */
public static void main(String[] args)
   {
	
	   BagInterface<String> bag1 = new ResizeableArrayBag<>();
	   BagInterface<String> bag2 = new ResizeableArrayBag<>();
	   
	   //This adds the letters A,B,C,D,E,F,G to bag1
	   bag1.add("A");
	   bag1.add("B");
	   bag1.add("C");
	   bag1.add("D");
	   bag1.add("E");
	   bag1.add("F");
	   bag1.add("G");
//adds letters G,F,E,H,I,J,K to bag2
	   bag2.add("G");
	   bag2.add("F");
	   bag2.add("E");
	   bag2.add("H");
	   bag2.add("I");
	   bag2.add("J");
	   bag2.add("K");
	   
	  
	   System.out.println("Now comparing both bag1 and bag2 with union, intersection, and difference\n");
	   System.out.println("This is the Union between the bags: " +Arrays.toString(bag1.union(bag2).toArray()));
System.out.println("This is the intersection between the bags: " +Arrays.toString(bag1.intersection(bag2).toArray()));
System.out.println("This is the difference between the bags: " +Arrays.toString(bag1.difference(bag2).toArray()));
//prints out the union, intersection, and difference method
   } //end main
} //end ResizeableArrayBagTest
