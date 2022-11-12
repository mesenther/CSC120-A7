import java.nio.charset.CodingErrorAction;

/** Cafe child class of Building capable of selling and restocking coffee */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructor that only requires Cafe name
     * @param name
     */
    public Cafe(String name) {
        super(name, "<Address Unknown>");
        this.nCoffeeOunces = -1;
        this.nSugarPackets = -1;
        this.nCreams = -1;
        this.nCups = -1;
    }

    /**
     * Constructor that requires only Cafe name and address
     * @param name
     */
    public Cafe(String name, String address) {
        super(name, address);
        this.nCoffeeOunces = -1;
        this.nSugarPackets = -1;
        this.nCreams = -1;
        this.nCups = -1;
    }

    /**
     * Constructor that requires building info, but no starting supplies
     * @param name
     * @param address
     * @param nFloors
     */
    public Cafe(String name, String address, int nFloors) {
        this(name, address, nFloors, -1, -1, -1, -1);
    }

    /** 
     * Constructor that constructs a Building with the given parameters, then initializes the Cafe supplies
     * @param name
     * @param address
     * @param floors
     * */
    public Cafe(String name, String address, int floors, int coffeeOunces, int sugarPackets, int nCreams, int nCups) {
        super(name, address, floors);
        this.nCoffeeOunces = coffeeOunces;
        this.nSugarPackets = sugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * Displays all method options for the Cafe class
     */
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(size, nSugarPackets, nCreams) \n + getCoffeeOunces() \n + getSugarPackets() \n + getCreams() \n + getCups() \n + restock(nCoffeeOunces, nSugarPackets, nCreams, nCups)");
    }

    /**
     * Goes to specified floor only if it is the first floor
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }

        if (floorNum < 1) {
            throw new RuntimeException("Not a valid floor.");
        }

        if (floorNum > 1) {
            throw new RuntimeException("You are not authorized to access the upper floors of this cafe.");
        }

        this.activeFloor = floorNum;
        System.out.println("You are now inside " + this.name + " on floor #" + this.activeFloor);
    }

    /** 
     * Method that sells a single coffee; if there aren't enough supplies, it will restock first
     * @param size
     * @param nSugarPackets
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {

        if (nCoffeeOunces == -1) {
            throw new RuntimeException("The supplies of the Cafe have not been initialized. Please call a different constructor in order to sell coffee.");
        }
        int coffeeRestock = 0;
        int sugarRestock = 0;
        int creamsRestock = 0;
        int cupsRestock = 0;

        // if there are enough supplies, the coffee is sold
        if (nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && this.nCreams >= nCreams) {
            nCoffeeOunces = nCoffeeOunces - size;
            this.nSugarPackets = this.nSugarPackets - nSugarPackets;
            this.nCreams = this.nCreams - nCreams;
            this.nCups = this.nCups - 1;
        }

        // if there aren't enough supplies, the supplies needed are restocked
        else {
            if (size > nCoffeeOunces) {
                coffeeRestock = 100;
            }

            if (nSugarPackets > this.nSugarPackets) {
                sugarRestock = 100;
            }

            if (nCreams > this.nCreams) {
                creamsRestock = 100;
            }

            if (this.nCups < 1) {
                cupsRestock = 100;
            }
        }

        this.restock(coffeeRestock, sugarRestock, creamsRestock, cupsRestock);

        // coffee is made after restock
        nCoffeeOunces = nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        this.nCups = this.nCups - 1;

    }

    /**
     * Another sellCoffee method that specifies the number of coffees being sold
     * @param size
     * @param nSugarPackets
     * @param nCreams
     * @param numCoffees
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams, int numCoffees) {
        
        if (nCoffeeOunces == -1) {
            throw new RuntimeException("The supplies of the Cafe have not been initialized. Please call a different constructor in order to sell coffee.");
        }

        int coffeeRestock = 0;
        int sugarRestock = 0;
        int creamsRestock = 0;
        int cupsRestock = 0;

        int coffeeNeeded = size*numCoffees;
        int sugarNeeded = nSugarPackets*numCoffees;
        int creamsNeeded = nCreams*numCoffees;

        // if there are enough supplies, the coffee is sold
        if (nCoffeeOunces >= coffeeNeeded && this.nSugarPackets >= sugarNeeded && this.nCreams >= creamsNeeded) {
            nCoffeeOunces = nCoffeeOunces - coffeeNeeded;
            this.nSugarPackets = this.nSugarPackets - sugarNeeded;
            this.nCreams = this.nCreams - creamsNeeded;
            this.nCups = this.nCups - numCoffees;
        }

        // if there aren't enough supplies, the supplies needed are restocked
        else {
            if (coffeeNeeded > nCoffeeOunces) {
                coffeeRestock = 100;
            }

            if (sugarNeeded > this.nSugarPackets) {
                sugarRestock = 100;
            }

            if (creamsNeeded > this.nCreams) {
                creamsRestock = 100;
            }

            if (numCoffees > nCups) {
                cupsRestock = 100;
            }
        }

        this.restock(coffeeRestock, sugarRestock, creamsRestock, cupsRestock);

        // coffee is made after restock
        nCoffeeOunces = nCoffeeOunces - coffeeNeeded;
        this.nSugarPackets = this.nSugarPackets - sugarNeeded;
        this.nCreams = this.nCreams - creamsNeeded;
        this.nCups = this.nCups - numCoffees;
    }

    /** 
     * Getter for coffee ounces
     * @return this.nCoffeeOunces
     */
    public int getCoffeeOunces() {
        return this.nCoffeeOunces;
    }

    /** 
     * Getter for sugar packets
     * @return this.nSugarPackets
     */
    public int getSugarPackets() {
        return this.nSugarPackets;
    }

    /** 
     * Getter for creams
     * @return this.nCreams
     */
    public int getCreams() {
        return this.nCreams;
    }

    /** 
     * Getter for cups
     * @return this.nCups
     */
    public int getCups() {
        return this.nCups;
    }

    /** 
     * Restocks the shop with the given amounts of supplies
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = this.nCoffeeOunces + nCoffeeOunces;
        this.nSugarPackets = this.nSugarPackets + nSugarPackets;
        this.nCreams = this.nCreams + nCreams;
        this.nCups = this.nCups + nCups;
    }


    public static void main(String[] args) {
        Cafe myCafe = new Cafe("myCafe");
        /*
        System.out.println("coffee: " + myCafe.getCoffeeOunces() + " sugar: " + myCafe.getSugarPackets() + " creams: " + myCafe.getCreams() + " cups: " + myCafe.getCups());
        myCafe.sellCoffee(6,6,6, 2);
        System.out.println("coffee: " + myCafe.getCoffeeOunces() + " sugar: " + myCafe.getSugarPackets() + " creams: " + myCafe.getCreams() + " cups: " + myCafe.getCups());*/

        //myCafe.showOptions();
        myCafe.enter();
        myCafe.goToFloor(1);
    }
    
}
