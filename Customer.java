/***************************************************************************************************************
 *Program CSC 225 Prog I
 * Course Title: Introduction to Computer Science
 * Course Number: CSC 225-800,805
 * Professor: Christine Forde
 * @author Pooja Sharma, Sushma, Amit Pandey
 * @version 1.0, 06/11/2015
 *
 * Description: Program CRC 225 Prog I
 * Abstract:
 * This program is designed to read data from a Customer input file(customer.txt). The read data 
 * is then stored in  an array of type object. The program then displays the unsorted data to the  
 * user. User is then displayed a menu of choices to the user. The menu choices are - 1. Deposit sum 
 * 2. Withdraw amount 3. Create a new customer 4. view all customers 5. Delete a customer 9. Quit.  
 * The program manages each of these choices accordingly. At the end, array is sorted in alphabetical 
 * order by name and all customer account is displayed. (Christine Forde)
 *
 * Class - one (customer)
 * Method - Several that process customer requests
 *
 * Formula-
 * Adds the fee to the withdrawl amount
 * amount = amount + FEE; 
 *
 * Reduces the balance with withdrawl amount        
 * balance = balance - amount;
 *
 * Adds 4.5% interest to the balance
 * balance = balance + (balance*0.045);
 *************************************************************************************************************/
 
 
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import java.io.*;
import java.text.DecimalFormat;


/*
* A class to manage customer account data
*/
public class Customer {
	
   private NumberFormat fmt = NumberFormat.getCurrencyInstance();   
   DecimalFormat df = new DecimalFormat("$0.00");
	private String name;                               //name of the customer
	private double idNumber;                           //Customer ID 
	private double balance;                            //Customer account balance 
	private String phoneNumber;                        //Customer phone number
	private final static double FEE = 1.50;            //Fee charged for successful withdrawl
   final int MAX = 30;                                //Number of customer in ES&L bank
   Customer[] custsArray = new Customer[MAX];         //Array to store customer objects
	
   //default constructors
	public Customer()
	{
		name = "";
		idNumber = 0.0;
		balance = 0.0;
		phoneNumber = "";
	}//end of default constructor
	
   //non-default constructor
	public Customer(String _name, double _idNumber, double _balance, String _phoneNumber)
	{
		name = _name;
		idNumber = _idNumber;
		balance = _balance;
		phoneNumber = _phoneNumber;
	}
   
   /*
    *A method to validate and deducts the withdrawl amount and fee from the balance
    * @param amount withdrawl amount
    * @return balance remaining balance after withdrawl
    */
	public double withdraw(double amount)
	{
      amount = amount + FEE;
		
      if ((amount > 0) && (amount <= balance))
		{
			balance = balance - amount;
		}
		else if (amount < 0)
		{
        
			JOptionPane.showMessageDialog(null, "Error: Amount cannot be less than 0" +
                                       JOptionPane.INFORMATION_MESSAGE);
		}
		else if (amount > balance)
		{                                 
         JOptionPane.showMessageDialog(null,"Error: Insufficient Funds" + "\nName:  " +
          name + "\nRequested: " + df.format(amount) + "\nAvailable: " + df.format(balance));     
      }
      
      return balance;
	}
	
   /*
    * A method to deposit funds into individual customer accounts
    * @param amount 
   */
	public void deposit(double amount)
	{
		if (amount > 0)
		{
			balance += amount;
      }
		else
		{
			JOptionPane.showMessageDialog(null, "Error: Deposit amount is invalid" + "\nCustomer: " +
         name + "\nRequested: " + df.format(amount));
		}
	}
	
	public double addInterest()
	{
		balance = balance + (balance*0.045);
      return balance;
	}
	
   //-----------------------------------------------------------------
   //Method: findIndex
   //Purpose: searches the custsArray by name for a given matching
   //name. Uses the toUpperCase to convert the given name to
   //upper case before during the search. This protects against
   //the given name having lower and upper strings.
   //Parameters: none
   //Returns: an index which is one line of the custArray table when
   //       given the customer's name
   //--------------------------------------------------------------------
   public int findIndex (Customer[] custsArray, String xnam, int count)
   {
   //---------------------------------------------------------------
   //System.out.println("givenNameGetCustomer " + xnam);
   
   for (int index = 0; index < count;index++) //search the entire
                         //table until a match is found
      {
         //if (custsArray[index].getName().compareTo(xnam.toUpperCase()) == 0)
         if (custsArray[index].getName().compareTo(xnam) == 0)
           return index;
      } //end index < custsArray count
   
      //return a -1 to imply a matching name- name not found!
         return -1;
   }  // end for givenNameGetCustomer
   
   /*
   * Method that returns a one-line description of the customer as a string.
   * @return a string of name, idnumber and phonenumber  
   */
   public String toString()
   {
      return (name + "\t" + idNumber + "\t" + fmt.format(balance) +
            "\t" + phoneNumber);
   }
   
   /*
   * An accessor to get name
   * @return name name of the customer
   */
   public String getName()
   {
      return name;
   }
   

   /*
   * method to sort the names in the array
   * @param custsArray Array of objects
   * @param count size of array
   */   
   public static void nameSort(Customer [] custsArray, int count)

    {
      for (int i = 0; i < count - 1; i++)
      {
        boolean exchange = false;
        int smallPos = i;

        for (int j = i+1; j < count; j++)
         if (custsArray[smallPos].getName().compareTo(custsArray[j].getName())
                    > 0)
         {
           smallPos = j;
           exchange = true;
         }

           //switch smallest to ith location
        if (exchange)
        {
           Customer temp = custsArray[i];
           custsArray[i] = custsArray[smallPos];
           custsArray[smallPos] = temp;
           exchange = false;
        }

      }//end for i loop

  } //end method nameSort
  
  /*
  * A method to add new customer to the bank 
  * @param CustArray Array of objects
  * @param count size of the array
  * @param name name of the new customer
  * @param custNumber customer number
  * @param balance new balance amount
  * @param phone phone number of the new customer 
  */
  public void addNewCustomer(Customer[] custArray, int count, String name, double custNumber , double balance, String phone)
  {
      //access methods called from ojects stored in the array
      custArray[count].setName(name);
      custArray[count].setIdNumber(custNumber);
     	custArray[count].setBalance(balance);
     	custArray[count].setPhoneNumber(phone);      
  }
  
  /*
   * A method to set the name of a customer
   * @param name 
  */
  public void setName(String name)
  {
   name = name;
  }
  
  /*
   * A method to set the id number of a customer
   * @param idNumber 
  */
  public void setIdNumber(double idNumber)
  {
   idNumber = idNumber;
  }  
  
  /*
   * A method to set the balance for a customer's account
   * @param balance 
  */
  public void setBalance(double balance)
  {
   balance = balance;
  }
  
  /*
  * A method to set the phone number of a customer
  * @param phoneNumber 
  */  
  public void setPhoneNumber(String phoneNumber)
  {
   phoneNumber = phoneNumber;
  }
  
  
  /*
  * A method to get the balance amount
  * @return balance 
  */  
  public double getBalance()
  {
      return balance;
  }
  
  /*
  * A method to get the is number of a customer
  * @return idNumber 
  */  
  public double getCustomerNumber()
  {
      return idNumber;
  }
  
  
  /*
  * A method to get the phone number of a customer
  * @return phoneNumber phone of the new customer
  */
  public String getPhone()
  {
      return phoneNumber;
  }
  
}//end of Customer class


