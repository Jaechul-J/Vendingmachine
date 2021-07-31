package vendingmachine;
public class Stockpile {
	
    /*
     * Declare fields that count sodas and specify
     * the price and ID of sodas.
     */
	private int quantity;
	private double price;
	private int ID;
	
    
	
	public Stockpile() {
		quantity = 0;
		price = 0.0;
		ID = 0;
	}
	/*
	 * TODO: Define a three-parameter constructor that
	 * initializes information about sodas as mentioned above. 
	 */
	
	public Stockpile(int quantity, double price, int ID) {
		this.quantity = quantity;
		this.price = price;
		this.ID = ID;
	}
	
	/*
	 *  TODO: Define a method that updates the available 
	 *  number of sodas after a successful purchase.
	 */
	public void updateQ() {
		this.quantity--;
	}
	

	/* 
	 *  TODO: Define a method that indicates whether stockpile 
	 *  runs out of soda.
	 *  @return Whether or not stockpile runs out of soda 
	 */
	public boolean checkEmpty() {
		return this.quantity == 0;
	}
	
	/*
	 * TODO: Define a method that provides the quantity of soda.
	 * @return The quantity of soda
	 */	
	public int retQuantity() {
		return this.quantity;
	}
	
	/*
	 * TODO: Define a method that provides the price of soda.
	 * @return The price of soda
	 */	
	public double retPrice() {
		return this.price;
	}

	/*
	 * TODO: Define a method that provides the ID of soda.
	 * @return The ID of soda
	 */	
	public int retID() {
		return this.ID;
	}
}
