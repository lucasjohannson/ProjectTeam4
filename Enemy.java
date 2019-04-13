//Source:
//Game Development Tutorial: Day 2-6: Adding Enemies 
//http://www.kilobolt.com/day-6-adding-enemies/unit-2-day-6-adding-enemies

/**
 * A class which represents an enemy monster, with a name, a max hp, current hp,
 * power and a location in which it is located on the map.
 */
public class Enemy {
	private String name;
	private int maxCorHealth;
	private int currentHealth;
	private int power;
	private int speed;
	private Location location = new Location(0, 0);
	private static final char token = 'E';

	/**
	 * Constructor for Enemy taking a string and four ints as arguments
	 * 
	 * @param aName  the name of the Enemy
	 * @param xCoord the x coordinate of the Location of the Enemy
	 * @param yCoord the y coordinate of the Location of the Enemy
	 * @param attack the power value of the Enemy
	 * @param maxHP  the maximum hp of the Enemy
	 */
	public Enemy(String aName, int xCoord, int yCoord, int attack, int maxHP) {
		setName(aName);
		setLocation(xCoord, yCoord);
		setPower(attack);
		setmaxCorHealth(maxHP);
		setcurrentHealth(maxHP);
	}

	/**
	 * Default constructor
	 */
	public Enemy() {
		setName(null);
		setPower(1);
		setmaxCorHealth(20);
	}

	/**
	 * Gets the max health value of the Enemy
	 * 
	 * @return the max health of the Enemy
	 */
	public int getmaxCorHealth() {
		return this.maxCorHealth;
	}

	/**
	 * Gets the current health value of the Enemy
	 * 
	 * @return the current health of the Enemy
	 */
	public int getcurrentHealth() {
		return this.currentHealth;
	}

	/**
	 * Gets the power value of the Enemy
	 * 
	 * @return the power of the Enemy
	 */
	public int getPower() {
		return this.power;
	}

	/**
	 * Gets the speed value of the Enemy
	 * 
	 * @return the speed of the Enemy
	 */
	public int getSpeed() {
		return this.speed;
	}

	/**
	 * Gets the Location of the Enemy
	 * 
	 * @return the Location of the Enemy
	 */
	public Location getLocation() {
		return this.location;
	}

	/**
	 * Sets the maximum hp value of the Enemy
	 * 
	 * @param mh the maximum hp to be set
	 */
	public void setmaxCorHealth(int mh) {
		this.maxCorHealth = mh;
	}

	/**
	 * Sets the current health of the Enemy
	 * 
	 * @param health the current health to be set, if health is greater than 0
	 */
	public void setcurrentHealth(int health) {
		if (health >= 0) {
			currentHealth = health;
		} else {
			currentHealth = 0;
		}
	}

	/**
	 * Sets the power of the Enemy
	 * 
	 * @param p the power of the enemy to be set, if p is greater than 0
	 */
	public void setPower(int p) {
		if (p > 0) {
			this.power = p;
		} else {
			power = 1;
		}
	}

	/**
	 * Sets the speed of the Enemy
	 * 
	 * @param s the speed of the enemy to be set, if s is greater than 0
	 */
	public void setSpeed(int s) {
		if (s > 0) {
			this.speed = s;
		} else {
			speed = 1;
		}
	}

	/**
	 * Sets the location of the Enemy
	 * 
	 * @param l the Location of the enemy to be set
	 */
	public void setLocation(Location l) {
		this.location = l;

	}

	/**
	 * Sets the location of the Enemy
	 * 
	 * @param x the x coordinate of the Location to be set
	 * @param y the y coordinate of the Location to be set
	 */
	public void setLocation(int x, int y) {
		location.setX(x);
		location.setY(y);
	}

	/**
	 * Sets the name of the Enemy
	 * 
	 * @param aName the name to be set for the enemy
	 */
	public void setName(String aName) {
		name = aName;
	}

	/**
	 * Gets the token of Enemy, the char which represents an Enemy on the map
	 * 
	 * @return the token of Enemy
	 */
	public char getToken() {
		return token;
	}

	/**
	 * Places the token of Enemy(E) on the specified map based on the Location of
	 * the Enemy
	 * 
	 * @param aMap the map on which the token is to be placed
	 */
	public void placeToken(Map aMap) {
		aMap.setTile(getLocation(), getToken());
	}

	/**
	 * A method allowing an enemy to attack the specified player
	 * 
	 * @param player the player to be attacked
	 */
	public void attack(Player player) {
		int playerHP = player.getHP();
		if (playerHP >= 0) {
			player.setHP(playerHP - getPower());
		}
	}

	/**
	 * Gets the name of the Enemy
	 * 
	 * @return the name of the enemy
	 */
	public String getName() {
		return name;
	}
}
