import java.util.Scanner;

public class Menu {
	
	Scanner scan = new Scanner (System.in);
	private RestaurantList restaurants = new RestaurantList();
	
	public void mainMenu() {
		
		boolean loop = true;
		do {
			
		System.out.println("RESTAURANT FINDER");
		System.out.println();
		System.out.println("Please select a search option:");
		System.out.println("1. Search by cuisine type");
		System.out.println("2. Search by price");
		System.out.println("3. Search my favourites");
		System.out.println("4. Stop");
		
		int input = scan.nextInt();
		
		switch(input) {
		
		case 1:
			this.cuisineMenu();
			break;
		
		case 2:
			this.priceMenu();
			break;
			
		case 3:
			this.favouritesMenu();
		
		case 4:
			loop = false;
			break;
			
		default: 
			System.out.println("Please enter a number corresponding to the menu options \n");
		}
		} while(loop == true);
	}
	
	public void cuisineMenu() {
	
		boolean loop = true;
		
		do {
		System.out.println("Please select your cuisine type:");
		System.out.println();
		System.out.println("1.Pizza");
		System.out.println("2.Burgers");
		System.out.println("3.Sushi");
		System.out.println("4. Go back to main menu");
		
		int input = scan.nextInt();
		
		switch(input) {
		case 1:
			restaurants.searchCuisine("PIZZA");
			break;
		case 2:
			restaurants.searchCuisine("BURGERS");
			break;
		case 3:
			restaurants.searchCuisine("SUSHI");
			break;
		case 4:
			this.mainMenu();
			break;
		default: 
			System.out.println("Please enter a number corresponding to the menu options \n");
		}	
		} while (loop == true);
	}
	
	public void priceMenu() {
		
		System.out.println("Please select your preferred price range:");
		System.out.println();
		System.out.println("1.$");
		System.out.println("2.$$");
		System.out.println("3.$$$");
		System.out.println("4.$$$$");
		System.out.println("5.$$$$$");
		System.out.println("6. Go back to main menu");
		
		int input = scan.nextInt();
		
		switch(input) {
		case 1:
			restaurants.searchPrice(1);
			break;
		case 2:
			restaurants.searchPrice(2);
			break;
		case 3:
			restaurants.searchPrice(3);
			break;
		case 4:
			restaurants.searchPrice(4);
			break;
		case 5:
			restaurants.searchPrice(5);
			break;
		case 6:
			this.mainMenu();
			break;
		default: 
			System.out.println("Please enter a number corresponding to the menu options \n");
		}	
	}
	
	public void favouritesMenu() {
		restaurants.searchFavourites();
	}
	
	public static void main(String[] args) {

		Menu m = new Menu();

		Restaurant a = new Restaurant("Mcdonalds", "BURGERS", 1);
		Restaurant b = new Restaurant("Bob's Burgers", "BURGERS", 2);
		Restaurant c = new Restaurant("Oishi Sushi", "SUSHI", 3);
		Restaurant d = new Restaurant("Pepehands Pizza", "PIZZA", 5);
		
		m.restaurants.addRestaurant(a);
		m.restaurants.addRestaurant(b);
		m.restaurants.addRestaurant(c);
		m.restaurants.addRestaurant(d);
		m.mainMenu();
	}
}
