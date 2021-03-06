import java.io.BufferedReader;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class BankTestDriver

	{
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();
	final int MAX = 30;
	Customer[] custsArray = new Customer[MAX];
	int count=0;
	StringTokenizer tokenizer;
	String name;
	double custsNumber;
	double balance;
	String phone;
	String line;
	String fileName = "customer.txt";
	BufferedReader inFile;
	int index;
	
	boolean quit =false;
	int choice;
	
	String OutPutText = "";
	String xnam;
	
	/**
	 * @param args
	 */
	
	public void runBankTest()
	{		
		try
		{
			FileReader fr = new FileReader(fileName);
			inFile = new BufferedReader(fr);
		
			line = inFile.readLine();
		
			while(line != null && count < MAX)
			{
				tokenizer = new StringTokenizer(line);
				name = tokenizer.nextToken();
			
		
			try
				{
					custsNumber = Double.parseDouble(tokenizer.nextToken());
					balance = Double.parseDouble(tokenizer.nextToken());
					phone = tokenizer.nextToken();
					custsArray[count++] = new Customer(name, custsNumber, balance, phone);
				}// ends inner try
		
			catch(NumberFormatException exception)
				{
					System.out.println("Error in input. Line ignored: ");
					System.out.println(line);
				}// end catch
				
		
		
		line = inFile.readLine();
		}// end while
		
			/* catch(FileNotFoundException exception)
			{
				System.out.printf("File not found: %s", fileName);			
			}// end catch
			*/
		
		inFile.close();
	
	/*catch(IOException exception)
	{
		System.out.println("IO Exception has occured.");
	} */
	
	System.out.println("\t\tUnsorted customer.txt records");
	System.out.println("");

	for(int scan =0; scan <count; scan++)
		System.out.println(custsArray[scan]);
	
	   while (!quit)
	   {
	     String strChoice =
	       JOptionPane.showInputDialog(null,"Please select an option: \n"
	              + "\t1. Deposit sum to account\n"
	              + "\t2. Withdraw sum from account\n"
	              + "\t3. Create account\n"
	              + "\t4. View all accounts\n"
	              + "\t5. Delete an account\n"
	              + "\t9. Quit", "ES&L Bank", JOptionPane.QUESTION_MESSAGE);

	     choice = Integer.parseInt(strChoice);
	//-----------------------------------------------------------------------
	     switch (choice)
	         {
	          case 1://deposit
	                  xnam  =
	                  JOptionPane.showInputDialog
	                     (null,"Enter the Customer's Name: ",
	                        "ES&L Bank System",JOptionPane.QUESTION_MESSAGE);

	                   index = custsArray[0].findIndex(custsArray, xnam, count);

	           if (index != -1)
	           {
		         System.out.println("");

		        String strDepositAmt =
		          JOptionPane.showInputDialog
		          (null,"Enter the deposit, e.g., 10000.00: ",
		          "ES&L Bank System",JOptionPane.QUESTION_MESSAGE);

	            double depositAmt = Double.parseDouble(strDepositAmt);

	             custsArray[index].deposit(depositAmt);

	             JOptionPane.showMessageDialog
	               (null, xnam + " balance after deposit: "        +
	                         fmt.format(custsArray[index].getBalance() )
	                         + "\n"  +
	                       xnam + " balance after interest is added: " +
	                       fmt.format(custsArray[index].addInterest() ),
	                       "ES&L Bank System",
	                       JOptionPane.INFORMATION_MESSAGE);


	            } // end if stmt

	           else
	           {
		         System.out.println("");
	             System.out.println( xnam + " was not found");
	           }  //end else stmt

	           break; // end choice equals 1


	//---------------------------------------------------------------
	     case 2:   //withdraw

	          //viewCustomers();
	           xnam  =
	            JOptionPane.showInputDialog(null,"Enter the Customer's Name: ",
	              "ES&L Bank System",JOptionPane.QUESTION_MESSAGE);

	           index = custsArray[0].findIndex(custsArray, xnam, count);

	           if (index != -1)
	           {
		         System.out.println("");

		        String strWithdrawAmt =
		          JOptionPane.showInputDialog
		          (null,"Enter the withdrawal, e.g., 10.00: ",
		          "ES&L Bank System",JOptionPane.QUESTION_MESSAGE);

	            double withdrawAmt = Double.parseDouble(strWithdrawAmt);

	             JOptionPane.showMessageDialog
	               (null, xnam + " balance after withdrawal: "       +
	                  fmt.format(custsArray[index].withdraw(withdrawAmt) )
	                   + "\n"  +

	                    xnam + " balance after interest is added: " +
	                    fmt.format(custsArray[index].addInterest() ),
	                    "ES&L Bank System",
	                       JOptionPane.INFORMATION_MESSAGE);

	            } // end if stmt

	           else
	           {
		         System.out.println("");
	             System.out.println( xnam + " was not found");
	           }  //end else stmt

	           break; //end choice equals 2

	//-------------------------------------------------------------

		 case 3:    //create an account

	           if (count < custsArray.length)
	               {
	                 name = JOptionPane.showInputDialog
	                        (null,"Enter Customer's name: ",
	                        "ES&L Bank System",JOptionPane.QUESTION_MESSAGE);

	                 String strCustNum = JOptionPane.showInputDialog
	                        (null,"Enter Customer's Number, e.g., 11111: ",
	                        "ES&L Bank System",JOptionPane.QUESTION_MESSAGE);

	                 custsNumber = Double.parseDouble(strCustNum);

	                 String strBalance = JOptionPane.showInputDialog
	                        (null,"Enter Customer's Balance, e.g., 1000.00: ",
	                      "ES&L Bank System",JOptionPane.QUESTION_MESSAGE);

	                 balance = Double.parseDouble(strBalance);

	                 phone = JOptionPane.showInputDialog
	                           (null,"Enter Customer's phone number: ",
	                      "ES&L Bank System",JOptionPane.QUESTION_MESSAGE);


	 //--------------------------------------------------------------------
	                 custsArray[count]= new Customer();
	                 custsArray[count].addNewCustomer(custsArray, count,
					                     name, custsNumber, balance,
					                     phone);
					 count++;
				    }

	            else
	               JOptionPane.showMessageDialog(null,
	                 "The array is full. No new record added ",
	                 "ES&L Bank System",
	                       JOptionPane.INFORMATION_MESSAGE);

	            break; //end choice equals 3


	//------------------------------------------------------------------
		 case 4:   //view all accounts

	            //sort for output by names
	            custsArray[0].nameSort(custsArray,count);

				 OutPutText = "";

				 for (int scan = 0; scan < count; scan++)
				 {
			       OutPutText =
			          (OutPutText + custsArray[scan].getName() + " " +
				       custsArray[scan].getCustomerNumber() + " "   +
					   fmt.format(custsArray[scan].getBalance()) + " "  +
					   custsArray[scan].getPhone()+ "\n");

			     }

	              JOptionPane.showMessageDialog(null,OutPutText,
	              "ES&L Bank System",
	                       JOptionPane.INFORMATION_MESSAGE);

	              break;  // end choice 4
	 //-----------------------------------------------------------------
	     case 5: //Delete a customer

			   xnam  =
				JOptionPane.showInputDialog(null,"Enter the Customer's Name: ",
				      "ES&L Bank System",JOptionPane.QUESTION_MESSAGE);

				index = custsArray[0].findIndex(custsArray, xnam, count);

				 if (index != -1)
				 {
	                if (count >= 1 && count <= custsArray.length)
	                {
                 //custsArray[index].deleteCustomer(Customer[] custsArray, int index);  
				    custsArray[index] = custsArray[count-1]; //pack the hole
				    count--; //decrement count now that we have one less
				             //element

				  	JOptionPane.showMessageDialog
				                 (null, xnam + " is deleted. ",
				                 "ES&L Bank System",
	                             JOptionPane.INFORMATION_MESSAGE);
				    } // end nested if statement

				  } // end if stmt

				  else
				  {
					  JOptionPane.showMessageDialog
				                 (null, xnam + " was not found ",
				                 "ES&L Bank System",
	                              JOptionPane.INFORMATION_MESSAGE);

	              }  //end else stmt

	              break; // end choice 5

	 //-----------------------------------------------------------------

		   default: quit = true;  //set done to true to exit the system

	//--------------------------------------------------------------------

	      }// end switch statement

	   }// end while loop  for menu





	//----------------------------------------------------------------------

	 custsArray[0].nameSort(custsArray,count);//sort for output by names

	      System.out.println("");
	      System.out.println(" \t\tSorted updated customer.txt records");

	     for (int scan = 0; scan < count; scan++)
	          System.out.println (custsArray[scan]);


	   }//end try block

	//----------------------------------------------------------------

	   catch (FileNotFoundException exception)
	   {
		 System.out.println ("The file " + fileName + " was not found");
	   }



	   catch (IOException exception)
	   {
		 System.out.println (exception);
	   }


	//----------------------------------------------------------



	} //end method runBankTest()

	//------------------------------------------------------------

	public static void main (String[] args)
	   {
	    BankTestDriver bankTest = new BankTestDriver();
	    bankTest.runBankTest();
	    System.exit(0);
	   } // end main method

	//---------------------------------------------------------------

	}// end class BankTestDriver



