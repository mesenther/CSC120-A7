import java.util.ArrayList;

/** CampusMap class contains ArrayList of Buildings (or Building subclasses) and methods to edit this list */
public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        // I don't know a lot about Smith buildings, so most of this information is made up
        myMap.addBuilding(new House("Wilder Hall", "62 Roning Street Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new Cafe("Smith Cafe", "47 Gordon Avenue Northampton, MA 01063", 2));
        myMap.addBuilding(new Library("Smith Library", "86 Harton Street Northampton, MA 01063", 3, true));
        myMap.addBuilding(new Building("Swift Hall", 3));
        myMap.addBuilding(new Building("Sesame Hall", "67 Orchard Avenue Northampton, MA 01063", 4));
        myMap.addBuilding(new Cafe("Sunnyside Cafe"));
        myMap.addBuilding(new Library("Duncan Public Library", 3, false));
        myMap.addBuilding(new House("Albright House", "62 Selchin Street Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new Building("Fess Hall", "24 Helomue Boulevard Northampton, MA 01063", 5));
        myMap.addBuilding(new Building("Crelin Hall", "68 Horton Avenue Northampton, MA 01063", 3));

        System.out.println(myMap);
    }
    
}
