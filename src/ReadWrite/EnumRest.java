package ReadWrite;

/**
 * EnumRest is an enum class that consists of every different type of restaurant provided in menu.csv and is 
 * mainly used to support the classes graph.CreateGraph and ReadWrite.read.
 * 
 * @author Stephanus Jonatan
 */
public enum EnumRest {
	MCDONALDS("McDonalds", "McDonald’s", 0),
	BURGERKING("BurgerKing", "Burger King", 1),
	WENDYS("Wendy's", "Wendy’s", 2);
	
	String Restaurant = "";
	String menu = "";
	int index;
	EnumRest(String rest, String menu, int ind) {
		this.Restaurant = rest;
		this.menu = menu;
		this.index = ind;
	}
	
	/**
	 * Returns the associated restaurant name as it appears in burgerking.csv, mcdonalds.csv, or wendys.csv
	 * 
	 * @return this.Restaurant - returns the associated restaurant name as it appears in burgerking.csv, mcdonalds.csv, or wendys.csv
	 */
	public String getRestaurant() {
		return this.Restaurant;
	}
	
	/**
	 * Returns the associated restaurant name as it appears in menu.csv
	 * 
	 * @return this.menu - returns the associated restaurant name as it appears in menu.csv
	 */
	public String getMenu() {
		return this.menu;
	}
	
	/**
	 * Returns the associated index number
	 * 
	 * @return this.index - returns the associated index number
	 */
	public int getIndex() {
		return this.index;
	}
}


