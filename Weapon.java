
public class Weapon extends Collectible {

	private int damage;
	
	public Weapon(String name, Location location, int dmg) {
		super(name, location);
		setDamage(dmg);
	}
	
	public Weapon(String name, int x, int y, int dmg) {
		super(name, x, y);
		setDamage(dmg);
	}
	
	public void useItem(Player aPlayer) {
		aPlayer.setAttack(damage + aPlayer.getAttack());
	}
	
	public void setDamage(int dmg) {
		if(dmg > 0) {
			damage = dmg;
		} else {
			damage = 0;
		}
	}
	
	public int getDamage() {
		return damage;
	}
	
	public String toString() {
		return "You have equipped a(n) " + getName() + " and increased your damage by " + damage + "!";
	}
}
