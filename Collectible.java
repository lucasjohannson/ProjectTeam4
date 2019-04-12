/**
 * A class which represents the items which the player character can acquire on the adventure.
 * Has a name, a location(representing their location on the map) and a token (how they are represented
 * in the 2d char of grid).
 */
public abstract class Collectible {
	
	private String name;
	private Location location = new Location(0, 0);
	private static final char token = 'o';
	
	/**
	 * Default constructor
	 */
	public Collectible() {
		setName("Default");
		setLocation(0,0);
	}
	
	/**
	 * Constructor taking a String and 2 ints as parameters
	 * @param aName the name of the Collectible
	 * @param x the x coordinate of the Collectible
	 * @param y the y coordinate of the Collectible
	 */
	public Collectible(String aName, int x, int y) {
		setName(aName);
		setLocation(x, y);
	}
	
	/**
	 * Constructor taking a String and a Location as parameters
	 * @param aName the name of the Collectible
	 * @param aLocation the location of the Collectible
	 */
	public Collectible(String aName, Location aLocation) {
		setName(aName);
		setLocation(aLocation);
	}
	
	/**
	 * Copy constructor taking another collectible as a parameter
	 * @param toCopy the Collectible to be copied
	 */
	public Collectible(Collectible toCopy) {
		setName(toCopy.getName());
		setLocation(toCopy.getLocation());
	}
	
	/**
	 * Sets the name of the Collectible
	 * @param aName the String which name will be set to
	 */
	public void setName(String aName) {
		name = aName;
	}
	
	/**
	 * Sets the Location of the Collectible
	 * @param aLocation the Location to be set for the Collectible
	 */
	public void setLocation(Location aLocation) {
		location = aLocation;
	}
	
	/**
	 * Sets the Location of the Collectible using 2 ints
	 * @param x the x coordinate of the Location to be set
	 * @param y the y coordinate of the Location to be set
	 */
	public void setLocation(int x, int y) {
		location.setX(x);
		location.setY(y);
	}
	
	/**
	 * Gets the name of the Collectible
	 * @return the name of the collectible
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the Location of the Collectible
	 * @return the Location of the Collectible
	 */
	public Location getLocation() {
		Location l1 = new Location(location);
		return l1;
	}
	
	/**
	 * Gets the x coordinate of the Collectible
	 * @return the x coordinate of the Location of the Collectible
	 */
	public int getX() {
		Location l1 = new Location(location);
		return l1.getX();
	}
	
	/**
	 * Gets the y coordinate of the Collectible
	 * @return the y coordinate of the Location of the Collectible
	 */
	public int getY() {
		Location l1 = new Location(location);
		return l1.getY();
	}
	
	/**
	 * Places the token of the collectible onto a specified map, based on the Location 
	 * of the Collectible
	 * @param aMap the map on which the token will be placed
	 */
	public void placeToken(Map aMap) {
		aMap.setTile(getLocation(), token);
	}
	
	/**
	 * Abstract method that details what occurs when the Collectible is used
	 * Collectibles can only be used on Players
	 * @param aPlayer the player on which the Collectible is to be used
	 */
	public abstract void useItem(Player aPlayer);
	
}
