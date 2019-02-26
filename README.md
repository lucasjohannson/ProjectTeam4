# ProjectTeam4
#Research Restaurant
#1.data base<sorts of restaurant><food type><price><address><hours>
#2.prompt for user imput
#3.Pull out the restaurant imformation.
#4.give output
 
import java.util.ArrayList;

/** A class modeling a yelp style application. Has additional parameters 
* of restaurant name of type string, favourites of type boolean, price of type integer and cuisine of type string.
*/
public class Restaurant {
	private String name;
	private boolean favourites;
	private int price;
	private String cuisine;
	
	/** GETTER 
	 * A method to return the restaurant name 
	 * @return name of the restaurant 
	 */
	public String getName() {
		return this.name;
	}
	
	/** GETTER
	 * A method to return if the restaurant is a favourite as true or false  
	 * @return favourite of restaurant 
	 */
	public boolean getFavourites() {
		return this.favourites;
	}
	
	/** GETTER 
	 * A method to return the price range of the restaurant 
	 * @return price restaurant as an integer 
	 */ 
	public int getPrice() {
		return this.price;
	}
	
	/** GETTER 
	 * A method to return the type of cuisisne of the restaurant 
	 * @return cuisine of restaunrant 
	 */ 
	public String getCuisine() {
		return this.cuisine;
		
	}
	
	/** SETTER
	* A method to set the name of the restaurant 
	* @param string set from restaurant name 
	*/
	public void setName(String n) {
		this.name = n;
	}
	
	/** SETTER
	* A method to set favourite of restaurant 
	* @param boolean value set from restaurant 
	*/
	public void setFavourites (boolean f) {
		this.favourites = f;
	}
	
	/**SETTER
	* A method to set price of restaurant 
	* @param int value set from restaurant 
	public void setPrice (int p) {
		this.price = p;
	}
	
	/**SETTER
	* A method to set cuisine of restaurant 
	* @param string set from restaurant 
	*/
	public void setCuisine (String c) {
		this.cuisine = c;
	}
	
	/** CONSTRUCTOR 
	* @param takes name of restaurant as string 
	*/
	public Restaurant (String name) {
		this.name = name;
	}
	
	/** CONSTRUCTOR
	* @param takes name of restaurant and type of cuisine as string
	*/
	public Restaurant (String name, String cuisine) {
		this.name = name;
		this.cuisine = cuisine;
	}
	
	/** CONSTRUCOR 
	* @param takes name of restaurant and type of cuisine as string and price as an int value
	*/
	public Restaurant (String name, String cuisine, int price) {
		this.name = name;
		this.cuisine = cuisine;
		this.price = price; 
		
	}
	
	/** COPY CONSTRUCTOR 
	*/
	public Restaurant(Restaurant toCopy) {
		this.name = toCopy.name;
		this.favourites = toCopy.favourites;
		this.cuisine = toCopy.cuisine;
		this.price = toCopy.price;
	}
	
	/** TO STRING
	* @return name of restaurant 
	public String toString() {
		return name;
		    
		  }
		
		
}
