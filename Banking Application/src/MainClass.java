

		import java.util.Scanner;

public class MainClass 
{
static int cidValue;
static database dbase=new database();
static BusinessLogic bl=new BusinessLogic();

	public static void main(String[] args) 
	{
		String temp=null;
		String ch="y";
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Welcome to the Banking Application");
		System.out.println("Enter the Customer ID");
		int cid=sc.nextInt();
		cidValue=cid;
		int reurnValue=dbase.displayData(cid);
		if(reurnValue==1)
		options();
		else
		closeApplication();	
		System.out.println("Thanks for using the application");
		}

	private static void closeApplication() {
		System.out.println("Error, Customer Not Found");
		System.out.println("Thanks for using the applcation");
	}
	
	private static void options() 
	{
		char choice;
		String ch="y";
		while(ch.equalsIgnoreCase("y"))
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter C or c to see customer's balance");
		System.out.println("Enter W or w to withdraw");
		System.out.println("Enter D or d to deposit");
		System.out.println("Enter X or x to exit  ");
		System.out.println("Please Enter Your Choice");
		
		choice=sc.next().charAt(0);
		if(Character.isUpperCase(choice))
			choice=Character.toLowerCase(choice);
		
		switch(choice)
		{
		
		case 'c':
			System.out.println("Enter the account you want to access (S for Savings and C for Chequing)");
			char b=sc.next().charAt(0);
			
			if(Character.isUpperCase(b))
			b=Character.toLowerCase(b);
			if(b=='s')
			bl.callgetsavingsBalance(cidValue);
			if(b=='c')
			bl.callgetchequingsBalance(cidValue);
			break;
			
		case 'w':
			
			System.out.println("Enter the account you want to access (S for Savings and C for Chequing)");
			char withdraw=sc.next().charAt(0);
			
			if(Character.isUpperCase(withdraw))
				withdraw=Character.toLowerCase(withdraw);
		   if(withdraw=='s')
		   bl.callWithdrawSavingBalance(cidValue);
		   if(withdraw=='c')
		   bl.callWithdrawChequingBalance(cidValue);
			   
			break;
			
		case 'd':
			
			System.out.println("Enter the account you want to access (S for Savings and C for Chequing)");
			char deposit=sc.next().charAt(0);
			
			if(Character.isUpperCase(deposit))
				deposit=Character.toLowerCase(deposit);
		
			if(deposit=='s')
			bl.callDepositSavingBalance(cidValue);
			if(deposit=='c')
			bl.callDepositChequingBalance(cidValue);
			
		break;
		
		case 'x':
	
			System.out.println("Thanks for using the applcation");
			System.exit(1);
			break;
		
		}
		
		System.out.println("Do you want to use the application again(y/n)");
		ch=sc.next();
		}
	
	}

}


