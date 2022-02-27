import java.util.Arrays;
/**
 * Linked Bag Test
 * @author Ian Atkinson
 */
public class LinkedBagTest
{
    /**
     * Linked Bag Main Method
     * @param args
     */
    public static void main(String[] args)
    {
        BagInterface<String> linkedBag1 = new LinkedBag<>();
        linkedBag1.add("a");
        linkedBag1.add("b");
        linkedBag1.add("b");
        linkedBag1.add("c");

        System.out.println("Current bag size: " + linkedBag1.getCurrentSize());
        System.out.println("Is bag currently empty: " + linkedBag1.isEmpty());
        System.out.println("Frequency of 'b': " + linkedBag1.getFrequencyOf("b"));
        System.out.println("Does bag contain 'c': " + linkedBag1.contains("c"));
        System.out.println("Bag in an array form: " + Arrays.toString(linkedBag1.toArray()));
        System.out.println();

        linkedBag1.remove("c");

        System.out.println("After removing an entry:");

        System.out.println("Current bag size: " + linkedBag1.getCurrentSize());
        System.out.println("Is bag currently empty: " + linkedBag1.isEmpty());
        System.out.println("Frequency of 'b': " + linkedBag1.getFrequencyOf("b"));
        System.out.println("Does bag contain 'c': " + linkedBag1.contains("c"));
        System.out.println("Bag in an array form: " + Arrays.toString(linkedBag1.toArray()));
        System.out.println();

    }
}
