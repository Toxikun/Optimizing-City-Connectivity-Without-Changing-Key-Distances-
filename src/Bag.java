//-----------------------------------------------------
// Title: Bag Data Structure
// Author: Ahmet Orkun Yılmaz
// ID: 15100024924
// Section: 3
// Assignment: 1
// Description: This class implements a generic Bag data structure
//              that supports adding elements and iteration.
//-----------------------------------------------------

import java.util.Iterator;
import java.util.LinkedList;

class Bag<T> implements Iterable<T> {

    LinkedList<T> items; // List to store elements

    //--------------------------------------------------------
    // Summary: Constructor initializes an empty bag.
    // Precondition: None.
    // Postcondition: A new empty bag is created.
    //--------------------------------------------------------
    public Bag() {
        items = new LinkedList<>();
    }

    //--------------------------------------------------------
    // Summary: Adds an item to the bag.
    // Precondition: item is a valid object of type T.
    // Postcondition: The item is added to the bag.
    //--------------------------------------------------------
    public void add(T item) {
        items.add(item);
    }

    //--------------------------------------------------------
    // Summary: Checks if the bag is empty.
    // Precondition: None.
    // Postcondition: Returns true if the bag is empty, false otherwise.
    //--------------------------------------------------------
    public boolean isEmpty() {
        return items.isEmpty();
    }

    //--------------------------------------------------------
    // Summary: Returns the number of items in the bag.
    // Precondition: None.
    // Postcondition: Returns the size of the bag.
    //--------------------------------------------------------
    public int size() {
        return items.size();
    }

    //--------------------------------------------------------
    // Summary: Returns an iterator for the bag.
    // Precondition: None.
    // Postcondition: An iterator over the bag's items is returned.
    //--------------------------------------------------------
    public Iterator<T> iterator() {
        return items.iterator();
    }
}
