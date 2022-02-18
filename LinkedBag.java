import java.util.Arrays;
public class LinkedBag<T> implements BagInterface<T>
{
    private Node FirstNode;
    private int numberOfEntries;
    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    }
    public BagInterface<T> union(BagInterface<T> Bag2);
    public BagInterface<T> intersection(BagInterface<T> Bag2);
    public BagInterface<T> difference(BagInterface<T> Bag2);
    private class Node
    {
        private T data;
        private Node next;
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }
        private Node(T dataPortion,Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }
    }
}
