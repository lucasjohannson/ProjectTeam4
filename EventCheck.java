import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class EventCheck {
	
	private Location startpoint;
	private Location endpoint;
	private ArrayList<Enemy> enemyList;
	private ArrayList<Collectible> itemList;
	private ArrayList<Location> doors;
	
	public void setInitialization(String filename) {
		
		try {
			Scanner scan1 = new Scanner(new BufferedReader(new FileReader(filename)));
			int ctr = 1;
			int length = scan1.nextLine().length();
			while(scan1.hasNextLine()) {
				ctr = ctr + 1;
				scan1.nextLine();
			}
			
			Scanner scan2 = new Scanner(new BufferedReader(new FileReader(filename)));
			
			for (int i = 0; i < ctr; i++) {
				String line = scan2.nextLine();
				
				switch(line.charAt(0)) {
					
				case 'o':
					if(line.charAt(1) == 'p') {
						Potion p = new Potion("Potion", Character.getNumericValue(line.charAt(2)),Character.getNumericValue(line.charAt(3)), 20);
						itemList.add(p);
					}
					if(line.charAt(1) == 'w') {
						Weapon w = new Weapon("Sword", Character.getNumericValue(line.charAt(2)),Character.getNumericValue(line.charAt(3)), 2);
						itemList.add(w);
						}
					if(line.charAt(1) == 's') {
						Shoe s = new Shoe("Flipper", Character.getNumericValue(line.charAt(2)),Character.getNumericValue(line.charAt(3)), '~');
						itemList.add(s);
					}
					if(line.charAt(1) == 'k') {
						Key k = new Key("Key", Character.getNumericValue(line.charAt(2)),Character.getNumericValue(line.charAt(3)), 'D');
						itemList.add(k);
					}
					break;
						
				case 'E':
					if(line.charAt(1) == 'n') {
						Enemy n = new Enemy("Fodder", Character.getNumericValue(line.charAt(2)),Character.getNumericValue(line.charAt(3)), 2, 20);
						enemyList.add(n);
					}
					if(line.charAt(1) == 'b') {
							Enemy b = new Enemy("Boss", Character.getNumericValue(line.charAt(2)),Character.getNumericValue(line.charAt(3)), 5, 40);
							enemyList.add(b);
					}
					break;
						
				case 'P':
					int xCoord = Character.getNumericValue(line.charAt(1));
					int yCoord = Character.getNumericValue(line.charAt(2));
					Location start = new Location(xCoord, yCoord);
					setStartpoint(start);
					break;
						
				case '@':
					int xCoord2 = Character.getNumericValue(line.charAt(1));
					int yCoord2 = Character.getNumericValue(line.charAt(2));
					Location end = new Location(xCoord2, yCoord2);
					setEndpoint(end);
					break;
					
				case 'D':
					int xCoord3 = Character.getNumericValue(line.charAt(1));
					int yCoord3 = Character.getNumericValue(line.charAt(2));
					Location door = new Location(xCoord3, yCoord3);
					addDoor(door);
					break;
				}
			}
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File could not be found");
		}
	}
	
	public void initializeMap(Map aMap) {
		
		for(Collectible item:itemList) {
			item.placeToken(aMap);
		}
		for(Enemy e:enemyList) {
			e.placeToken(aMap);
		}
		for(Location d:doors) {
			aMap.setTile(d, 'D');
		}
		aMap.setTile(getEndpoint(), '@');
		aMap.setTile(getStartpoint(), 'P');
	}
	
	public void initializePlayer(Player aPlayer) {
		aPlayer.setLocation(getStartpoint());
	}
	
	public void setEndpoint(Location aLocation) {
		endpoint = aLocation;
	}
	
	public void setStartpoint(Location aLocation) {
		startpoint = aLocation;
	}
	
	public void addEnemyList(Enemy anEnemy) {
		enemyList.add(anEnemy);
	}
	
	public void addItemList(Collectible item) {
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
}
