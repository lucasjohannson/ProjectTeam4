public class Enemy {
	private int maxCorHealth;
	private int currentHealth;
	private int power;
	private int speed; 
	private String name;
	private Location location; 

	//GETTER 
	public int getmaxCorHealth() {
		return this.maxCorHealth;
	}
	
	//GETTER 
	public int getcurrentHealth() {
		return this.currentHealth;
	}
	
	//GETTER 
	public int getPower() {
		return this.power;
	}
	
	//GETTER 
	public int getspeed() {
		return this.speed;
	}
	
	//GETTER 
	public Location getLocation() {
		return this.location;
	}
	
	
	//SETTER 
	public void setmaxCorHealth(int mh) {
		this.maxCorHealth = mh;		
	}
	
	//SETTER 
	public void setcurrentHealth(int ch) {
		this.currentHealth = ch;	
	}
	
	//SETTER 
	public void setpower(int p) {
		this.power = p;
	}
	
	//SETTER 
	public void setspeed(int s) {
		this.speed = s;
	}
	

	//SETTER 
	public void setLocation(Location l) {
		this.location = l;
		
	}
		
	//SETTER
	public void die() {
		if (currentHealth < 0) {
			//
		}
	}
	
	//SETTER
	public void attack(Player aPlayer) {
		aPlayer.setHP(aPlayer.getHP() - getPower());
	}

	
}