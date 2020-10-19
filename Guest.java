//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Dessert Queue)
// Files: (Guest.java, ServingQueue.java, DessertSolvers.java, QueueTests.java)
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
 * This class keeps track of the guests at these dinner parties. This is the type of object that the
 * queue implementation will manage
 * 
 * @author shaurya
 *
 */
public class Guest {
  private String dietaryRestriction; // declares new variable
  private int guestIndex; // declare new variable
  public static int index = 1; // Initialize public variable

  /**
   * Resets the counting of newly constructed guest indexes, so that the next new Guest that is
   * created will be associated with the guest index of one.
   * 
   * Note: that this will be helpful when running several tests, or solving solving several dessert
   * simulation problems. And that this should never be called from ServingQueue.java
   */
  public static void resetNextGuestIndex() {
    index = 1; // reset to 1
  }

  /**
   * Constructs a new guest with no dietary restrictions. This guest should be associated with an
   * index that is one larger than the previously constructed guest (or 1, if no prior guest, or if 
   * resetNextGuestIndex() was called more recently).
   */
  public Guest() {
    guestIndex = index; // assigns private variable to public static
    index++; // increment index
  }

  /**
   * Constructs a new guest with the specified dietary restrictions.  This guest should be 
   * associated with an index that is one larger than the previously constructed guest (or 1, if 
   * no prior guest, or if resetNextGuestIndex() was called more recently).
   * @param dietaryRestriction describes requirements for what this guest can and cannot eat
   */
  public Guest(String dietaryRestriction) {
    this.dietaryRestriction = dietaryRestriction; // adds the parameter to local variable
    guestIndex = index; // assigns private variable to public static
    index++; // increment index
  }

  /**
   * Access whether this guest has any dietary restrictions or not
   * @return true for guests constructed using new Guest(String), false otherwise
   */
  public boolean hasDietaryRestriction() {
    if (dietaryRestriction != null) { // checks the dietaryRestriction string for null
      return true; // if not null
    }
    return false; // if null
  }

  /**
   * The string representation of a Guest should be formatted as, for examples:
   * #3(no dairy)
   * for a guest with a guest index of 3 and the dietary restriction of "no dairy", or: 
   * #4
   * for a guest with a guest index of 4 and no dietary restriction
   * @return string representing the guest index and any dietary restriction they might have
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {

    String a = "#" + String.valueOf(guestIndex);
    if (hasDietaryRestriction()) { // condition that checks
      a += "(" + dietaryRestriction + ")"; // adds the dietaryRestriction the string
    }
    return a;
  }
}
