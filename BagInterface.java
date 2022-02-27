public interface BagInterface<T>
{
      /**
       * This method gets the size of the current array.
       * @return
       */
      public int getCurrentSize();
      /**
       * This method checks if the array is empty or not.
       * @return
       */
      public boolean isEmpty();
      /**
       * This method adds a new entry to the array.
       * @param newEntry
       * @return
       */
      public boolean add(T newEntry);
      /**
       * This method remove a entry from the current array.
       * @return
       */
      public T remove();
            /**
             * This checks if the remove entry was successful or not.
             * @param anEntry
             * @return
             */
            public boolean remove(T anEntry);
      /**
       * This method clears the entire array.
       */
      public void clear();
      /**
       * This method counts the number of times a entry appears in a bag.
       * @param anEntry
       * @return
       */
      public int getFrequencyOf(T anEntry);
      /**
       * This method checks if the bag conatins the given entry.
       * @param anEntry
       * @return
       */
      public boolean contains(T anEntry);
      /**
       * This method retrieves all entries of the bag.
       * @return
       */
      public T[] toArray();
      /**
       * This collects and compares both collections.
       * This returns a bag that contains the entries of bag 1 and bag 2
       * @param Bag2
       * @return
       */
      public BagInterface <T> union(BagInterface <T> Bag2);
      /**
       * This collects and compares both collections.
       * This returns a bag that contains only the entries that bag 1 and bag 2 share.
       * @param Bag2
       * @return
       */
      public BagInterface <T> intersection(BagInterface <T> Bag2);
      /**
       * This collects and compares both collections.
       * This returns a bag that contains only the entries that bag 1 and bag 2 don't share.
       * @param Bag2
       * @return
       */
      public BagInterface <T> difference(BagInterface <T> Bag2);   
}