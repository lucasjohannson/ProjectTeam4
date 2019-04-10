import java.io.*;
import java.util.Scanner;

public class Map {
	
	private char[][] grid;
	private char[][] baseGrid;
	
	public boolean isValidMove(Player player, Location location, Direction direction) {
		
		switch(direction) {
		
		case NORTH:
			if(location.getNorth().getY() >= 0) {
			return isMoveableTerrain(player, location.getNorth());
			} else {
				return false;
			}
		case EAST:
			if(location.getEast().getX() <= grid[location.getY()].length) {
			return isMoveableTerrain(player, location.getEast());
			} else {
				return false;
			}
		case SOUTH:
			if(location.getSouth().getY() <= grid.length) {
			return isMoveableTerrain(player, location.getSouth());
			} else {
				return false;
			}
		case WEST:
			if(location.getWest().getX() >= 0) {
			return isMoveableTerrain(player, location.getWest());
			} else {
				return false;
			}
		default:
			return false;
		}
	}
	
	public boolean isMoveableTerrain(Player player, Location location) {
		
		char tile = getTile(location);
		boolean canMove = false;
		
		for(char moveableTiles:player.getTiles()) {
			if (moveableTiles == tile) {
				canMove = true;
			}
		}
		return canMove;
	}
	
	public void move(Location location, Direction direction) {

			switch(direction) {
			
			case NORTH:
				setTile(location, getOriginalTile(location));
				setTile(location.getNorth(), 'P');
				break;
			case EAST:
				setTile(location, getOriginalTile(location));
				setTile(location.getEast(), 'P');
				break;
			case SOUTH:
				setTile(location, getOriginalTile(location));
				setTile(location.getSouth(), 'P');
				break;
			case WEST:
				setTile(location, getOriginalTile(location));
				setTile(location.getWest(), 'P');
				break;
			}
	}
	
	public char getTile(Location location) {
		
		return grid[location.getY()][location.getX()];
	}
	
	public char getOriginalTile(Location location) {
		return baseGrid[location.getY()][location.getX()];
	}
	
	public void setTile(Location location, char element) {
		grid[location.getY()][location.getX()] = element;
	}
	
	public char[][] copyGrid(char[][] aGrid) {
		
		int gridLength = aGrid[0].length;
		int gridHeight = aGrid.length;
		char[][] copy = new char[gridHeight][gridLength];
		for(int i = 0; i < gridHeight; i++) {
			for(int j = 0; j < gridLength; j++) {
				copy[i][j] = aGrid[i][j];
			}
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
	
	public void setGrid(String filename) throws FileNotFoundException {
			
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
				baseGrid = copyGrid(grid);
				scan1.close();
				scan2.close();
		}
}
