import java.util.Arrays;

public class ArrayBagTest {  
      public static void main(String[] args) {
    BagInterface <T> Bag1= new ResizeableArrayBag<>();  
    BagInterface <T> Bag2 = new ResizeableArrayBag<>(); 
Bag1.add("A");
Bag1.add("B");
Bag1.add("C");
Bag2.add("D");
Bag2.add("E");
Bag2.add("F");
Bag2.add("B");
Bag2.add("C");
//adding entries/objects to each bag 

System.out.println("This is the Union between the bags: " +Arrays.toString(Bag1.union(Bag2).toArray()));
System.out.println("This is the intersection between the bags: " +Arrays.toString(Bag1.intersection(Bag2).toArray()));
System.out.println("This is the difference between the bags: " +Arrays.toString(Bag1.difference(Bag2).toArray()));
//prints out the union intersection and methd
    
    }

}
