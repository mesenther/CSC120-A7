import java.util.ArrayList;
import javax.management.RuntimeErrorException;

/**
 * House child class of Building with a list of residents that can be searched or edited
 */
public class House extends Building {

    private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
    private boolean hasDiningRoom;
    private boolean hasElevator;

    /**
     * House constructor calls Building constructor and initializes attributes
     * @param name
     * @param address
     * @param floors
     * @param hasDining
     */
    public House(String name, String address, int floors, boolean hasDining, boolean hasElevator) {
      super(name, address, floors);
      residents = new ArrayList<String>();
      hasDiningRoom = hasDining;
      this.hasElevator = hasElevator;

      System.out.println("You have built a house!");
    }

    /**
     * Another constructor for House that does not require address
     * @param name
     * @param floors
     * @param hasElevator
     */
    public House(String name, int floors, boolean hasDining, boolean hasElevator) {
      super(name, floors);
      residents = new ArrayList<String>();
      hasDiningRoom = hasDining;
      this.hasElevator = hasElevator;
    }

    /**
     * Displays all method options for the House class
     */
    public void showOptions() {
      super.showOptions();
      System.out.println(" + hasDiningRoom() \n + nResidents \n + moveIn(name) \n + moveOut(name) \n + isResident");
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
          throw new RuntimeException("This house does not have an elevator, so you must choose an adjacent floor.");
        }
      }
    }

    /**
     * Getter for dining attribute
     * @return hasDiningRoom
     */
    public boolean hasDiningRoom() {
      return hasDiningRoom;
    }

    /**
     * Finds the total number of people living in the house
     * @return residents.size()
     */
    public int nResidents() {
      return residents.size();
    }

    /**
     * Another nResidents method that returns the bigger number between a given number and the number of residents
     * @param compareNum
     * @return larger
     */
    public int nResidents(int compareNum) {
      int larger;
      if (residents.size() > compareNum) {
        larger = residents.size();
      }
      else {
        larger = compareNum;
      }
      return larger;
    }

    /**
     * Adds a resident to the house
     * @param name
     */
    public void moveIn(String name) {
      residents.add(name);
    }

    /**
     * Removes a resident from the house
     * @param name
     * @return name
     */
    public String moveOut(String name) {
      residents.remove(name);
      return name;
    }

    /**
     * Checks if someone is a resident
     * @param person
     * @return residents.contains(person)
     */
    public boolean isResident(String person) {
      return residents.contains(person);
    }

    /**
     * Overrides Building toString() with more detailed House specific info
     */
    public String toString() {
      return this.getName() + " is a " + this.getFloors() + "-story residence hall in the " + this.getAddress() + " area of campus";
    }

    public static void main(String[] args) {
      House myHouse = new House("Morris", 4, true, false);
      
      System.out.println(myHouse.toString());
      myHouse.moveIn("Bob");
      System.out.println(myHouse.nResidents());
      System.out.println(myHouse.isResident("Bob"));
      /*myHouse.moveOut("Bob");
      System.out.println(myHouse.nResidents());*/

      //myHouse.showOptions();
      /*myHouse.enter();
      myHouse.goToFloor(2);*/
      System.out.println(myHouse.nResidents(0));

    }

}