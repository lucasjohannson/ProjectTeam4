
public abstract class Collectible {
	
	private String name;
	private Location location = new Location(0, 0);
	private static final char token = 111;
	
	public Collectible() {
		setName("Default");
		setLocation(0,0);
	}
	
	public Collectible(String aName, int x, int y) {
		setName(aName);
		setLocation(x, y);
	}
	
	public Collectible(String aName, Location aLocation) {
		setName(aName);
		setLocation(aLocation);
	}
	
	public Collectible(Collectible toCopy) {
		setName(toCopy.getName());
		setLocation(toCopy.getLocation());
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public void setLocation(Location aLocation) {
		location = aLocation;
	}
	
	public void setLocation(int x, int y) {
		location.setX(x);
		location.setY(y);
	}
	
	public String getName() {
		return name;
	}
	
	public Location getLocation() {
		Location l1 = new Location(location);
		return l1;
	}
	
	public int getX() {
		Location l1 = new Location(location);
		return l1.getX();
	}
	
	public int getY() {
		Location l1 = new Location(location);
		return l1.getY();
	}
	
	public void setToken(char[][] aGrid) {
		aGrid[getY()][getX()] = token;
	
	public abstract void useItem(Player aPlayer);
	
}
