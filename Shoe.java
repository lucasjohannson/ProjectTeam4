
public class Shoe extends Collectible {
	
	private char unlockTile;

	public Shoe(String name, Location location, char unlock) {
		super(name, location);
		setUnlockTile(unlock);
	}
	
	public Shoe(String name, int x, int y, char unlock) {
		super(name, x, y);
		setUnlockTile(unlock);
	}
	
	public void useItem(Player aPlayer) {
		aPlayer.getTiles().add(unlockTile);
	}

	private void setUnlockTile(char unlock) {
		unlockTile = unlock;
	}
	
	private char getUnlockTile() {
		return unlockTile;
	}
	
	public String toString() {
		return "You have equipped a(n) " + getName() + " and can now walk on " + getUnlockTile() + " tiles!";
	}
}
