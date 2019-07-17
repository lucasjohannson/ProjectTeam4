//http://www.kilobolt.com/day-6-adding-enemies/unit-2-day-6-adding-enemies

public class enemy {
	private int maxCorHealth;
	private int currentHealth;
	private int power;
	private int speed; 
	private int xCor;
	private int yCor;

	//GETTER 
	public int getmaxCorHealth() {
		return this.maxCorHealth;
	}
	
	//GETTER 
	public int getcurrentHealth() {
		return this.currentHealth;
	}
	
	//GETTER 
	public int getpower() {
		return this.power;
	}
	
	//GETTER 
	public int getspeed() {
		return this.speed;
	}
	
	//GETTER 
	public int getxCor() {
		return this.xCor;
	}
	
	//GETTER 
	public int gety() {
		return this.yCor;
	}
	
	
	//SETTER 
	public void setmaxCorHealth(int mh) {
		this.maxCorHealth = mh;		
	}
	
	//SETTER 
	public void setcurrentHealth(int ch) {
		this.currentHealth = ch;	
	}
	
	//SETTER 
	public void setpower(int p) {
		this.power = p;
	}
	
	//SETTER 
	public void setspeed(int s) {
		this.speed = s;
	}
	
	//SETTER 
	public void setxCor(int x) {
		this.xCor = x;
	}
	
	//SETTER 
		public void setyCor(int y) {
			this.yCor = y;
		}
		
	//SETTER
	public void die() {
		if (currentHealth < 0) {
			//
		}
	}
	
	//SETTER
	public void attack() {
		//if ()
		
	}

	
}
