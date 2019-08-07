import java.sql.*;
import java.util.Scanner;

public class database 
{
	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	PreparedStatement preparedStatement = null;
	Scanner sc=new Scanner(System.in);
	public database()
	{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");

	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	 

	 stmt=con.createStatement();



	}
	catch(Exception e)
	{ 
		System.out.println(e);
	}

	}
	


	public int displayData(int cid) 
	{
		try {
			String sql = "select * from bankdata where Customer_ID="+cid;
			rs=stmt.executeQuery(sql); 
			
			if(rs.next())
			{
				System.out.println("Welcome"+" "+rs.getString(1)+" "+rs.getString(2));
				return 1;

			}
			
		else
		{
			
			return 0;
		}
			
			
	}
		catch(Exception e)
		{
			System.out.println("");
		}
		return 2;
	}
	
	public void getSavingsBalace(int cid) 
	{
		try {
			String sql = "select * from bankdata where Customer_ID="+cid;
			rs=stmt.executeQuery(sql); 
			
			if(rs.next())
				System.out.println("Savigs Balance is "+rs.getString(3));
		}
		catch(Exception e)
		{
			System.out.println("");
		}
	}
	
	
	public void getChequingBalace(int cid) 
	{
		try {
			String sql = "select * from bankdata where Customer_ID="+cid;
			rs=stmt.executeQuery(sql); 
			
			if(rs.next())
				System.out.println("Chequing Balance is "+rs.getString(4));
		}
		catch(Exception e)
		{
			System.out.println("");
		}
	}

	public void withdrawSaving(int cid) 
	{
		try {
			String sql = "select * from bankdata where Customer_ID="+cid;
			rs=stmt.executeQuery(sql); 
			
			if(rs.next())
				
			{
				float temp=rs.getFloat(3);
				System.out.println("Saving Balance is "+rs.getString(3));
				System.out.println("Enter the amount to Withdraw");
		    	float wtemp=sc.nextFloat();
		    	
		    	if(temp<wtemp)
		    	{
		    		System.out.println("Error! Not Enough money!");	
		    	}
		    	else
		    	{
		    		System.out.println("New Balance is "+(temp-wtemp));
		    		String sqlinsert="update bankdata set SAVINGS_ACCOUNT_BALANCE="+(temp-wtemp)+"where Customer_ID="+cid;
		    		stmt.executeUpdate(sqlinsert); 
		    	}
			}
		}
		catch(Exception e)
		{
			System.out.println("");
		}
	}

	public void withdrawChequing(int cid)
	{
		try {
			String sql = "select * from bankdata where Customer_ID="+cid;
			
			rs=stmt.executeQuery(sql); 
			
			if(rs.next())
				
			{
				float temp=rs.getFloat(4);
				System.out.println("Chequing Balance is "+rs.getString(4));
				System.out.println("Enter the amount to Withdraw");
		    	float wtemp=sc.nextFloat();
		    	
		    	if(temp<wtemp)
		    	{
		    		System.out.println("Error! Not Enough money!");	
		    	}
		    	else
		    	{
		    		System.out.println("Withdrawl Successful");
		    		System.out.println("New Balance is "+(temp-wtemp));
		    		String update="update bankdata set CHEQUING_ACCOUNT_BALANCE="+(temp-wtemp)+"where Customer_ID="+cid;
		    		stmt.executeUpdate(update); 
		    	}
			}
		}
		catch(Exception e)
		{
			System.out.println("");
		}
		
	}

	public void depositSaving(int cid) 
	{
		try {
			String sql = "select * from bankdata where Customer_ID="+cid;
			
			rs=stmt.executeQuery(sql); 
			
			if(rs.next())
				
			{
				float temp=rs.getFloat(3);
				System.out.println("Saving Balance is "+rs.getString(3));
				System.out.println("Enter the amount to deposit");
		    	float wtemp=sc.nextFloat();
		    
		    	System.out.println("Deposit Successful");
		    	System.out.println("New Balance is "+(temp+wtemp));
		    	String update="update bankdata set SAVINGS_ACCOUNT_BALANCE="+(temp+wtemp)+"where Customer_ID="+cid;
		    	stmt.executeUpdate(update);  
		    	
			}
		}
		catch(Exception e)
		{
			System.out.println("");
		}
		
	}

	public void depositChequing(int cid)
	{
		try {
			String sql = "select * from bankdata where Customer_ID="+cid;
			
			rs=stmt.executeQuery(sql); 
			
			if(rs.next())
				
			{
				float temp=rs.getFloat(4);
				System.out.println("Chequing Balance is "+rs.getString(4));
				System.out.println("Enter the amount to Deposit");
		    	float wtemp=sc.nextFloat();
		    	
		    		System.out.println("Deposit Successful");
		    		System.out.println("New Balance is "+(temp+wtemp));
		    		String sqlinsert="update bankdata set CHEQUING_ACCOUNT_BALANCE="+(temp+wtemp)+"where Customer_ID="+cid;
		    		stmt.executeUpdate(sqlinsert); 
		    	
			}
		}
		catch(Exception e)
		{
			System.out.println("");
		}
		
	}
	
	
	}
	


