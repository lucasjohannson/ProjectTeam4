import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GameData {

	private Location startpoint = new Location(0, 0);
	private Location endpoint = new Location(0, 0);
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private ArrayList<Collectible> itemList = new ArrayList<Collectible>();
	private ArrayList<Location> doors = new ArrayList<Location>();
	private int playerAttack = 2;
	private int playerHP = 100;

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

	public void initializePlayer(Player aPlayer) {
		aPlayer.setLocation(getStartpoint());
		aPlayer.setAttack(playerAttack);
		aPlayer.setMaxHP(playerHP);
	}

	public void setEndpoint(Location aLocation) {
		endpoint = aLocation;
	}

	public void setStartpoint(Location aLocation) {
		startpoint = aLocation;
	}

	public void addEnemy(Enemy anEnemy) {
		enemyList.add(anEnemy);
	}

	public void addItem(Collectible item) {
		itemList.add(item);
	}

	public void addDoor(Location aLocation) {
		doors.add(aLocation);
	}

	public Location getEndpoint() {
		return endpoint;
	}

	public Location getStartpoint() {
		return startpoint;
	}

	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}

	public ArrayList<Collectible> getItemList() {
		return itemList;
	}

	public ArrayList<Location> getDoors() {
		return doors;
	}
	
	public int getPlayerAttack() {
		return playerAttack;
	}
	
	public int getPlayerHP() {
		return playerHP;
	}
}
