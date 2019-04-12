import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A text application for the game that can be run on console. Contains GameLogic through 
 * which the game runs, and a Scanner for user input
 */
public class TextApp {
	
	Scanner scan = new Scanner (System.in);
	private GameLogic logic = new GameLogic();
	
	/**
	 * A method which creates the main menu and its interactions in the console
	 */
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
	
	/**
	 * Creates the menu where the user can specify text file inputs to load maps
	 */
	public void changeMap() {
		
		System.out.println("Please enter the name of the text file which contains your desired map:");
		
		String input1 = scan.next();
		
		try {
			logic.map.setGrid(input1);
			System.out.println("The text file you entered was " + input1);
			System.out.println();
			System.out.println("Would you like to play using this map?");
			logic.map.printMap();
			System.out.println("Press Y to play using this map or press N if you would like to specify another map");
			System.out.println("Press Q to exit to the main menu");
			String input2 = scan.next();
			
			switch(input2) {
			
			case "Y":
				initializeMap();
				break;
			case "N":
				changeMap();
				break;
			case "Q":
				mainMenu();
			default:
				System.out.println("Please choose either Y, N or Q");
				changeMap();
			}
		}
		catch (FileNotFoundException fnfe){
			System.out.println("File not found!");
			changeMap();
		}
		catch (IndexOutOfBoundsException iobe) {
			System.out.println("Please check that your map text file is properly formatted");
		}
	}
	
	/**
	 * Creates the menu where the user can specify an initialization file for a map
	 */
	public void initializeMap() {
		System.out.println();
		System.out.println("Please enter the name of the initialization file for this map:");
		String input = scan.next();
		try {
			logic.data.setInitialization(input);
			logic.data.initializeMap(logic.map);
			logic.data.initializePlayer(logic.player);
		} 
		catch (FileNotFoundException fnfe) {
			System.out.println("The file could not be found");
		}
		catch (IndexOutOfBoundsException iobe) {
			System.out.println("Please check that your initialization file is properly formatted");
		}
		mainMenu();
	}
	
	/**
	 * Creates the main loop through which the game is played
	 */
	public void play() {
		
		if(logic.map.getGrid() == null) {
			try {
				logic.map.setGrid("map1.txt");
				logic.data.setInitialization("ini1.txt");
				logic.data.initializeMap(logic.map);
				logic.data.initializePlayer(logic.player);;
			} 
			catch (FileNotFoundException fnfe) {
				System.out.println("Please check that you have the default files (map1.txt and ini1.txt)");
			}
		}
		
		boolean loop = true;
		
		while(loop) {
			logic.map.printMap();
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

					try {
						logic.moveNorth();
						logic.map.printMap();	
						checkEvent(logic.player.getLocation());
					} 
					catch (IndexOutOfBoundsException iobe) {
						System.out.println("This is not a valid move!");
						System.out.println();
					}
					break;
				case "E":
					try {
						logic.moveEast();
						logic.map.printMap();	
						checkEvent(logic.player.getLocation());
					} 
					catch (IndexOutOfBoundsException iobe) {
						System.out.println("This is not a valid move!");
						System.out.println();
					}
					break;
				case "S":
					try {
						logic.moveSouth();
						logic.map.printMap();	
						checkEvent(logic.player.getLocation());
					} 
					catch (IndexOutOfBoundsException iobe) {
						System.out.println("This is not a valid move!");
						System.out.println();
					}
					break;
				case "W":
					try {
						logic.moveWest();
						logic.map.printMap();	
						checkEvent(logic.player.getLocation());
					} 
					catch (IndexOutOfBoundsException iobe) {
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
	
	/**
	 * Creates the outputs when a player accesses their inventory
	 */
	public void inventory() {
		
		if(logic.player.getItems().size() == 0) {
			System.out.println("You currently have no items!");
		} else {
			
			boolean loop = true;
			
			while(loop) {
				for(int i = 0; i < logic.player.getItems().size();) {
					Collectible currentItem = logic.player.getItems().get(i);
					System.out.println(currentItem.getName());
					System.out.println("Would you like to use this item?");
					System.out.println("Press Y to use this item or press N to go to the next item");
					System.out.println("Press Q to exit your inventory");
					String input = scan.next();
					switch(input) {
					case "Y": 
						currentItem.useItem(logic.player);
						System.out.println(currentItem.toString());
						logic.player.getItems().remove(currentItem);
						play();
						break;
					case "N":
						i++;
						if(i == logic.player.getItems().size()) {
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
	
	/**
	 * Checks if an event occurs at the given Location, then gives a text output
	 * based on the type of event if an event has occurred
	 * @param location the Location to be checked for an event
	 */
	public void checkEvent(Location location) {
		
		if(logic.checkCompletion()) {
			System.out.println("You win!");
			System.out.println("Press any key to return to the main menu");
			String input1 = scan.next();
			
			switch(input1) {
			default:
				mainMenu();
			}
		}
		if(logic.checkEnemy(location)) {
			System.out.println();
			System.out.println("You have encountered an enemy!");
			battle();
		}
		if(logic.checkItem(location)) {
			ArrayList<Collectible> items = logic.player.getItems();
			System.out.println("You have obtained a(n) " + items.get(items.size()-1).getName());
		}
	}
	
	/**
	 * The battle UI for the text application
	 */
	public void battle() {
		
		Enemy toBattle = logic.getEnemy(logic.player.getLocation());
		
		while(logic.player.getHP() > 0 && toBattle.getcurrentHealth() > 0) {
		System.out.println(toBattle.getName() + " HP:" + toBattle.getcurrentHealth()+ "/" + toBattle.getmaxCorHealth());
		System.out.println("Your HP:" + logic.player.getHP() + "/" + logic.player.getMaxHP());
		
		System.out.println("Select A to attack or press R to run!");
		String input = scan.next();
		switch(input) {
		case "A":
			logic.player.attack(toBattle);
			System.out.println("You attacked " + toBattle.getName() + " for " + logic.player.getAttack() + " damage!");
			if(toBattle.getcurrentHealth() >= 0) {
				toBattle.attack(logic.player);
				System.out.println(toBattle.getName() + " attacked you for " + toBattle.getPower() + " damage!");
			}
			break;
		case "R":
			System.out.println("You can't run!");
			toBattle.attack(logic.player);
			System.out.println(toBattle.getName() + " attacked you for " + toBattle.getPower() + " damage!");
		default:
			System.out.println("Please select A or R");
		}
		}
		if(logic.player.getHP() == 0) {
			System.out.println("You have died!");
			System.out.println();
			System.out.println("*************************");
			System.out.println("*                       *");
			System.out.println("*       GAME OVER       *");
			System.out.println("*                       *");
			System.out.println("*************************");
			logic.player.setLocation(logic.data.getStartpoint());
			logic.player.setHP(logic.player.getMaxHP());
			logic.map.setTile(logic.data.getStartpoint(), 'P');
			logic.map.setTile(toBattle.getLocation(), 'E');
			mainMenu();
		}
		if(toBattle.getcurrentHealth() == 0) {
			System.out.println("You have defeated the enemy " + toBattle.getName());
			logic.data.getEnemyList().remove(toBattle);
			play();
		}
	}
	
	public static void main(String[] args) {

		TextApp t = new TextApp();
		
		t.mainMenu();
		
	}
}