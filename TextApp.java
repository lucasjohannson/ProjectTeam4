import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TextApp {
	
	Scanner scan = new Scanner (System.in);
	private Map map = new Map();
	private Player player = new Player();
	private EventCheck eventChecker = new EventCheck();
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private ArrayList<Collectible> collectibleList = new ArrayList<Collectible>();
	private Location endpoint = new Location();
	
	
	public void mainMenu() {
		
		boolean loop = true;
		do {
		System.out.println();
		System.out.println("SOME ADVENTURE GAME");
		System.out.println();
		System.out.println("Please select an option:");
		System.out.println("1. Play game using current map");
		System.out.println("2. Load a map");
		System.out.println("3. Exit");
		
		String input = scan.next();
		
		switch(input) {
		
		case "1":
			play();
			break;
		
		case "2":
			changeMap();
			break;
			
		case "3":
			loop = false;
			break;
			
		default: 
			System.out.println("Please enter a number corresponding to the menu options");
		}
		} while(loop == true);
	}
	
	public void changeMap() {
		
		System.out.println("Please enter the name of the text file which contains your desired map:");
		
		String input1 = scan.next();
		
		try {
			map.setGrid(input1);
			System.out.println("The text file you entered was " + input1);
			System.out.println();
			System.out.println("Would you like to play using this map?");
			map.printMap();
			System.out.println("Press Y to play using this map or press N if you would like to specify another map");
			String input2 = scan.next();
			
			switch(input2) {
			
			case "Y":
				initializeMap();
				break;
			case "N":
				changeMap();
				break;
			default:
				System.out.println("Please choose either Y or N");
				changeMap();
			}
		}
		catch (FileNotFoundException fnfe){
			System.out.println("File not Found!");
			changeMap();
		}
	

	}
	
	public void initializeMap() {
		System.out.println();
		System.out.println("Please enter the name of the initialization file for this map:");
		String input = scan.next();
		try {
			eventChecker.setInitialization(input);
			eventChecker.initializeMap(map);
			player.setLocation(eventChecker.getStartpoint());
			enemyList = eventChecker.getEnemyList();
			collectibleList = eventChecker.getItemList();
			endpoint = eventChecker.getEndpoint();
		} 
		catch (FileNotFoundException e) {
			System.out.println("The File could not be found");
		}
		mainMenu();
	}
	
	public void play() {
		
		if(map.getGrid() == null) {
			System.out.println("Please load a map first!");
			mainMenu();
		}
		
		boolean loop = true;
		while(loop) {
			map.printMap();
			System.out.println();
			System.out.println("Which direction would you like to move?:");
			System.out.println();
			System.out.println("N for North, E for East, S for South, W for West, or press I to use an item.");
			System.out.println("Press M to go back to the main menu");
			
			boolean cont = true;
			
			while(cont) {
				String input = scan.next();
				
				switch(input) {
				
				case "N":

					if(map.isValidMove(player, player.getLocation(), Direction.NORTH)) {
						map.move(player.getLocation(), Direction.NORTH);
						player.setLocation(player.getLocation().getNorth());
						player.setDirection(Direction.NORTH);
						map.printMap();	
						checkEvent(player.getLocation());
					} else {
						System.out.println("This is not a valid move!");
						System.out.println();
					}
					break;
				case "E":
					if(map.isValidMove(player, player.getLocation(), Direction.EAST)) {
						map.move(player.getLocation(), Direction.EAST);
						player.setLocation(player.getLocation().getEast());
						player.setDirection(Direction.EAST);
						map.printMap();	
						checkEvent(player.getLocation());
					} else {
						System.out.println("This is not a valid move!");
						System.out.println();
					}
					break;
				case "S":
					if(map.isValidMove(player, player.getLocation(), Direction.SOUTH)) {
						map.move(player.getLocation(), Direction.SOUTH);
						player.setLocation(player.getLocation().getSouth());
						player.setDirection(Direction.SOUTH);
						map.printMap();	
						checkEvent(player.getLocation());
					} else {
						System.out.println("This is not a valid move!");
						System.out.println();
					}
					break;
				case "W":
					if(map.isValidMove(player, player.getLocation(), Direction.WEST)) {
						map.move(player.getLocation(), Direction.WEST);
						player.setLocation(player.getLocation().getWest());
						player.setDirection(Direction.WEST);
						map.printMap();	
						checkEvent(player.getLocation());
					} else {
						System.out.println("This is not a valid move!");
						System.out.println();
					}
					break;
				case "I":
					inventory();
					break;
				case "M":
					cont = false;
					mainMenu();
				default:
					System.out.println("Please enter a valid option");
				}
			}
		}	
	}
	
	public void inventory() {
		
		if(player.getItems().size() == 0) {
			System.out.println("You currently have no items!");
		} else {
			
			boolean loop = true;
			
			while(loop) {
				for(int i = 0; i < player.getItems().size();) {
					Collectible currentItem = player.getItems().get(i);
					System.out.println(currentItem.getName());
					System.out.println("Would you like to use this item?");
					System.out.println("Press Y to use this item or press N to go to the next item");
					System.out.println("Press Q to exit your inventory");
					String input = scan.next();
					switch(input) {
					case "Y": 
						currentItem.useItem(player);
						System.out.println(currentItem.toString());
						player.getItems().remove(currentItem);
						play();
						break;
					case "N":
						i++;
						if(i == player.getItems().size()) {
							System.out.println("No more items in inventory");
							loop = false;
							play();
						}
						break;
					case "Q":
						loop = false;
						play();
						break;
					default:
						System.out.println("Please enter a valid option");
					}
				}
			}
		}
	}
	
	public void checkEvent(Location location) {
		
		checkEnemy(location);
		checkItem(location);
		checkCompletion(location);
	}
	
	public void checkEnemy(Location location) {
		
		
	}
	
	public void checkItem(Location location) {
		if(collectibleList.size() > 0) {
			for(int i = 0; i < collectibleList.size();) {
				if(collectibleList.get(i).getLocation().isEqual(location)) {
					player.getItems().add(collectibleList.get(i));
					System.out.println("You have acquired a " + collectibleList.get(i).getName());
					collectibleList.remove(i);
				} else {
					i++;
				}
			}
		} else {
			
		}
	}
	
	public void checkCompletion(Location location) {
		if(location.isEqual(endpoint)) {
			System.out.println("You win!");
			System.out.println("Would you like to play another map? Y/N");
			String input1 = scan.next();
			
			switch(input1) {
			case "Y":
				changeMap();
				break;
			case "N":
				mainMenu();
				break;
			default:
				System.out.println("Invalid input");
			}
		}
	}
	
	public void setEndpoint(int x, int y) {
		endpoint.setX(x);
		endpoint.setY(y);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void addItem(Collectible item) {
		collectibleList.add(item);
	}
	
	public static void main(String[] args) {

		TextApp t = new TextApp();
		
		t.mainMenu();
		
	}
}