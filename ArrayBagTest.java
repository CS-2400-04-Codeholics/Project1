import java.util.Arrays;
public interface BagInterface < T >
{
public BagInterface < T > union(BagInterface < T > Bag2);
/* a new collection of the entries that occur in both collections
Bag2 will have its contents compared to this bag
returns a new bag containing the entries of this bag and Bag2 they might have multiple copies of same entry
*/
 public BagInterface < T > intersection(BagInterface < T > Bag2);
// new collection of the entries that would be left in one collection after removing the copies of other entries
//Bag2 that will have its contents compared to this bag
public BagInterface < T > difference(BagInterface < T > Bag2);
//this removes the entries that are in both the first bag and in Bag2
   
    }
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
