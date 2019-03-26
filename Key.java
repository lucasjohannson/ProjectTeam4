
public class Key extends Collectible {
	
	private char unlocks;
	
	public Key(String name, Location location, char unlock) {
		super(name, location);
		setUnlock(unlock);
	}
	
	public Key(String name, int x, int y, char unlock) {
		super(name, x, y);
		setUnlock(unlock);
	}
	
	public void useItem(Player aPlayer) {
		
	}
	
	public boolean canUse(Player aPlayer, Map aMap) {
		boolean useable = false;
		
		switch(aPlayer.getDirection()) {
		
		case NORTH:
			if(unlocks == aMap.getTile(aPlayer.getLocation().getNorth())){
				useable = true;
				break;
			}
		case EAST:
			if(unlocks == aMap.getTile(aPlayer.getLocation().getEast())){
				useable = true;
				break;
			}
		case SOUTH:
			if(unlocks == aMap.getTile(aPlayer.getLocation().getSouth())){
				useable = true;
				break;
			}
		case WEST:
			if(unlocks == aMap.getTile(aPlayer.getLocation().getWest())){
				useable = true;
				break;
			}
		default:
				useable = false;
		}
		
		return useable;	
	}
	
	public void useItem(Player aPlayer, Map aMap) {
		
		if(canUse(aPlayer, aMap)) {
			switch(aPlayer.getDirection()) {
			
			case NORTH:
				aMap.setTile(aPlayer.getLocation().getNorth(), '.');
				break;
			case EAST:
				aMap.setTile(aPlayer.getLocation().getEast(), '.');
				break;
			case SOUTH:
				aMap.setTile(aPlayer.getLocation().getSouth(), '.');
				break;
			case WEST:
				aMap.setTile(aPlayer.getLocation().getWest(), '.');
				break;
			} 
		} else {
			System.out.println("You can't use this here!");
		}
	}
	
	public void setUnlock(char unlock) {
		unlocks = unlock;
	}
	
	public char getUnlock() {
		return unlocks;
	}
}