import java.util.ArrayList;
public class Player{
  
  private static int maxHP = 100;
  private int currentHP = 100;
  private int attack = 1;
  private ArrayList<Collectible> items = new ArrayList<>();
  private ArrayList<Character> moveableTile = new ArrayList<>();
  private Location location; 
  private Direction direction = Direction.SOUTH;
  
  public Player() {
	  setLocation(0,0);
  }
  
  public Player(int hp, int att) {
	  maxHP = hp;
	  setHP(maxHP);
	  setAttack(att);
	  moveableTile.add('.');
	  moveableTile.add('E');
	  moveableTile.add('o');
	  moveableTile.add('@');
  }
  
  public Player(Player toCopy) {
	  maxHP = toCopy.getMaxHP();
	  setHP(toCopy.getHP());
	  setAttack(toCopy.getAttack());
	  setLocation(toCopy.getLocation());
  }
  public attackType(Enemy enemy){
	if (enemy.getcurrentHealth() >= 0){
	int a = enemy.getcurrentHealth() - getAttack();
	}
	return a			
  }
	
public attacktoString() {
	return "You attacked with a " + player.items.getweapon() + ". Enemy health decreased to " + enemy.getcurrenthealth() ;


}
  public boolean hasItem(Collectible collectible){
	  boolean hasItem = false;
	  if (items.size() > 0 && items.contains(collectible)) {
		  hasItem = true;
    } 
    return hasItem;
  }
  
  public ArrayList<Collectible> getItems() {
	  
	  return items;
  }
  
  public void setLocation(Location location) {
	  
	  Location l1 = new Location(location);
	  this.location = l1;
  }
  
  public void setLocation(int x, int y) {
	  Location l1 = new Location(x, y);
	  setLocation(l1);
  }
  
  public void setAttack(int att) {
	  if(att >= 0) {
		  attack = att;
	  } else {
		  attack = 1;
	  }
  }
  
  public void setDirection(Direction dir) {
	  direction = dir;
  }
  
  public void setHP(int health) {
	  currentHP = health;
  }
  
  public void addTile(char tile) {
	  moveableTile.add(tile);
  }	
	  
  public void addItem(Collectible item) {
	  items.add(item);
  }
  
  public Location getLocation() {
	  
	  Location l1 = new Location(location);
	  return l1;
  }
  
  public int getMaxHP() {
	  return maxHP;
  }
  
  public int getHP() {
	  return currentHP;
  }
  
  public Direction getDirection() {
	  return direction;
  }
	
	
  public int getAttack() {
	  return attack;
  }
	
  public ArrayList<Character> getTiles() {
	  return moveableTile;
  }
	
	

}


