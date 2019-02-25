
public class Restaurant {
	
	private String name;
	private boolean favourites = false;
	private int price;
	private String cuisine;
	
	public Restaurant (String name) {
		this.name = name;
	}

	public Restaurant (String name, String cuisine) {
		this.name = name;
		this.cuisine = cuisine;
	}

	public Restaurant (String name, String cuisine, int price) {
		this.name = name;
		this.cuisine = cuisine;
		this.price = price; 
		
	}

	public Restaurant(Restaurant toCopy) {
		this.name = toCopy.name;
		this.favourites = toCopy.favourites;
		this.cuisine = toCopy.cuisine;
		this.price = toCopy.price;
	}
	
	//GETTER
	public String getName() {
		return this.name;
	}

	public boolean getFavourites() {
		return this.favourites;
	}

	public int getPrice() {
		return this.price;
	}

	public String getCuisine() {
		return this.cuisine;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void addFavourites () {
		this.favourites = true;
	}

	public void setPrice (int p) {
		this.price = p;
	}

	public void setCuisine (String c) {
		this.cuisine = c;
	}

	public String toString() {
		return name + ", Price: + price + , " + cuisine + " restaurant";	    
	}
}
