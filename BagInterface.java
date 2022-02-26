

public interface BagInterface<T> {
    public int getCurrentSize();
    /* Sees whether this bag is empty.
          True if the bag is empty, or false if not. */
    public boolean isEmpty();
    /* Adds a new entry to this bag.
          The object to be added as a new entry.
         True if the addition is successful, or false if not. */
    public boolean add(T newEntry);
    /* Removes one unspecified entry from this bag, if possible.
                     Either the removed entry, if the removal was successful, or null. */
    public T remove();
    /* Removes one occurrence of a given entry from this bag, if possible.
                 The entry to be removed.
                  True if the removal was successful, or false if not. */
            public boolean remove(T anEntry);
    /** Removes all entries from this bag. */
    public void clear();
    /* Counts the number of times a given entry appears in this bag.
          The entry to be counted.
          The number of times anEntry appears in the bag. */
    public int getFrequencyOf(T anEntry);
    /* Tests whether this bag contains a given entry.
          The entry to find.
         True if the bag contains anEntry, or false if not. */
    public boolean contains(T anEntry);
    /* Retrieves all entries that are in this bag.
          A newly allocated array of all the entries in the bag. Note: If the bag is empty, the returned array is empty. */
    public T[] toArray();
    
    public BagInterface <T> union(BagInterface <T> Bag2);
    /* a new collection of the entries that occur in both collections
    Bag2 will have its contents compared to this bag
    returns a new bag containing the entries of this bag and Bag2 they might have multiple copies of same entry
    */
    public BagInterface <T> intersection(BagInterface <T> Bag2);
    // new collection of the entries that would be left in one collection after removing the copies of other entries
    //Bag2 that will have its contents compared to this bag
    public BagInterface <T> difference(BagInterface <T> Bag2);
    //this removes the entries that are in both the first bag and in Bag2
}
