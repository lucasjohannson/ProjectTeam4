import java.io.*;
import java.util.Scanner;

public class Map {
	
	private char[][] grid;
	private char[][] baseGrid;
	
	public boolean isValidMove(Location location, Direction direction) {
		
		switch(direction) {
		
		case NORTH:
			if(location.getNorth().getY() >= 0) {
			return isMoveableTerrain(location.getNorth());
			} else {
				return false;
			}
		case EAST:
			if(location.getEast().getX() <= grid[location.getY()].length) {
			return isMoveableTerrain(location.getEast());
			} else {
				return false;
			}
		case SOUTH:
			if(location.getSouth().getY() <= grid.length) {
			return isMoveableTerrain(location.getSouth());
			} else {
				return false;
			}
		case WEST:
			if(location.getWest().getX() >= 0) {
			return isMoveableTerrain(location.getWest());
			} else {
				return false;
			}
		default:
			return false;
		}
	}
	
	public boolean isMoveableTerrain(Location location) {
		
		char tile = getTile(location);
		boolean canMove = true;
		
		switch(tile) {
		
			case 69: //E
				canMove = true;
				break;
			case 64: //@
				canMove = true;
				break;
			case 46: //.
				canMove = true;
				break;
			case 35: //#
				canMove = false;
				break;
			case 68: //D
				canMove = false;
				break;
			case 111: //o
				canMove = true;
				break;
			//case 126: //~
				//if (player.hasItem(Flipper) {
				//return true;
				//} else {
				//	return false;
				//}	
			default: 
				canMove = false;
			}
		return canMove;
	}
	
	public void move(Location location, Direction direction) {

			switch(direction) {
			
			case NORTH:
				Location north = new Location(location.getNorth());
				grid[location.getY()][location.getX()] = '.';
				grid[north.getY()][north.getX()] = 'P';
				break;
			case EAST:
				Location east = new Location(location.getEast());
				grid[location.getY()][location.getX()] = '.';
				grid[east.getY()][east.getX()] = 'P';
				break;
			case SOUTH:
				Location south = new Location(location.getSouth());
				grid[location.getY()][location.getX()] = '.';
				grid[south.getY()][south.getX()] = 'P';
				break;
			case WEST:
				Location west = new Location(location.getWest());
				grid[location.getY()][location.getX()] = '.';
				grid[west.getY()][west.getX()] = 'P';
				break;
			}
	}
	
	public char getTile(Location location) {
		
		return grid[location.getY()][location.getX()];
	}
	
	public void setTile(Location location, char element) {
		grid[location.getY()][location.getX()] = element;
	}
	
	public char[][] copyGrid(char[][] aGrid) {
		
		int gridLength = aGrid.length;
		char[][] copy = new char[gridLength][aGrid[0].length];
		for(int i = 0; i < gridLength; i++) {
			System.arraycopy(aGrid[i], 0, copy[0], 0, aGrid[0].length);
		}
		
		return copy;
	}
	
	public void printMap() {
		
		for(int i = 0; i < grid.length; i++) {
			System.out.println(grid[i]);
		}
	}
	
	public char[][] getGrid(){
		
		return grid;
	}
	
	public void setGrid(char[][] aGrid) {
		grid = aGrid;
	}
	
	public void setGrid(String filename) {
			
			try {
				Scanner scan1 = new Scanner(new BufferedReader(new FileReader(filename)));
				int ctr = 1;
				int length = scan1.nextLine().length();
				while(scan1.hasNextLine()) {
					ctr = ctr + 1;
					scan1.nextLine();
				}
				
				Scanner scan2 = new Scanner(new BufferedReader(new FileReader(filename)));
				
				char[][] fromText = new char[ctr][length];
				
				for (int i = 0; i < ctr; i++) {
					String line = scan2.nextLine();
					for (int j = 0; j < line.length(); j++) {
						fromText[i][j] = line.charAt(j);
					}
				}
				setGrid(fromText);
			}
			catch(FileNotFoundException e) {
				System.out.println("File could not be found");
			}
	}
}