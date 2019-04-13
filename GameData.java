import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class which consolidates game data into a single class Contains the
 * startpoint of the map, endpoint of the map, as well as ArrayLists containing
 * all the items and enemies on the map. Also contains player initialization
 * data.
 *
 */
public class GameData {

	private Location startpoint = new Location(0, 0);
	private Location endpoint = new Location(0, 0);
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private ArrayList<Collectible> itemList = new ArrayList<Collectible>();
	private ArrayList<Location> doors = new ArrayList<Location>();
	private int playerAttack = 2;
	private int playerHP = 100;

	/**
	 * A method which initializes game data based on the contents of a text file
	 * 
	 * @param filename the name of the file from which game data will be initialized
	 * @throws FileNotFoundException     if a file cannot be found
	 * @throws IndexOutOfBoundsException if the text file is not formatted properly
	 */
	public void setInitialization(String filename) throws FileNotFoundException, IndexOutOfBoundsException {

		Scanner scan = new Scanner(new BufferedReader(new FileReader(filename)));

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			line.replaceAll("\\s", "");
			String[] splitLine = line.split(",");

			switch (line.charAt(0)) {

			case 'o':
				if (splitLine[1].charAt(0) == 'p') {
					Potion p = new Potion(splitLine[2], Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]),
							Integer.parseInt(splitLine[5]));
					itemList.add(p);
				}
				if (splitLine[1].charAt(0) == 'w') {
					Weapon w = new Weapon(splitLine[2], Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]),
							Integer.parseInt(splitLine[5]));
					itemList.add(w);
				}
				if (splitLine[1].charAt(0) == 's') {
					Shoe s = new Shoe(splitLine[2], Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]),
							splitLine[5].charAt(0));
					itemList.add(s);
				}
				if (splitLine[1].charAt(0) == 'k') {
					Key k = new Key(splitLine[2], Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]),
							splitLine[5].charAt(0));
					itemList.add(k);
				}
				break;

			case 'E':
				Enemy n = new Enemy(splitLine[1], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]),
						Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]));
				enemyList.add(n);
				break;

			case 'P':
				int xCoord = Integer.parseInt(splitLine[1]);
				int yCoord = Integer.parseInt(splitLine[2]);
				playerAttack = Integer.parseInt(splitLine[3]);
				playerHP = Integer.parseInt(splitLine[4]);
				Location start = new Location(xCoord, yCoord);
				setStartpoint(start);
				break;

			case '@':
				int xCoord2 = Integer.parseInt(splitLine[1]);
				int yCoord2 = Integer.parseInt(splitLine[2]);
				Location end = new Location(xCoord2, yCoord2);
				setEndpoint(end);
				break;

			case 'D':
				int xCoord3 = Integer.parseInt(splitLine[1]);
				int yCoord3 = Integer.parseInt(splitLine[2]);
				Location door = new Location(xCoord3, yCoord3);
				addDoor(door);
				break;
			}
		}
		scan.close();
	}

	/**
	 * Sets the initial state of a map grid based on data contained in this class
	 * 
	 * @param aMap the map to be initialized
	 */
	public void initializeMap(Map aMap) {

		for (Collectible item : itemList) {
			item.placeToken(aMap);
		}
		for (Enemy e : enemyList) {
			e.placeToken(aMap);
		}
		for (Location d : doors) {
			aMap.setTile(d, 'D');
		}
		aMap.setTile(getEndpoint(), '@');
		aMap.setTile(getStartpoint(), 'P');
	}

	/**
	 * Sets the initial state of the player character based on data contained in
	 * this class
	 * 
	 * @param aPlayer the player to be initialized
	 */
	public void initializePlayer(Player aPlayer) {
		aPlayer.setLocation(getStartpoint());
		aPlayer.setAttack(playerAttack);
		aPlayer.setMaxHP(playerHP);
	}

	/**
	 * Sets the endpoint of a map based on the specified Location
	 * 
	 * @param aLocation the endpoint to be set
	 */
	public void setEndpoint(Location aLocation) {
		endpoint = aLocation;
	}

	/**
	 * Sets the startpoint of a map (the player's initial position) based on a
	 * specified Location
	 * 
	 * @param aLocation the startpoint to be set
	 */
	public void setStartpoint(Location aLocation) {
		startpoint = aLocation;
	}

	/**
	 * Adds a given enemy to the ArrayList of enemies
	 * 
	 * @param anEnemy the enemy to be added to the ArrayList of enemies
	 */
	public void addEnemy(Enemy anEnemy) {
		enemyList.add(anEnemy);
	}

	/**
	 * Adds a given item (Collectible) to the ArrayList of collectibles
	 * 
	 * @param item the collectible to be added to the Arraylist of collectibles
	 */
	public void addItem(Collectible item) {
		itemList.add(item);
	}

	/**
	 * Adds a door at the given location to the list of doors
	 * 
	 * @param aLocation the location where a door is to be added
	 */
	public void addDoor(Location aLocation) {
		doors.add(aLocation);
	}

	/**
	 * Gets the endpoint of the map
	 * 
	 * @return the endpoint of the map
	 */
	public Location getEndpoint() {
		return endpoint;
	}

	/**
	 * Gets the starting position of the player character
	 * 
	 * @return the starting point of the map
	 */
	public Location getStartpoint() {
		return startpoint;
	}

	/**
	 * Gets the list of enemies loaded into the data
	 * 
	 * @return the list of enemies contained in data
	 */
	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}

	/**
	 * Gets the list of collectibles loaded into the data
	 * 
	 * @return the list of collectibles contained in data
	 */
	public ArrayList<Collectible> getItemList() {
		return itemList;
	}

	/**
	 * Gets the list of doors loaded into the data
	 * 
	 * @return the list of doors contained in data
	 */
	public ArrayList<Location> getDoors() {
		return doors;
	}
}
