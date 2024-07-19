import java.util.*;

/*	Represents a room in a dwelling. */

public class Room {
    private int side1, side2;

    /**
     * Default constructor - sets each side of the room to a random
     * int between 3 and 6 inclusive
     */
    public Room() {
        side1 = randomInRange(3, 6);
        side2 = randomInRange(3, 6);
    }

    public Room(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    /**
     * Returns random integer between high and low parameters.
     * 
     * @param low  lowest value of range required
     * @param high highest value of range required
     * @return a random integer between low and high values inclusive
     */
    public static int randomInRange(int low, int high) {
        Random r = new Random();
        return r.nextInt(high - low + 1) + low;
    }

    /**
     * Accessor for side1
     * 
     * @return the length of side 1
     */
    public int getSide1() {
        return side1;
    }

    /**
     * Accessor for side2
     * 
     * @return the length of side 2
     */
    public int getSide2() {
        return side2;
    }

    /**
     * Calculates and returns the area of this room
     * 
     * @return the area of this Room
     */
    public int calcArea() {
        return side1 * side2;
    }

    /**
     * Overrides the toString method in Object
     * 
     * @return a String represention of this Room
     */
    public String toString() {
        return "\t" + side1 + "X" + side2;
    }

}
