package vendingmachine;

import java.util.Iterator;
import java.util.Scanner;

public class VendingMachineTester {
	public static void main(String[] args) {
	  int numStockpiles;
	  /*
	   * TODO: Ask user to enter the number of brands (stockpiles) of soda
	   */
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter the number of stockpiles: ");
       numStockpiles = Integer.valueOf(sc.nextLine()); // Might change
	   Stockpile[ ] stockpileArray = new Stockpile[numStockpiles];        
		
	   /*
	    * TODO: In each iteration, ask user to enter information
	    * about a stockpile. The information are stored in the
	    * variables shown below. 
	    * Note that the user enters the price of soda in dollars 
	    * and cents e.g., 2.50 (2 dollars and 50 cents).  
	    */
	   int numberOfSoda;
	   double priceOfSoda;
	   int sodaID;
	   //Scanner sc2 = new Scanner(System.in); DISCARD ME if one scanner does work!!!
	   for(int i = 0; i < numStockpiles; i++) {
	     System.out.print("Enter the number of sodas: ");
	     numberOfSoda = Integer.valueOf(sc.nextLine());
	     System.out.print("Enter the price of soda: ");        
	     priceOfSoda = Double.valueOf(sc.nextLine());;
	     System.out.print("Enter the ID of soda: ");        
	     sodaID = Integer.valueOf(sc.nextLine());      
	     Stockpile sp = new Stockpile(numberOfSoda, priceOfSoda, sodaID);
	     stockpileArray[i] = sp;
	     System.out.println();
	   }
	   
	    /*
		 * TODO: Create a vending machine using the components listed
		 * in the description of the assignment. 
		 */
	   VendingMachine vm = new VendingMachine();
            		
	   while(true) {
          /*
           * TODO: Ask user if they want to purchase sodas.
           * If they do, then ask user to enter the ID of a desired 
           * stockpile, which will be stored in id shown below.
           * The program terminates if user decides not to
           * purchase sodas. 	
           */
          int id;
          System.out.print("Do you want to purchase soda? ");
          String response = sc.next();
          if(response.equals("yes")) {  
           System.out.print("Enter the ID of stockpile: ");
           id = sc.nextInt();
          }
          else
        	  return;
           
           /*
            * TODO: Search through stockpiles to find
            * a stockpile whose ID matches the  
            * one that the user entered above. That 
            * stockpile will be stored in sp. 
            */
          Stockpile sp = new Stockpile();
          for (Stockpile soda : stockpileArray) {
        	  if (soda.retID() == id)
        		  sp = soda;
          }
                                 
           /*
            * TODO: Check if the stockpile has not run out of sodas.
            * If not, keep asking users to deposit one-dollar bill 
            * or a coin type as long as the deposited money is less than the 
            * price of soda.
            * 
            * If users deposit more than the price of the soda, the
            * vending machine makes change.
            * If a purchase is successful, the vending machine displays a message 
            * to users and ask them to take soda from beverage receiver. Otherwise, 
            * it reports to users that a stockpile runs out of soda.
            */
           if(sp.checkEmpty()) {
        	   vm.display.stockEmptyMes();
        	   continue;
           }
           else { //while the total deposit is less than the price
        	while(vm.billbox.billDeposit() + vm.centDeposit() < vm.centPrice(sp)) {        	  
        	  System.out.println("Do you insert bill, quarter, dime, or nickel?");
              response = sc.next();
              
              if(response.equals("bill")) {
                vm.billbox.incBill();
              } else if(response.equals("quarter")) {
                vm.coinbox.incQuarter();
              } else if(response.equals("dime")) {
                vm.coinbox.incDime();                    
              } else if(response.equals("nickel")) {
            	vm.coinbox.incNickel(); 
              }
        	}
        	sp.updateQ(); // Decreases quantity by 1
           }
           
           /*
      	   * TODO: obtain the current deposited money. This
      	   * will be compared to the price of soda above.
      	   */   
           int change = vm.amtChange(vm.coinbox, sp);
           vm.billbox.reset(); // Resets billbox
           vm.coinbox.transfer(vm.coinbox2); // Transfers all money to coinbox2.
           
           
           while (change - 25 > 0 && vm.coinbox2.retQuarter() >= 1) {
        	   vm.coinbox2.setQuarter(vm.coinbox2.retQuarter() - 1);
        	   change -= 25;
        	   System.out.println("Take 1 quarter from change receiver.");
           }
           while (change -10 > 0 && vm.coinbox2.retDime() >= 1) {
        	   vm.coinbox2.setDime(vm.coinbox2.retDime() - 1);
        	   change -= 10;
        	   System.out.println("Take 1 dime from change receiver.");
           }
           while (change - 5 > 0 && vm.coinbox2.retNickel() >= 1) {
        	   vm.coinbox2.setNickel(vm.coinbox2.retNickel() - 1);
        	   change -= 5;
        	   System.out.println("Take 1 nickel from change receiver.");
           }
           
           if (change != 0)
        	   vm.changeLight.lackChangeMes();
           vm.display.purchasedMes();
           vm.bevRec.pickupMes();
           System.out.println();
	   }
	}
}
	

