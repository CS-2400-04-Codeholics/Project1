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
    
    
    }

}
