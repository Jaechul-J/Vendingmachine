package vendingmachine;
public class CoinBox {
 /*
  * TODO: Define fields that count the deposited coins.	
  */
	private int numQuarter;
	private int numDime;
	private int numNickel;
  

  /*
   * TODO: Define a zero-parameter constructor 
   * that initializes the deposited coins.
   */    
	public CoinBox() {
		numQuarter = 0;
		numDime = 0;
		numNickel = 0;
	}
  
  /*
   * TODO: Define methods for depositing coins.
   * Define a separate method for each coin type. 
   */
	public void incQuarter() {
		numQuarter++;
	}
	
	public void incDime() {
		numDime++;
	}
	
	public void incNickel() {
		numNickel++;
	}

  /*
   * TODO: Define methods for returning the deposited
   * coins. Define a separate method for each coin type.
   * @return deposited coins of a particular type
   */  
	public int retQuarter() {
		return this.numQuarter;
	}
	
	public int retDime() {
		return this.numDime;
	}
	
	public int retNickel() {
		return this.numNickel;
	}

  /*
   * TODO: Define, for each coin type, a method that 
   * sets a new value for that coin type.
   * @param The new number of coins for a given coin type
   */  
	public void setQuarter(int num) {
		this.numQuarter = num;
	}
	
	public void setDime(int num) {
		this.numDime = num;
	}
	
	public void setNickel(int num) {
		this.numNickel = num;
	}
  
 
  /*
   * TODO: Define a method for transferring coins from a
   * coin box to another coin box.
   * Note that one of the coin boxes receives the deposited coins 
   * from users. The other coin box provides change to users.
   * @param A coin box that provides change to users. 
   */ 
	public void transfer (CoinBox second) {
		second.numQuarter += this.numQuarter;
		second.numDime += this.numDime;
		second.numNickel += this.numNickel;
		this.numQuarter = 0;
		this.numDime = 0;
		this.numNickel = 0;
	}
	
	public int totalCoin() {
		return (25*this.numQuarter) + (10*this.numDime) + (5*this.numNickel);
	}
	
}
