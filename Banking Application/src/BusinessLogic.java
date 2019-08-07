
public class BusinessLogic 
{
	database dbase=new database();
	public void callgetsavingsBalance(int cidValue)
	{
		dbase.getSavingsBalace(cidValue);
	}

	public void callgetchequingsBalance(int cidValue)
	{
		dbase.getChequingBalace(cidValue);	
	}

	public void callWithdrawSavingBalance(int cidValue)
	{
		
		dbase.withdrawSaving(cidValue);	
		
	}

	public void callWithdrawChequingBalance(int cidValue) 
	{
		dbase.withdrawChequing(cidValue);
	}

	public void callDepositSavingBalance(int cidValue) 
	{
		dbase.depositSaving(cidValue);
		
	}

	public void callDepositChequingBalance(int cidValue)
	{
		dbase.depositChequing(cidValue);
		
	}

}
