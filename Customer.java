/**Program CSC 225 Prog I
 * Course Title: Introduction to Computer Science
 * Course Number: CSC 225-800,805
 * Professor: Christine Forde
 * @author Pooja Sharma, Sushma, Amit Pandey
 * @version 1.0, 06/11/2015
 *
 * Description: Program CRC 225 Prog I
 * This program is designed to process binary string (a string containing ones and zeroes). The string is input to
 * the program via the command line. Only valid binary symbols will be processed: all others will cause an error 
 * message to display. In addition to a message, the invalid symbol will also be displayed to the user. Invalid 
 * data will not cause the program to ABEND. When the entire string has been processed, summary information is 
 * displayed to the user. (Christine Forde)
 
 * ***********************************INCLUDE FORMULAS **********************************************************
 
 */
   
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import java.io.*;

/*
* A class to manage customer account data
*/
public class Customer {
	
   private NumberFormat fmt = NumberFormat.getCurrencyInstance();
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
         //FIX LINE                                   
         JOptionPane.showMessageDialog(null,String.format("Error: Insufficient Funds\nCustomer: %s\nRequested: %.2f \nAvailable: %.2f\n", getName(), amount, getBalance(), JOptionPane.INFORMATION_MESSAGE));
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
			System.out.printf("Error: Deposit amount is invalid/nCustomer:%s/nRequested:%f", name, amount);
		}
	}
	
	public double addInterest()
	{
		balance = balance + (balance*0.045);
      return balance;
	}
	
	//-----------------------------------------------------------------
//  Method: findIndex
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

//-----------------------------------------------------------------
//  Returns a one-line description of the customer as a string.
//-----------------------------------------------------------------
public String toString()
{
return (name + "\t" + idNumber + "\t" + fmt.format(balance) +
         "\t" + phoneNumber);
}
public String getName()
{
   return name;
}

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
  
  public void addNewCustomer(Customer[] custArray, int count, String name, double custNumber , double balance, String phone)
  {
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
  
  /* ASK PROFESSOR
   * A method to set the name of a customer
   * @param Customer[] custsArray 
   * @param index
   */  
  public void deleteCustomer(Customer[] custsArray, int index)
  {
      //custsArray[index].
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
  
  public String getPhone()
  {
      return phoneNumber;
  }
  
}//end of Customer class


