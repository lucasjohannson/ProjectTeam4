
public class GameLogic {

	protected Player player = new Player();
	protected Map map = new Map();
	protected GameData data = new GameData();
	
	public void moveNorth() {
		if(map.isValidMove(player, player.getLocation(), Direction.NORTH)) {
			map.move(player.getLocation(), Direction.NORTH);
			player.setLocation(player.getLocation().getNorth());
			player.setDirection(Direction.NORTH);
		}
	}

	public void moveEast() {
		if(map.isValidMove(player, player.getLocation(), Direction.EAST)) {
			map.move(player.getLocation(), Direction.EAST);
			player.setLocation(player.getLocation().getEast());
			player.setDirection(Direction.EAST);
		}
	}
	
	public void moveWest() {
		if(map.isValidMove(player, player.getLocation(), Direction.WEST)) {
			map.move(player.getLocation(), Direction.WEST);
			player.setLocation(player.getLocation().getWest());
			player.setDirection(Direction.WEST);
		}
	}
	
	public void moveSouth() {
		if(map.isValidMove(player, player.getLocation(), Direction.SOUTH)) {
			map.move(player.getLocation(), Direction.SOUTH);
			player.setLocation(player.getLocation().getSouth());
			player.setDirection(Direction.SOUTH);
		}
	}
	
	public boolean checkItem(Location location) {
		boolean hasItem = false;
		if(data.getItemList().size() > 0) {
			for(int i = 0; i < data.getItemList().size();) {
				if(data.getItemList().get(i).getLocation().isEqual(location)) {
					player.getItems().add(data.getItemList().get(i));
					data.getItemList().remove(i);
					hasItem = true;
				} else {
					i++;
				}
			}
		}
		return hasItem;
	}
	
	public boolean checkEnemy(Location location) {
		boolean hasEnemy = false;
		if(data.getEnemyList().size() > 0) {
			for(int i = 0; i < data.getEnemyList().size();) {
				if(data.getEnemyList().get(i).getLocation().isEqual(location)) {
					hasEnemy = true;
				} else {
					i++;
				}
			}
		}
		return hasEnemy;
	}
	
	public boolean checkCompletion(Location location) {
		boolean complete = false;
		if(player.getLocation().isEqual(location)) {
			complete = true;
		}
		return complete;
	}
		
	public Map getMap() {
		return map;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public GameData getGameData() {
		return data;
	}
}


