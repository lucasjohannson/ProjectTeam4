//Source:
//Game Development Tutorial: Day 2-6: Adding Enemies 
//http://www.kilobolt.com/day-6-adding-enemies/unit-2-day-6-adding-enemies


public class Enemy {
	private String name;
	private int maxCorHealth;
	private int currentHealth;
	private int power;
	private int speed; 
	private Location location = new Location(0,0); 
	private static final char token = 'E';

	public Enemy(String aName, int xCoord, int yCoord, int attack, int maxHP) {
		setName(aName);
		setLocation(xCoord, yCoord);
		setPower(attack);
		setmaxCorHealth(maxHP);
		setcurrentHealth(maxHP);
	}
	
	public Enemy() {
		setName(null);
		setPower(1);
		setmaxCorHealth(20);
	}
	
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
	public int getSpeed() {
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
	public void setcurrentHealth(int health) {
		  if (health >= 0) {
			  currentHealth = health;
		  } else {
			  currentHealth = 0;
		  }	
	}
	
	//SETTER 
	public void setPower(int p) {
		this.power = p;
	}
	
	//SETTER 
	public void setSpeed(int s) {
		this.speed = s;
	}
	

	//SETTER 
	public void setLocation(Location l) {
		this.location = l;
		
	}
	
	public void setLocation(int x, int y) {
		location.setX(x);
		location.setY(y);
	}
	
	public void setName(String aName) {
		name = aName;
	}
	//SETTER
	public void die() {
		if (currentHealth < 0) {
			//
		}
	}
	
	public char getToken() {
		return token;
	}
	
	public void placeToken(Map aMap) {
		aMap.setTile(getLocation(), getToken());
	}
	
	public void attack(Player player) {
		int playerHP = player.getHP();
		  if (playerHP >= 0) {
			  player.setHP(playerHP - getPower());
		  }
	}
	
	public String getName() {
		return name;
	}

	
}
