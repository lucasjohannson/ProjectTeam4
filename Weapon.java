
public abstract class Weapon {
private int damage;
private String name;

	public Weapon(int weaponDamage, String nameOfWeapon) {
		this.damage = weaponDamage;
		this.name = nameOfWeapon;
	}
	
	public String getName() {
		return name;
	}
	 
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damageValue) {
		damage = damageValue;
	}
	
	public void setName(String newName) {
		name = newName;
	}
//	 public damageCalc(int enemyHealth, int characterDmg){
//		int dmgDealt = 0;
//		dmgDealt = enemyHealth - (characterDmg + damage);
//		return dmgDealt;
//		
//	 }
	
}
