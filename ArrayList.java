public class ArrayList<T> implements List<T> {

	private final static int DEFAULT_INITIAL_CAPACITY = 10;   //Default size of the array created
	private int size;   //size 
	private T[] array;  //Array in which the elements are stored.

	//Creates an empty list using the default capacity.
	@SuppressWarnings("unchecked")
	public ArrayList() {
	size = 0;
	array = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

    //add method
	 public void add(T item){
		 if (arrayIsFull()) {
	        	doubleArraySize();
		 	}
	       array[size++] = item;
		    }
	//Update the list so that it includes all of the elements from before the call AND the given element.
	public void add(int pos, T item) {
	if (arrayIsFull()) {
		doubleArraySize();
	}
	for (int i = size-1; i > pos; i-- ) {
		array[i+1] = array[i];
		}
		// Add the element to the array
		array[pos] = item;
	    size++;
	}	 

	//Checks if the backing array has an element in every available entry.

	boolean arrayIsFull() {
	boolean retVal = size == array.length;
	return retVal;
	}

	/**
	* Allocates a new, larger, array and copies over all of the existing elements into it. 
	*/
	@SuppressWarnings("unchecked")
	void  doubleArraySize() {
	// we double the size of the array each time it grows.
	T[] dArray = (T[]) new Object[array.length * 2];
	// Copy all of the elements into the new array
	for (int i = 0; i < array.length; i++ ) {
	dArray[i] = array[i];
	}
	array=dArray;
	}

	//remove element from the array list
	public T remove(int pos) {
	T retVal = get(pos);
	   for(int i=pos; i<size-1; i++)
	   {
	       array[i] = array[i+1];
	   }
	  size--;
	return retVal;
	}

	
	//Returns the element at the specified pos in this list.

	public T get(int pos) {
	if (pos >= size) {
	throw new IndexOutOfBoundsException();
	}
	return array[pos];
	}
	
	
   //Returns the number of elements currently in this list.
	public int size() {
	return size;
	}
}