package Fianance;

public class ClientClass {
	
	private int income = 0;
	private String name;
	private int tax;
	private int NE; //Necessities Expense
	private int LS ; //long-term saving
	private int EE;//EducationExpense
	private int FF; // Financial Freedom
	private int Ent; // Entertainment
	private int Giving; // Donation
	private String pass;
	private String UserName;
	private int incomeAfter;
	private int ID;
	public static int index = 0;
	
	public ClientClass(int income, String name, int tax, String pass, String UserName) {
		this.name = name;
		this.tax = tax;
		this.income = income;
		int temp = income - ((income * this.tax)/100);
		this.incomeAfter = temp;
		this.pass = pass;
		this.UserName = UserName;
		this.ID = index++;
		CaculationMethod(this.incomeAfter);
	}
	
	public ClientClass(ClientClass client) {
		this.name = client.name;
		this.tax = client.tax;
		this.income = client.income;
		this.incomeAfter = client.incomeAfter;
		this.pass = client.pass;
		this.UserName = client.UserName;
		this.ID = client.ID;
		this.NE = client.NE;
		this.LS = client.LS;
		this.EE = client.EE;
		this.FF = client.FF;
		this.Ent = client.Ent;
		this.Giving = client.Giving;
	}
	
	public void CaculationMethod(int income) {
		this.NE = (55 * income) / 100;
		this.LS = (10 * income) / 100;
		this.EE = (10 * income) / 100;
		this.FF = (10 * income) / 100;
		this.Ent = (10 * income) / 100;
		this.Giving = (5 * income) / 100;
	}
	
	public int getIncome() {
		return this.income;
	}
	
    public String getName() {
		return this.name;
	}
    
    public int getTax() {
		return this.tax;
	}
    
    public String getPass() {
    	return this.pass;
    }
    
    public String getUserName() {
    	return this.UserName;
    }
    
    public int getID() {
    	return this.ID;
    }
    
    public void setID(int ID) {
    	this.ID = ID;
    }
    
    public void setUserName(String UserName) {
    	this.UserName = UserName;
    }
    
    public void setPass(String pass) {
    	this.pass = pass;
    }
    
    public void setIncome(int income) {
		this.income = income;
	}
	
    public void setName(String name) {
		this.name = name;
	}
    
    public void setTax(int tax) {
		this.tax = tax;
	}
    
    public String theSecret() {
    	return "Username: " + this.UserName + "\nPassword: " + "*********" + "\nName: "  + this.name + "\nID: " + this.ID 
    	+ "\nIncome: " + this.income +"$" 
    	+ "\nIncome after tax: " + this.incomeAfter +"$" + " (with tax: " + this.tax + "%" + ")" 
    	+ "\nNecessities Expense: " + this.NE + "$"
    	+ "\nLong-term Saving: " + this.LS + "$"
    	+ "\nEducation Expense: " + this.EE + "$"
    	+ "\nFinancial Freedom: " + this.FF + "$"
    	+ "\nEntertainment: " + this.Ent + "$"
    	+ "\nGiving: " + this.Giving + "$" + "\n" ;
    }
    
    public String Admin() {
    	return "Username: " + this.UserName + "\nPassword: " + this.pass + "\nName: "  + this.name + "\nID: " + this.ID 
    	    	+ "\nIncome: " + this.income +"$" 
    	    	+ "\nIncome after tax: " + this.incomeAfter +"$" + " (with tax: " + this.tax + "%" + ")" + "\n" ;
    	
    }
    
    public String toString() {
    	return "Name: "  + this.name + "\nID: " + this.ID +"\nIncome: "+ this.income +"$" + " with tax: " + this.tax + "%"+ "\nIncome after tax: " + this.incomeAfter+ "$" + "\n---------------------------"
    + "\nNecessities Expense: " + this.NE +"$" + "\nLong-term Saving: " + this.LS + "$" + "\nEducation Expense: " + this.EE +"$"
    + "\nFinancial Freedom: " + this.FF + "$" +  "\nEntertainment: " + this.Ent + "$" +  "\nGiving: " + this.Giving + "$";
    }
    
    
    
    
	

}
