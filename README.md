# ProjectTeam4
#Research Restaurant
#1.data base<sorts of restaurant><food type><price><address><hours>
#2.prompt for user imput
#3.Pull out the restaurant imformation.
#4.give output
 
import java.util.ArrayList;

public class Restaurant {
	private String name;
	private boolean favourites;
	private int price;
	private String cuisine;
	
	
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
	
	public void setFavourites (boolean f) {
		this.favourites = f;
	}
	
	public void setPrice (int p) {
		this.price = p;
	}
	
	public void setCuisine (String c) {
		this.cuisine = c;
	}
	
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
	
	  public String toString() {
		return name;
		    
		  }
		
		
}
