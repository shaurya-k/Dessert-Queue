//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Dessert Queue)
// Files: (ServingQueue.java, Guest.java, DessertSolvers.java, QueueTests.java)
// Course: (CS 300, Spring, and 2019)
//
// Author: (Shaurya Kethireddy)
// Email: (skethireddy@wisc.edu)
// Lecturer's Name: (Gary Dahl)
//
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This class implements a queue of Guest objects with circular indexing
 * 
 * @author shaurya
 *
 */
public class ServingQueue {
  private int size = 0;
  private int front;
  private int end;
  private int seatsAtTable;
  private Guest array[];

  /**
   * Creates a new array based queue with a capacity of "seatsAtTable" guests. This queue should be
   * initialized to be empty.
   * 
   * @param seatsAtTable the size of the array holding this queue data
   */
  public ServingQueue(int seatsAtTable) {
    this.seatsAtTable = seatsAtTable; // assigns the variable to the parameter
    front = 0; // assigns the variable to size
    end = 0; // sets the end to the parameter minus one
    array = new Guest[this.seatsAtTable]; // creates new array with capacity parameter
    size = 0;
  }

  /**
   * Checks whether there are any guests in this serving queue.
   * @return true when this queue contains zero guests, and false otherwise.
   */
  public boolean isEmpty() {
    return size == 0; // checks if size is 0
  }

  /**
   * Adds a single new guest to this queue (to be served after the others that
   * were previously added to the queue).
   * @param newGuest is the guest that is being added to this queue.
   * @throws IllegalStateException when called on a ServingQueue with an array that is full
   */
  public void add(Guest newGuest) {
    if (size >= seatsAtTable) { // condition to see if the array is full
      throw new IllegalStateException("The table is full"); // throw condition
    }

    array[end] = newGuest; // sets newGuest to the end
    end = (end + 1) % array.length; // recalculate the end number
    size = size + 1; // increment size
  }

  /**
   * Accessor for the guest that has been in this queue for the longest.  This method
   * does not add or remove any guests.
   * @return a reference to the guest that has been in this queue the longest.
   * @throws IllegalStateException when called on an empty ServingQueue
   */
  public Guest peek() {
    if (isEmpty() == true) { // checks if the queue is empty
      throw new IllegalStateException("The queue is empty");
    }
    return array[front]; // returns , not remove the first guest
  }

  /**
   * Removes the guest that has been in this queue for the longest.
   * @return a reference to the specific guest that is being removed.
   * @throws IllegalStateException when called on an empty ServingQueue
   */
  public Guest remove() {
    if (isEmpty() == true) { // checks if the queue is empty
      throw new IllegalStateException("The queue is empty");
    }
    Guest removed = array[front]; // sets removed to the first guest in array
    array[front] = null; // clears the element
    front = (front + 1) % array.length; // recalculate the front size
    size = size - 1; // decrement size
    return removed;
  }

  /**
   * The string representation of the guests in this queue should display each
   * of the guests in this queue (using their toString() implementation), and should
   * display them in a comma separated list that is surrounded by a set of square brackets.
   * (this is similar to the formatting of java.util.ArrayList.toString()).  The order 
   * that these guests are presented in should be (from left to right) the guest that has 
   * been in this queue the longest, to the guest that has been in this queue the shortest.
   * When called on an empty ServingQueue, returns "[]".
   * @return string representation of the ordered guests in this queue
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    if (isEmpty() == true) { // if the queue is empty
      return "[]"; // return the "[]"
    }
    String rtn = "[";
    int temp = front; // sets the new int
    while (temp < end) { // while condition
      rtn += array[temp].toString();
      rtn += ", ";
      temp = (temp + 1) & array.length;
    }
    rtn += array[temp].toString();
    rtn += "]";
    return rtn;
  }
}
