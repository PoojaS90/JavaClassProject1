
public class Customer {
	
	private String name;
	private double idNumber;
	private double balance;
	private String phoneNumber;
	private final static double FEE = 1.50;
	
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

	public void withdraw(double _amount)
	{
		if ((_amount > 0) && (_amount <= balance))
		{
			balance = balance - _amount;
			balance = balance - FEE;
		}
		else if (_amount < 0)
		{
			System.out.printf("Error: Withdraw amount is invalid/n Customer: %s/nRequested:%f", name, _amount);
		}
		else if (_amount > balance)
		{
			System.out.printf("Error: Insufficient funds/nCustomer:%s/nRequested:%f/nAvailable:%f", name, _amount, balance);
		}
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
	
	public void addInterest()
	{
		balance = balance + (balance*0.045);
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
public int findIndex (Customer [] custsArray,String xnam, int count)
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
public String toString ()
{
return (name + "\t" + custNumber + "\t" + fmt.format(balance) +
         "\t" + phone);
}
}

	
}//end of Customer class


