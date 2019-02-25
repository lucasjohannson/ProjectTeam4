import java.util.ArrayList;

public class RestaurantList {

	private ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();

	public void addRestaurant(Restaurant newRestaurant) {
		restaurantList.add(newRestaurant);
	}
	
	public void searchCuisine(String s) {
		
		for (int i = 0; i < restaurantList.size(); i++){
			if(restaurantList.get(i).getCuisine() == s) {
				System.out.println(restaurantList.get(i).toString());
			}
		}
	}
	
	public void searchPrice(int price) {
		
		for (int i = 0; i < restaurantList.size(); i++){
			if(restaurantList.get(i).getPrice() == price) {
				System.out.println(restaurantList.get(i).toString());
			}
		}
	}
	
	public void searchFavourites() {
		
		for (int i = 0; i < restaurantList.size(); i++){
			if(restaurantList.get(i).getFavourites() == true) {
				System.out.println(restaurantList.get(i).toString());
			}

		}
	}
}
