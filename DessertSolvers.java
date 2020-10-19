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
 * This class implements algorithms to decide which guest object gets served first
 * 
 * @author shaurya
 *
 */
public class DessertSolvers {
  private static int guests; // declare new variable
  private static int skip; // declare new variable
  private static int courses; // declare new variable

  /**
   * This method should take the number of guests at a party, create as many guests with an index
   * starting at one, simulate the serving of those guests, and then return a reference to the guest
   * that is served last
   * 
   * @param numberOfGuests at the table
   * @param guestsSkipped  to skip when serving
   * @return the guest that will be last served
   */
  public static Guest firstDessertVariableSkips(int numberOfGuests, int guestsSkipped) {
    guests = numberOfGuests; // assigns guests to param numberOfGuests
    skip = guestsSkipped; // assigns skip to param guestsSkipped
    if (guests <= 0 || skip < 0) { // condition
      throw new IllegalArgumentException("Not an appropriate value");
    }
    ServingQueue queue = new ServingQueue(guests); // creates new servingqueue
    Guest first; // declare guest variable
    for (int i = 0; i < guests; i++) {
      queue.add(new Guest()); // add new guest to serving queue
    }
    int temp = 0; // intialize temp variable
    while (temp != guests - 1) { // condition
      queue.remove();
      temp++; // increment
      for (int i = 0; i < skip; i++) {
        first = queue.remove(); // assigns guest variable to top of queue
        queue.add(first); // adds the variable to end of queue

      }
    }

    return queue.peek(); // top of queue
  }

  /**
   * This method should take the number of guests at a party, create as many guests with an index 
   * starting at one, simulate the serving of those guests through the specified number of courses,
   *  and then return a reference to the guest that is served last in the second to last course
   * @param numberOfGuests at the table
   * @param coursesServed - number of courses served
   * @return reference to the guest that is served last in the second to last course
   */
  public static Guest firstDessertVariableCourses(int numberOfGuests, int coursesServed) {
    guests = numberOfGuests; // assign guests to param numberOfGuests
    courses = coursesServed; // assign courses to param coursesServed
    if (guests <= 0 || courses <= 0) { // condition
      throw new IllegalArgumentException("not appropriate value");
    }


    ServingQueue q1 = new ServingQueue(numberOfGuests); // create new servingqueue
    ServingQueue q2 = new ServingQueue(numberOfGuests); // create new servingqueue
    Guest temp = null; // intialize new guest
    Guest tempGuest = null; // intialize new guest
    Guest rtn = null; // intialize new guest
    int skip = 0; // Initialize new int

    for (int i = 0; i < numberOfGuests; i++) {
      q1.add(new Guest()); // add new guests to q1
    }

    if (coursesServed == 1) { // condition
      rtn = q1.peek(); // sets rtn guest to first element in q1
      return rtn = null;
    }

    for (int k = 0; k < coursesServed - 1; k++) {
      skip = 0; // if odd number, then skip (remove and add to ServingQueue again)
      while (!q1.isEmpty()) { // condition
        temp = q1.remove();
        if (skip % 2 != 0) { // condition
          q1.add(temp);
        } else {
          q2.add(temp);
        }
        skip++; // increment
      }

      for (int i = 0; i < numberOfGuests - 1; i++) {
        tempGuest = q2.remove();
        q2.add(tempGuest); // inverses q2 servingqueue
      }
      rtn = q2.peek(); // sets rtn guest to top guest in q2
      q1 = q2; // clears q1 to q2
      q2 = new ServingQueue(numberOfGuests); // creates new q2
    }
    return rtn; // reference to guest object
  }

}

