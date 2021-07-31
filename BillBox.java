package vendingmachine;
public class BillBox {

	/* 
	 * TODO: Define a field that counts the deposited bills. 
	 */
	private int numDollar;
	
	
       /*
        * TODO: Define a zero-parameter constructor 
        * for initializing the deposited bills.
        */
	public BillBox() {
		numDollar = 0;
	}
	
	
	/*
	 *  TODO: Define a method that increments
	 *  the deposited bills
	 */
	public void incBill() {
		this.numDollar++;
	}
    
		
	/* 
	 * TODO: Define a method that resets the deposited bills.  
	 */
	public void reset() {
		this.numDollar = 0;
	}
	

	/*
	 * TODO: Define a method that returns the deposited bills
	 * @return the deposited bills 
	 */
	public int retDollar() {
		return this.numDollar;
	}
	
	public int billDeposit() {
		return (100*this.numDollar);
	}
	
}
