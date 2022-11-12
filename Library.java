import java.util.Hashtable;

/** Library child class of Building with collection of books and methods to modify it*/
public class Library extends Building {

  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

    /**
     * Constructor constructs a Building with the given parameters, then initializes the collection of books
     * @param name
     * @param address
     * @param floors
     */
    public Library(String name, String address, int floors, boolean hasElevator) {
      super(name, address, floors);
      collection = new Hashtable<String, Boolean>();
      this.hasElevator = hasElevator;

      System.out.println("You have built a Library!");
    }

    /**
     * Another constructor for Library that does require the address
     * @param name
     * @param floors
     * @param hasElevator
     */
    public Library(String name, int floors, boolean hasElevator) {
      super(name, floors);
      collection = new Hashtable<String, Boolean>();
      this.hasElevator = hasElevator;
    }

    /**
     * Goes to specified floor if it is valid and can be accessed with an elevator; otherwise, only if it's adjacent to the current floor
     */
    public void goToFloor(int floorNum) {
      if (this.hasElevator) {
        super.goToFloor(floorNum);
      }
      else {
        if (floorNum == this.activeFloor + 1 || floorNum == this.activeFloor - 1) {
          this.activeFloor = floorNum;
          System.out.println("You are now inside " + this.name + " on floor #" + this.activeFloor + ".");
        }
        else {
          throw new RuntimeException("This library does not have an elevator, so you must choose an adjacent floor.");
        }
      }
    }

    /**
     * Displays all of the method options for the Library class
     */
    public void showOptions() {
      super.showOptions();
      System.out.println(" + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title) \n + containsTitle(title) \n + isAvailable(title) \n + printCollection()");
    }

    /**
     * Adds a book title to the collection
     * @param title
     */
    public void addTitle(String title) {
      collection.put(title, true);
    }

    /**
     * Removes a book title from the collection
     * @param title
     * @return title
     */
    public String removeTitle(String title){
      collection.remove(title);
      return title;
    } 

    /**
     * Checks out a book from the collection
     * @param title
     */
    public void checkOut(String title) {
      collection.replace(title, false);
    }

    /**
     * Overloaded checkOut that can check out any number of books
     * @param args
     */
    public void checkOut(String... args) {
      for (String title : args) {
          collection.replace(title, false);
      }
    }

    /**
     * Returns a book to the collection
     * @param title
     */
    public void returnBook(String title) {
      collection.replace(title, true);

    }

    /**
     * Checks if a given title is in the collection
     * @param title
     * @return collection.containsKey(title)
     */
    public boolean containsTitle(String title) {
      return collection.containsKey(title);
    }

    /**
     * Checks if a given title is available
     * @param title
     * @return collection.get(title)
     */
    public boolean isAvailable(String title) {
      return collection.get(title);
    }

    /**
     * Prints the collection of books
     */
    public void printCollection() {
      System.out.println(collection);
    }
  
    public static void main(String[] args) {
      Library myLibrary = new Library("myLibrary",  3, false);
      myLibrary.addTitle("The Lorax by Dr. Seuss");
      myLibrary.addTitle("Harry Potter and the Chamber of Secrets by JK Rowling");
      myLibrary.printCollection();
      myLibrary.checkOut("The Lorax by Dr. Seuss");
      System.out.println(myLibrary.isAvailable("The Lorax by Dr. Seuss"));

      myLibrary.returnBook("The Lorax by Dr. Seuss");
      myLibrary.printCollection();
      System.out.println(myLibrary.isAvailable("The Lorax by Dr. Seuss"));

      //myLibrary.showOptions();
      /*myLibrary.enter();
      myLibrary.goToFloor(2);*/

      myLibrary.checkOut("The Lorax by Dr. Seuss", "Harry Potter and the Chamber of Secrets by JK Rowling");
      myLibrary.printCollection();

    }
  
  }