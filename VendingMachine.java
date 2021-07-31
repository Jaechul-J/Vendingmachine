package vendingmachine;
public class VendingMachine {
	
  Stockpile[] stocks; //Array that stores each soda
  /*	
   * TODO: Declare fields that represent the
   * other components of a vending machine as 
   * explained in the assignment description.
   */ 
 CoinBox coinbox;
 CoinBox coinbox2;
 BillBox billbox;
 Display display;
 BeverageReceiver bevRec;
 ChangeReceiver changeRec;
 ChangeLight changeLight;
 
  /*
   * TODO: Define a constructor that initializes
   * the components of the vending machine.
   */
  public VendingMachine() {
	  coinbox = new CoinBox();
	  coinbox2 = new CoinBox();
	  billbox = new BillBox();
	  display = new Display();
	  bevRec = new BeverageReceiver();
	  changeRec = new ChangeReceiver();
	  changeLight = new ChangeLight();
  }

  /*
   * TODO: Define a method that returns stockpiles. 
   * @return Stockpiles
   */  
  public void retStockpiles(Stockpile[] arr) {
	  for (Stockpile soda: arr) {
		  System.out.println(soda.retQuantity() + " " + soda.retPrice() + " " + soda.retID());
	  }
  }

  /*
   * TODO: Define a method that returns a bill box.
   * @return BillBox 
   */  
  public BillBox retBillBox() {
	  return billbox;
  }
  

  /*
   * TODO: Define a method that returns a coin box. 
   * This coin box receives user deposits.
   * @return A CoinBox that receives deposits (coins and bills) from users.   
   */  
  public CoinBox retdepCoinBox() {
	  return coinbox;
  }

  /*
   * TODO: Define a method that returns a coin box.
   * This coin box provides change to users.
   * @return A CoinBox that provides change(coins) to users.
   */  
  public CoinBox retdepCoinBox2() {
	  return coinbox2;
  }
    

  /*
   * TODO: Define a method that returns the display 
   * of the vending machine.
   * @return The Display of vending machine       
   */	 
  public Display retDisplay() {
	  return display;
  }

  /*
   * TODO: Define a method that computes the amount of change to provide to users.
   * To provide the change, this method computes difference 
   * between the user deposit and the soda price.
   * Note that the vending machine provides as much change 
   * as it can to users even if the difference is not paid in full.
   * If the vending machine does not pay the difference in full, 
   * the change light sends a message to users.
   * Note that users receive the change from a change receiver.    
   * @param user deposit (in cents)
   * @param soda price (in cents)
   */ 
  public int amtChange(CoinBox a, Stockpile b) {
	  return billbox.billDeposit() + a.totalCoin() - centPrice(b);
  }
  
  
  /*
   * TODO: Define a method that converts user deposits into cents.
   * @return An amount of cents equivalent to user deposits
   */ 
  public int centDeposit() {
	  return coinbox.totalCoin();
  }

  /*
   * TODO: Define a method that converts the price of a soda in 
   * a stockpile into cents.
   * @return An amount of cents equivalent to soda price
   */ 
  public int centPrice(Stockpile s) {
	  return ((int)(s.retPrice()*100));
  }
}
