import java.io.*;
import java.util.Scanner;

/**
 * A class representing a map on which a player character can move.
 * Has a 2d char array grid which represents the final grid the player can move on,
 * which includes items, enemies as well as the start and endpoints.
 * Also has a 2d char array originalGrid, which represents the map with only the base
 * tiles.
 */
public class Map {
	
	private char[][] grid;
	private char[][] originalGrid;
	
	/**
	 * Checks whether a given move is valid
	 * @param player the Player that is moving
	 * @param location the current Location of the Player
	 * @param direction the Direction in which the player is moving
	 * @return true if the move is valid, false if otherwise
	 */
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
	
	/**
	 * Checks whether a given Player can move to a certain tile
	 * @param player the Player which is moving
	 * @param location the Location of the tile to be checked
	 * @return true if the player can move over that tile, false if they cannot
	 */
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
	
	/**
	 * Changes the grid based on a player move
	 * @param location the Location of the Player before moving
	 * @param direction the Direction the Player is moving in
	 */
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
	
	/**
	 * Checks the content of a tile at a given Location
	 * @param location the Location to be checked
	 * @return the char representing the tile at that Location
	 */
	public char getTile(Location location) {
		
		return grid[location.getY()][location.getX()];
	}
	
	/**
	 * Checks the base tile at a given Location
	 * @param location
	 * @return the char representing the base tile at the given Location
	 */
	public char getOriginalTile(Location location) {
		return originalGrid[location.getY()][location.getX()];
	}
	
	/**
	 * Changes the tile of a given Location to a given tile
	 * @param location the Location to be changed
	 * @param element the char representing the tile to be changed to
	 */
	public void setTile(Location location, char element) {
		grid[location.getY()][location.getX()] = element;
	}
	
	/**
	 * Copies the contents of a 2d char array in a way that ensures encapsulation
	 * @param aGrid the 2d char array to be copied
	 * @return the copy of the 2d char array
	 */
	public char[][] copyGrid(char[][] aGrid) {
		
		int gridLength = aGrid.length;
		char[][] copy = new char[gridLength][aGrid[0].length];
		for(int i = 0; i < gridLength; i++) {
			System.arraycopy(aGrid[i], 0, copy[0], 0, aGrid[0].length);
		}
		
		return copy;
	}
	
	/**
	 * Prints the grid to console
	 */
	public void printMap() {
		
		for(int i = 0; i < grid.length; i++) {
			System.out.println(grid[i]);
		}
	}
	
	/**
	 * Gets the grid of Map
	 * @return grid, the 2d char array representing the Map
	 */
	public char[][] getGrid(){
		
		return grid;
	}
	
	/**
	 * Sets the grid based using another 2d char array
	 * @param aGrid the 2d char array which grid is to be set to
	 */
	public void setGrid(char[][] aGrid) {
		grid = aGrid;
	}
	
	/**
	 * Takes a file name and sets the grid based on the contents of the file
	 * @param filename the name of the file from which grid will be set based on its contents
	 * @throws FileNotFoundException if the given file cannot be found
	 */
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
				originalGrid = copyGrid(grid);
				scan1.close();
				scan2.close();
		}
}
