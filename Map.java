import java.io.*;
import java.util.Scanner;

public class Map {
	
	private char[][] grid;
	private boolean hasFlipper = false;
	private Player player;
	private int MAX_X_BOUND = 50;
	private int MAX_Y_BOUND = 50;
	
	public boolean isValidMove(Location location, Direction direction) {
		
		switch(direction) {
		
		case NORTH:
			if(player.getLocation().getNorth().getY() >= 0) {
			return isMoveableTerrain(player.getLocation().getNorth());
			} else {
				return false;
			}
		case EAST:
			if(player.getLocation().getEast().getX() <= grid[player.getLocation().getX()].length) {
			return isMoveableTerrain(player.getLocation().getEast());
			} else {
				return false;
			}
		case SOUTH:
			if(player.getLocation().getSouth().getY() <= grid.length) {
			return isMoveableTerrain(player.getLocation().getSouth());
			} else {
				return false;
			}
		case WEST:
			if(player.getLocation().getWest().getX() >= 0) {
			return isMoveableTerrain(player.getLocation().getWest());
			} else {
				return false;
			}
		default:
			return false;
		}
	}
	
	public boolean isMoveableTerrain(Location location) {
		
		char tile = getElement(location);
		
		switch(tile) {
		
		case 46:
			return true;
		case 35:
			return false;
		case 68:
			return false;
		case 69:
			return true;
		case 126:
			if (hasFlipper == true) {
			return true;
			} else {
				return false;
			}	
		default: 
			return false;
		}
	}
	
	public void move(Location location, Direction direction) {
		
		if(isValidMove(location, direction) == true) {
			
			switch(direction) {
			
			case NORTH:
				Location north = new Location(player.getLocation().getNorth());
				grid[player.getLocation().getX()][player.getLocation().getY()] = 46;
				grid[north.getX()][north.getY()] = 80;
				player.setLocation(north);
				break;
			case EAST:
				Location east = new Location(player.getLocation().getEast());
				grid[player.getLocation().getX()][player.getLocation().getY()] = 46;
				grid[east.getX()][east.getY()] = 80;
				player.setLocation(east);
				break;
			case SOUTH:
				Location south = new Location(player.getLocation().getSouth());
				grid[player.getLocation().getX()][player.getLocation().getY()] = 46;
				grid[south.getX()][south.getY()] = 80;
				player.setLocation(south);
				break;
			case WEST:
				Location west = new Location(player.getLocation().getWest());
				grid[player.getLocation().getX()][player.getLocation().getY()] = 46;
				grid[west.getX()][west.getY()] = 80;
				player.setLocation(west);
				break;
			}
		} else {
			System.out.print("This is not a valid move!");
		}
	}
	
	public char getElement(Location location) {
		
		return grid[location.getX()][location.getY()];
	}
	
	public void printMap() {
		
		for(int i = 0; i < grid.length; i++) {
			System.out.println(grid[i]);
		}
	}
	
	public void setGrid(String filename) {
		
		try {
			Scanner scan = new Scanner(new BufferedReader(new FileReader(filename)));
			char[][] fromText = new char[MAX_Y_BOUND][MAX_X_BOUND];
			int counter = 0;
			
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				
				for (int i = 0; i < line.length(); i++) {
					fromText[counter][i] = line.charAt(i);
				}
				counter++;
			}
			scan.close();
			grid = fromText;

		}
		
		catch(FileNotFoundException e) {
			System.out.println("File could not be found");
		}
	}
}
