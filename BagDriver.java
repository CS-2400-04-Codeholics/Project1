import java.util.Arrays;
/**
 * Bag Driver Test
 * @author Ian Atkinson
 */
public class BagDriver
{
    /**
     * Bag Driver Main Method
     * @param args
     */
    public static void main(String[] args)
    {
        BagInterface<String> arrayBag1 = new ResizeableArrayBag<>();
        arrayBag1.add("A");
        arrayBag1.add("B");
        arrayBag1.add("C");
        arrayBag1.add("D");
        arrayBag1.add("E");
        arrayBag1.add("F");
        arrayBag1.add("G");

        BagInterface<String> arrayBag2 = new ResizeableArrayBag<>();
        arrayBag2.add("G");
        arrayBag2.add("F");
        arrayBag2.add("E");
        arrayBag2.add("H");
        arrayBag2.add("I");
        arrayBag2.add("J");
        arrayBag2.add("K");

        BagInterface<String> linkedBag1 = new LinkedBag<>();
        linkedBag1.add("A");
        linkedBag1.add("B");
        linkedBag1.add("B");
        linkedBag1.add("C");
        linkedBag1.add("H");
        linkedBag1.add("J");
        linkedBag1.add("K");

        BagInterface<String> linkedBag2 = new LinkedBag<>();
        linkedBag2.add("B");
        linkedBag2.add("B");
        linkedBag2.add("B");
        linkedBag2.add("D");
        linkedBag2.add("E");
        linkedBag2.add("F");
        linkedBag2.add("I");

        System.out.println("Union between two array bags: " + Arrays.toString(arrayBag1.union(arrayBag2).toArray()));
        System.out.println("Union between two linked bags: " + Arrays.toString(linkedBag1.union(linkedBag2).toArray()));
        System.out.println("Union between an array bag and a linked bag: " + Arrays.toString(arrayBag1.union(linkedBag2).toArray()));
        System.out.println();

        System.out.println("Intersection between two array bags: " + Arrays.toString(arrayBag1.intersection(arrayBag2).toArray()));
        System.out.println("Intersection between two linked bags: " + Arrays.toString(linkedBag1.intersection(linkedBag2).toArray()));
        System.out.println("Intersection between an array bag and a linked bag: " + Arrays.toString(linkedBag1.intersection(arrayBag2).toArray()));
        System.out.println();

        System.out.println("Difference between two array bags: " + Arrays.toString(arrayBag1.difference(arrayBag2).toArray()));
        System.out.println("Difference between two linked bags: " + Arrays.toString(linkedBag1.difference(linkedBag2).toArray()));
        System.out.println("Difference between an array bag and a linked bag: " + Arrays.toString(arrayBag1.difference(linkedBag2).toArray()));
        System.out.println();
    }
}
