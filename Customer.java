import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class Customer {
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();
	private String name;
	private double idNumber;
	private double balance;
	private String phoneNumber;
	private final static double FEE = 1.50;
   final int MAX = 30;
   Customer[] custsArray = new Customer[MAX];
	
	public Customer()
	{
		name = "";
		idNumber = 0.0;
		balance = 0.0;
		phoneNumber = "";
	}//end of default constructor
	
	public Customer(String _name, double _idNumber, double _balance, String _phoneNumber)
	{
		name = _name;
		idNumber = _idNumber;
		balance = _balance;
		phoneNumber = _phoneNumber;
	}

	public double withdraw(double amount)
	{
		if ((amount > 0) && (amount <= balance))
		{
			balance = balance - amount;
			balance = balance - FEE;
         
		}
		else if (amount < 0)
		{
        
			         //System.out.printf("Error: Withdraw amount is invalid/n Customer: %s/nRequested:%f", name, _amount);
		}
		else if (amount > balance)
		{
      //String str = _amount+FEE;
			//System.out.printf("Error: Insufficient funds/nCustomer:%s/nRequested:%f/nAvailable:%f", name, _amount, balance);
		   JOptionPane.showMessageDialog(null, "Error: Insufficient Funds" +
                                       "Customer: " + getName() + 
                                       "Requested: " + amount +
                                       "Available: " + getBalance() +
                                       JOptionPane.INFORMATION_MESSAGE);

      }
      return balance;
	}
	
	public void deposit(double _amount)
	{
		if (_amount > 0)
		{
			balance += _amount;
		}
		else
		{
			System.out.printf("Error: Deposit amount is invalid/nCustomer:%s/nRequested:%f", name, _amount);
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
      custsArray[count].setName(name);
      custsArray[count].setIdNumber(idNumber);
     	custsArray[count].setBalance(balance);
     	custsArray[count].setPhoneNumber(phoneNumber);      
  }
  
  public void setName(String _name)
  {
   name = _name;
  }
 
  public void setIdNumber(double _idNumber)
  {
   idNumber = _idNumber;
  }  
  
  public void setBalance(double _balance)
  {
   balance = _balance;
  }
  
  public void setPhoneNumber(String _phoneNumber)
  {
   phoneNumber = _phoneNumber;
  }
  
  public void deleteCustomer(Customer[] custsArray, int index)
  {
      //custsArray[index].
  }
  
  public double getBalance()
  {
      return balance;
  }
  
  public double getCustomerNumber()
  {
      return idNumber;
  }
  
  public String getPhone()
  {
      return phoneNumber;
  }
  
}//end of Customer class


