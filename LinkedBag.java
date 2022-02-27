public class LinkedBag<T> implements BagInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry)
    {
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    @Override
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