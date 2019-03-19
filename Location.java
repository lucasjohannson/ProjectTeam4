/**
*A class which identifies the location an object is placed on a 2D plane. Contains and x and a y co-ordinate
**/

public class Location {

private int xCoord;
private int yCoord;
	
	public Location() {
		setX(0);
		setY(0);
	}
	public Location(int x, int y) {
		
		setX(x);
		setY(y);
	}
	
	public Location(Location toCopy) {
		
		xCoord = toCopy.getX();
		yCoord = toCopy.getY();
	}
	
	public int getX () {
		return xCoord;
	}
	
	public int getY () {
		return yCoord;
	}
	
	public Location getNorth() {
		Location north = new Location(xCoord, yCoord);
		north.setY(getY() - 1);
		return north;
	}
	
	public Location getEast() {
		Location east = new Location(xCoord, yCoord);
		east.setX(getX() + 1);
		return east;
	}
	
	public Location getWest() {
		Location west = new Location(xCoord, yCoord);
		west.setX(getX() - 1);
		return west;
	}
	
	public Location getSouth() {
		Location south = new Location(xCoord, yCoord);
		south.setY(getY() + 1);
		return south;
	}
	
	public void setX (int x) {
		this.xCoord = x;
	}
	
	public void setY (int y) {
		this.yCoord = y;
	}
	
	public boolean isEqual(Location aLocation) {
		boolean equal = false;
		if(getX() == aLocation.getX() && getY() == aLocation.getY()) {
			equal = true;
		}
		return equal;
	}
}
