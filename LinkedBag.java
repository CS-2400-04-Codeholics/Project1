/**
 * Linked Bag
 */
public class LinkedBag<T> implements BagInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;
    
    /**
     * Creates that linked Bag with one node entry.
     */
    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    }
    
    @Override
    /**
     * This returns the number of entries in the current bag.
     * @return Number of entries in the bag.
     */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    @Override
    /**
     * This checks if the bag is empty.
     * @return True if empty and False if not.
     */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    @Override
    /**
     * This adds a new entry into the bag.
     * @param newEntry New Entry of the bag.
     * @return True if successful, False if not.
     */
    public boolean add(T newEntry)
    {
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    @Override
    /**
     * This removes an unspecified entry from the bag.
     * @return Either removed entry or null.
     */
    public T remove()
    {
        T result = null;
        if (firstNode != null)
        {
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }

        return result;
    }

    // It retrieves the data of the given entry in the bag.
    private Node getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.getNextNode();
            }
        }

        return  currentNode;
    }

    @Override
    /**
     * This method removes an occurrence of the given entry from the bag.
     * @param anEntry The entry being removed.
     * @return True if entry was removed, or False if not.
     */
    public boolean remove(T anEntry)
    {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);

        if (nodeN != null)
        {
            nodeN.setData(firstNode.getData());
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
            result = true;
        }

        return result;
    }

    @Override
    public void clear()
    {
        while (!isEmpty())
        {
            remove();
        }
    }

    @Override
    /**
     * This method gets the number of times the given entry occurred in the bag.
     * @param anEntry The entry being counted.
     * @return It returns the number of times the entry has occurred.
     */
    public int getFrequencyOf(T anEntry)
    {
        int frequency = 0;
        int counter = 0;

        Node currentNode = firstNode;

        while ((counter < numberOfEntries) && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                frequency++;
            }

            counter++;
            currentNode = currentNode.getNextNode();
        }

        return frequency;
    }

    @Override
    /**
     * This method checks if the bag contains a given entry or not.
     * @param anEntry This is the entry being checked.
     * @return True if entry was found, or False if not.
     */
    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.getNextNode();
            }
        }

        return  found;
    }

    @Override
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;

        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }

        return result;
    }

    @Override
    /**
     * This unifies bag1 and bag2
     * @return This returns a bag with all the data of bag1 and bag2.
     */
    public BagInterface<T> union(BagInterface<T> Bag2)
    {
        int unionEntries = this.numberOfEntries + Bag2.getCurrentSize();

        BagInterface<T> union = new ResizeableArrayBag<>(unionEntries);

        T[] bag1 = this.toArray();
        T[] bag2 = Bag2.toArray();

        for (T elem : bag1)
        {
            union.add(elem);
        }

        for (T elem : bag2)
        {
            union.add(elem);
        }

        return union;
    }

    @Override
    /**
     * Checks if bag1 and bag2 shares any data.
     * @return This returns a bag that only contains the shared data of bag1 and bag2.
     */
    public BagInterface<T> intersection(BagInterface<T> Bag2)
    {
        BagInterface<T> result = new ResizeableArrayBag<>();
        BagInterface<T> intersection = new ResizeableArrayBag<>();

        T[] bag1 = this.toArray();
        T[] bag2 = Bag2.toArray();

        for (T elem : bag1)
        {
            result.add(elem);
        }

        for (T elem : bag2)
        {
            if (result.contains(elem))
            {
                intersection.add(elem);
            }

            if (result.getFrequencyOf(elem) < intersection.getFrequencyOf(elem))
            {
                intersection.remove(elem);
            }
        }

        return intersection;
    }

    @Override
    /**
     * Checks if bag1 and bag2 contain difference date from each other.
     * @return This returns a bag that only contains the data that bag1 and bag2 had differently.
     */
    public BagInterface<T> difference(BagInterface<T> Bag2)
    {
        BagInterface<T> difference = new ResizeableArrayBag<>();

        T[] bag1 = this.toArray();
        T[] bag2 = Bag2.toArray();

        for (T elem : bag1)
        {
            difference.add(elem);
        }

        for (T elem : bag2)
        {
            if (difference.contains(elem))
            {
                difference.remove(elem);
            }
        }

        return difference;
    }

    private class Node
    {
        private T data;
        private Node next;

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }

        private T getData()
        {
            return data;
        }

        private void setData(T newData)
        {
            data = newData;
        }

        private Node getNextNode()
        {
            return next;
        }

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        }

    }
}