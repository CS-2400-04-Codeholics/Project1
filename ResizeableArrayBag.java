import java.util.Arrays;
/**
 * Resizeble Array Bag
 */
public class ResizeableArrayBag<T> implements BagInterface<T>
{	
	private T[] bag;
	private static final int DEFAULT_CAPACITY = 25;
	private int numberOfEntries;
	
	private boolean integrityOK = false;
	private static final int MAX_CAPACITY = 50;
	
	/**
	 * This method creates an empty bag that starts with the default capacity.
	 */
	public ResizeableArrayBag()
	{
		this(DEFAULT_CAPACITY);
	} //end default constructor
	
	/**
	 * This method creates an empty bag that startings with a custom capacity.
	 * @param capacity
	 */  
	public ResizeableArrayBag(int capacity)
	{
		if(capacity <= MAX_CAPACITY)
		{
			//The cast is safe because the new array contains null entries.
			@SuppressWarnings("unchecked")
			T[] tempBag = (T[])new Object[capacity]; //unchecked cast
			bag = tempBag;
			numberOfEntries = 0;
			integrityOK = true;
		}
		else
		{
			throw new IllegalStateException("Dude, you can't make a bag with more than 100 items smh.");
		}
		
		
	} //end constructor
	
	/**
	 * This method adds a new entry to this bag.
	 * @param newEntry  The object to be added as a new entry.
	 * @return  True if the addition is successful, or false if not.
	 */
	public boolean add(T newEntry)
	{
		checkIntegrity();
		boolean result = true;
		
		if(isFull())
		{
			doubleCapacity();
		}
		else
		{
			//Assertion: result is true here
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		}
		
		return result;
	} //end add method
	
	public T[] toArray()
	{
		//The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; //unchecked cast
		
		for(int index = 0; index < numberOfEntries; index++)
		{
			result[index] = bag[index];
		}
		
		return result;
	} //end toArray method
	
	public boolean isFull()
	{
		return numberOfEntries == bag.length;
	} //end isFull method
	
	/**
	 * This method sees whether this bag is empty.
	 * @return  True if this bag is empty, or false if not.
	 */
	public boolean isEmpty()
	{		
		return numberOfEntries == 0;
	} //end isEmpty method
	
	/**
	 * This method gets the current number of entries in this bag.
	 * @return  The integer number of entries currently in this bag.
	 */
	public int getCurrentSize()
	{
		return numberOfEntries;
	}
	
	/**
	 * This method counts the number of times a given entry appears in this bag.
	 * @param anEntry  The entry to be counted.
	 * @return  The number of times anEntry appears in this bag.
	 */
	public int getFrequencyOf(T anEntry)
	{
		checkIntegrity();
		int counter = 0;
		
		for(int index = 0; index < numberOfEntries; index++)
		{
			if(anEntry.equals(bag[index]))
			{
				counter++;
			}
		}
		return counter;
	} //end checkIntegrity method
	
	/**
	 * This method removes one occurrence of a given entry from this bag.
	 * @param anEntry  The entry to be removed.
	 * @return  True if the removal was successful, or false if not.
	 */
	public boolean remove(T anEntry)
	{
		checkIntegrity();
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	} //end remove method
	
	/**
	 * This method removes one unspecified entry from this bag, if possible.
	 * @return  Either the removed entry, if the removal was successful, or null otherwise.
	 */
	public T remove()
	{
		checkIntegrity();
		T result = removeEntry(numberOfEntries - 1);
		return result;
	} //end remove method
	
	public void clear()
	{
		while(!isEmpty())
		{
			remove();
		}
	} //end clear method
	
	/**
	 * This tests whether this bag contains a given entry.
	 * @param anEntry  The entry to locate.
	 * @return  True if this bag contains anEntry, or false otherwise.
	 */
	public boolean contains(T anEntry)
	{
		checkIntegrity();
		return getIndexOf(anEntry) >= 0;
	} //end contains method
	
	/**
	 * Combines two arrays into one
	 * @return	array with all values from previous arrays.
	 */
	public BagInterface<T> union(BagInterface<T> otherBag)
	{
		BagInterface<T> result = new ResizeableArrayBag<>();
		
		T[]mine = this.toArray();
		
		for(T elem : mine)
		{
			result.add(elem);
		}
		T[] others = otherBag.toArray();
	
		for(T elem : others)
		{
			result.add(elem);
		}
		return result;
	} //end union method
	
	/**
	 * Checks to see which values are the same between two arrays.
	 * @return	array with similar values form both arrays.
	 */
	public BagInterface<T> intersection(BagInterface<T> otherBag)
	{
		BagInterface<T> result = new ResizeableArrayBag<>();
		BagInterface<T> finalResult = new ResizeableArrayBag<>();
		
		T[]mine = this.toArray();
		
		for(T elem : mine)
		{
			result.add(elem);
		}
		T[] others = otherBag.toArray();
	
		for(T elem : others)
		{
			if(result.contains(elem))
			{
				finalResult.add(elem);
			}
			
		}
		return finalResult;
	} //end intersection method
	
	/**
	 * Checks to see which values are different between two arrays.
	 * @return	array with different values form both arrays.
	 */
	public BagInterface<T> difference(BagInterface<T> otherBag)
	{
		BagInterface<T> result = new ResizeableArrayBag<>();
		
		T[]mine = this.toArray();
		
		for(T elem : mine)
		{
			result.add(elem);
		}
		T[] others = otherBag.toArray();
	
		for(T elem : others)
		{
			if(result.contains(elem))
			{
				result.remove(elem);
			}
			
		}
		return result;
	} //end difference method
	
	//Throws an exception if the client requests a capaity that is too large.
	private void checkCapacity(int capacity)
	{
		if(capacity > MAX_CAPACITY)
		{
			throw new IllegalStateException("Ayo! U tryna make a bag capacity bigger than the maximum of " + MAX_CAPACITY);
		}
	} //ends checkCapacity method
	
	private void doubleCapacity()
	{
		int newLength = 2 * bag.length;
		checkCapacity(newLength);
		bag = Arrays.copyOf(bag, newLength);
	} //end doubleCapacity method
	
	// Locates a given entry within the array bag.
	// Returns the index of the entry, if located, or -1 otherwise.
	private int getIndexOf(T anEntry)
	{
		int where = -1;
		boolean found = false;
		int index = 0;
		
		while(!found && (index < numberOfEntries))
		{
			if(anEntry.equals(bag[index]))
			{
				found = true;
				where = index;
			}
			index++;
		}
		// Assertion: If where > -1, anEntry is in the array bag, and it
		// equals bag[where]; otherwise, anEntry is not in the array
		
		return where;
	} //end getIndexOf method
	
	// Removes and returns the entry at a given index within the array bag.
	// If no such entry exists, returns null.
	private T removeEntry(int givenIndex)
	{
		T result = null;
		
		if(!isEmpty() && (givenIndex >= 0)) {
			result = bag[givenIndex];
			bag[givenIndex] = bag[numberOfEntries - 1];
			bag[numberOfEntries] = null;
			numberOfEntries--;
		}
		return result;
	}
	
	//Throws an exception if object is not initialized.
	private void checkIntegrity()
	{
		if(integrityOK == false)
		{
			throw new SecurityException("Bro, your item is invalid >:(");
		}
	} //end checkIntegrity method
	
}
