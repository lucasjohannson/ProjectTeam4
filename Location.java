/**
*A class which identifies the location an object is placed on a 2D plane. Contains and x and a y co-ordinate
**/

public class Location {

private int xCoord;
private int yCoord;
	
	/**
	 * Basic constructor that creates a new location at (0, 0)
	 */
	public Location() {
		setX(0);
		setY(0);
	}
	
	/**
	 * Creates a new location with the specified x and y coordinates
	 * @param x, the x coordinate
	 * @param y, the y coordinate
	 */
	public Location(int x, int y) {
		
		setX(x);
		setY(y);
	}
	
	/**
	 * Creates a new location that is a copy of another location
	 * @param toCopy the location to be copied
	 */
	public Location(Location toCopy) {
		
		xCoord = toCopy.getX();
		yCoord = toCopy.getY();
	}
	
	/**
	 * Returns the x coordinate of the location
	 * @return the x coordinate
	 */
	public int getX () {
		return xCoord;
	}
	
	/**
	 * Returns the y coordinate of the location
	 * @return the y coordinate
	 */
	public int getY () {
		return yCoord;
	}
	
	/**
	 * A method to get the coordinate of a location 1 space to the North
	 * @return the location of a coordinate 1 space to the North of the current location.
	 */
	public Location getNorth() {
		Location north = new Location(xCoord, yCoord);
		north.setY(getY() - 1);
		return north;
	}
	
	/**
	 * A method to get the coordinate of a location 1 space to the East
	 * @return the location of a coordinate 1 space to the East of the current location.
	 */
	public Location getEast() {
		Location east = new Location(xCoord, yCoord);
		east.setX(getX() + 1);
		return east;
	}
	
	/**
	 * A method to get the coordinate of a location 1 space to the West
	 * @return the location of a coordinate 1 space to the West of the current location.
	 */
	public Location getWest() {
		Location west = new Location(xCoord, yCoord);
		west.setX(getX() - 1);
		return west;
	}
	
	/**
	 * A method to get the coordinate of a location 1 space to the South
	 * @return the location of a coordinate 1 space to the South of the current location.
	 */
	public Location getSouth() {
		Location south = new Location(xCoord, yCoord);
		south.setY(getY() + 1);
		return south;
	}
	
	/**
	 * A method to set the x coordinate of the location
	 * @param x, the x coordinate to be set
	 */
	public void setX (int x) {
		this.xCoord = x;
	}
	
	/**
	 * A method to set the y coordinate of the location
	 * @param y, the y coordinate to be set
	 */
	public void setY (int y) {
		this.yCoord = y;
	}
	
	/**
	 * Checks whether 2 locations are the same (if they have the same x and y coordinates)
	 * @param aLocation the location to be checked against the current location
	 * @return equal, which is true if the locations are the same and false if they are not
	 */
	public boolean isEqual(Location aLocation) {
		boolean equal = false;
		if(getX() == aLocation.getX() && getY() == aLocation.getY()) {
			equal = true;
		}
		return equal;
	}
	
	/**
	 * Returns the x and y coordinates of the location in String form
	 */
	public String toString() {
		return "The x coordinate is " + xCoord + " and the y coordinate is " + yCoord;
	}
}
