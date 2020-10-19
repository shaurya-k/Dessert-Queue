//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Dessert Queue)
// Files: (DessertSolvers.java, Guest.java, ServingQueue.java, QueueTests.java)
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
 * This class tests certain algorithms and checks if they are doing their intended purpose
 * 
 * @author Shaurya
 *
 */
public class QueueTests {
  /**
   * This method checks if add algorithm from ServingQueue works correctly
   * 
   * @return false if test fails
   */
  public static boolean testAdd() {
    Guest a = new Guest(); // creates new guest
    ServingQueue queue = new ServingQueue(2); // creates new servingqueue
    queue.add(a); // adds guest to queue
    if (queue.peek() == a) { // checks if queue peek function is right
      System.out.println("testAdd passed");
      return true;
    }

    System.out.println("testAdd failed");
    return false;
  }

  /**
   * This method checks if removed algorithm from ServingQueue works correctly
   * @return false if test fails
   */
  public static boolean testRemove() {
    Guest b = new Guest(); // creates new guest
    Guest c = new Guest(); // creates new guest
    ServingQueue queue = new ServingQueue(2); // creates new serving queue
    queue.add(b); // add guest b to queue
    queue.add(c); // add guest c to queue
    if (queue.remove() == b) { // if remove function works
      if (queue.peek() == c) { // if the peek function works
        System.out.println("testRemove passed");
        return true;
      }
    }
    System.out.println("testRemove failed");
    return false;
  }

  /**
   * This method checks if add isEmpty from ServingQueue works correctly
   * @return false if test fails
   */
  public static boolean testIsEmpty() {
    ServingQueue queue = new ServingQueue(2); // create new queue
    Guest a = new Guest(); // create new guest
    Guest b = new Guest(); // create new guest
    queue.add(a); // add guest to queue
    queue.add(b); // add guest to queue
    queue.remove(); // remove guest a from queue
    queue.remove(); // remove guest b from queue
    if (queue.isEmpty()) { // check if function returns true
      System.out.println("testIsEmpty passed");
      return true;
    }
    System.out.println("testIsEmpty failed");
    return false;
  }

  /**
   * main method which runs all the test methods
   * 
   * @param args
   */
  public static void main(String[] args) {
    testAdd(); // calls the method
    testRemove(); // calls the method
    testIsEmpty(); // calls the method
  }
}
