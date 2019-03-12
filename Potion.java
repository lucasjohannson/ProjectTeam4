
public class Potion extends Collectible {

	private int hpRestored;
	
	public Potion(String name, Location location, int recovery) {
		super(name, location);
		setRestoration(recovery);
	}
	
	public Potion(String name, int x, int y, int recovery) {
		super(name, x, y);
		setRestoration(recovery);
	}
	
	public void useItem(Player aPlayer) {
		if(hpRestored + aPlayer.getHP() >= aPlayer.getMaxHP()) {
			aPlayer.setHP(aPlayer.getMaxHP());
		} else {
			aPlayer.setHP(hpRestored + aPlayer.getHP());
		}
	}
	
	public void setRestoration(int recovery) {
		if(recovery > 0) {
			hpRestored = recovery;
		} else {
			hpRestored = 0;
		}
	}
	
	public int getRestoration() {
		return hpRestored;
	}
	
	public String toString() {
		return "You drank a " + getName() + " and restored " + hpRestored + " hit points!";
	}
}
