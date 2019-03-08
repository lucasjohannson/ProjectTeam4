
public class Map {
	
	private char[][] grid;
	private boolean hasFlipper = false;
	private Player player;
	private int MAP_X_BOUND = grid.length;
	private int MAP_Y_BOUND = grid[0].length;
	
	public boolean isValidMove(Location location, Direction direction) {
		
		switch(direction) {
		
		case NORTH:
			if(player.getLocation().getNorth().getY() >= 0) {
			return isMoveableTerrain(player.getLocation().getNorth());
			} else {
				return false;
			}
		case EAST:
			if(player.getLocation().getEast().getX() <= MAP_X_BOUND) {
			return isMoveableTerrain(player.getLocation().getEast());
			} else {
				return false;
			}
		case SOUTH:
			if(player.getLocation().getSouth().getY() <= MAP_Y_BOUND) {
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
				player.setLocation(player.getLocation().getNorth());
				break;
			case EAST:
				player.setLocation(player.getLocation().getEast());
				break;
			case SOUTH:
				player.setLocation(player.getLocation().getSouth());
				break;
			case WEST:
				player.setLocation(player.getLocation().getWest());
				break;
			}
		} else {
			System.out.print("This is not a valid move!");
		}
	}
	
	public char getElement(Location location) {
		
		return grid[location.getX()][location.getY()];
	}
	
	public void setGrid(char[][] aGrid) {
		
		grid = aGrid;
	}
	
	public void printMap() {
		
		for(int i = 0; i < grid.length; i++) {
			System.out.println(grid[i]);
		}
	}
}
