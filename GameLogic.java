
public class GameLogic {
	/**
	 * A class which deals with the logic of the game, containing a Player, a Map which the Player
	 * moves on and GameData which contains the data for the game(enemy data, item data, startpoint
	 * and endpoint)
	 */
	protected Player player = new Player();
	protected Map map = new Map();
	protected GameData data = new GameData();
	
	/**
	 * Moves the Player North
	 */
	public void moveNorth throws IndexOutOfBoundsException() {
		if(map.isValidMove(player, player.getLocation(), Direction.NORTH)) {
			map.move(player.getLocation(), Direction.NORTH);
			player.setLocation(player.getLocation().getNorth());
			player.setDirection(Direction.NORTH);
		}
	}
	
	/**
	 * Moves the Player East
	 */
	public void moveEast throws IndexOutOfBoundsException() {
		if(map.isValidMove(player, player.getLocation(), Direction.EAST)) {
			map.move(player.getLocation(), Direction.EAST);
			player.setLocation(player.getLocation().getEast());
			player.setDirection(Direction.EAST);
		}
	}
	
	/**
	 * Moves the Player West
	 */
	public void moveWest throws IndexOutOfBoundsException() {
		if(map.isValidMove(player, player.getLocation(), Direction.WEST)) {
			map.move(player.getLocation(), Direction.WEST);
			player.setLocation(player.getLocation().getWest());
			player.setDirection(Direction.WEST);
		}
	}
	
	/**
	 * Moves the Player South
	 */
	public void moveSouth throws IndexOutOfBoundsException() {
		if(map.isValidMove(player, player.getLocation(), Direction.SOUTH)) {
			map.move(player.getLocation(), Direction.SOUTH);
			player.setLocation(player.getLocation().getSouth());
			player.setDirection(Direction.SOUTH);
		}
	}
	
	/**
	 * Checks whether an item(Collectbile) is present at the given Location
	 * @param location the Location to be checked for an item
	 * @return true if there is an item at the given Location, false if
	 * it does not
	 */
	public boolean checkItem(Location location) {
		boolean hasItem = false;
		if(data.getItemList().size() > 0) {
			for(int i = 0; i < data.getItemList().size();) {
				if(data.getItemList().get(i).getLocation().isEqual(location)) {
					player.getItems().add(data.getItemList().get(i));
					hasItem = true;
					data.getItemList().remove(i);
					return hasItem;
				} else {
					i++;
				}
			}
		}
		return hasItem;
	}
	
	/**
	 * Checks whether there is an Enemy at the given Location
	 * @param location the Location to be checked for an enemy
	 * @return true if there is an item at the given Location, false if
	 * it does not
	 */
	public boolean checkEnemy(Location location) {
		boolean hasEnemy = false;
		if(data.getEnemyList().size() > 0) {
			for(int i = 0; i < data.getEnemyList().size();) {
				if(data.getEnemyList().get(i).getLocation().isEqual(location)) {
					hasEnemy = true;
					return hasEnemy;
				} else {
					i++;
				}
			}
		}
		return hasEnemy;
	}
	
	/**
	 * Returns the Enemy situated at a specified Location, if there is one
	 * @param location the Location to be checked for the enemy
	 * @return the Enemy at the Location specified
	 */
	public Enemy getEnemy(Location location) {
		Enemy enemy = new Enemy();
		if(data.getEnemyList().size() > 0) {
			for(int i = 0; i < data.getEnemyList().size();) {
				if(data.getEnemyList().get(i).getLocation().isEqual(location)) {
					return data.getEnemyList().get(i);
				} else {
					i++;
				}
			}
		}
		return enemy;
	}
	
	/**
	 * Checks whether the player is located at the endpoint of the map
	 * @return true if the player is at the endpoint, false if otherwise
	 */

	public boolean checkCompletion() {
		boolean complete = false;
		if(player.getLocation().isEqual(data.getEndpoint())) {
			complete = true;
		}
		return complete;
	}
	
	/**
	 * Gets the Map
	 * @return the map that GameLogic is working with
	 */
	public Map getMap() {
		return map;
	}
	
	/**
	 * Gets the Player
	 * @return the player GameLogic is working with
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Gets the GameData
	 * @return the GameData which GameLogic is working with
	 */
	public GameData getGameData() {
		return data;
	}
}


