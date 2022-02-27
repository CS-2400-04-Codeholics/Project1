/**
 * Bag Interface
 * @author Jonathan Marquez
 */
public interface BagInterface<T> {
      /**
       * This method gets the current size of the bag
       * @return
       */
    public int getCurrentSize();
      /**
       * This method checks if the bag is emptry.
       * True if empty and false if not.
       * @return
       */
    public boolean isEmpty();
      /**
       * This method adds net entries to the current bag.
       * True if successful and false if not.
       * @param newEntry
       * @return
       */
    public boolean add(T newEntry);
      /**
       * This method removes a unspecfic entry from the current bag.
       * @return
       */
    public T remove();
            /**
             * This method removes one occurrence of the given entry from the current bag.
             * True if successful and false if not.
             * @param anEntry
             * @return
             */
            public boolean remove(T anEntry);
      /**
       * This method clears the entire array.
       */
    public void clear();
      /**
       * This method counts the number of times a given entry appers in the bag.
       * @param anEntry
       * @return
       */
    public int getFrequencyOf(T anEntry);
      /**
       * This method checks if the entry is in the current bag.
       * True if it contains the entry and false if not.
       * @param anEntry
       * @return
       */
    public boolean contains(T anEntry);
      /**
       * This method retrieves all entries that are in the bag.
       * Note: If the bag is emptry, it will reutrn empty.
       * @return
       */
    public T[] toArray();
      /**
       * This is new collection of the entries that occur in both bags.
       * This collection returns the entries of Bag and Bag2.
       * Note: They may have multiple copies of the same entry.
       * @param Bag2
       * @return
       */
    public BagInterface <T> union(BagInterface <T> Bag2);
      /**
       * This is new collection of the entries that occur in both bags.
       * This collection returns only the entries that Bag and Bag2 share.
       * @param Bag2
       * @return
       */
    public BagInterface <T> intersection(BagInterface <T> Bag2);
      /**
       * This is new collection of the entries that occur in both bags.
       * This collection returns only the entries that Bag and Bag2 do not share.
       * @param Bag2
       * @return
       */
    public BagInterface <T> difference(BagInterface <T> Bag2);
}