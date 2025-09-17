package Fianance;
import java.util.*;
import java.io.*;

public class IncomeControl {
	public static ClientClass [] array = new ClientClass [2];
	public final static String Passs = "AnhTuan112233";
	
	public static void IncreaseSizeArray(ClientClass [] clients) {
		int newlength = clients.length * 2;
		ClientClass [] newarray = new ClientClass [newlength];
		for(int i=0 ; i<clients.length ; i++) {
			newarray[i] = clients[i];
		}
		array = newarray;
	}
	
	public static void WriteToFile() {
		try {
		PrintWriter write = new PrintWriter(new FileOutputStream("Clients.doc",true));
		write.println("LIST OF CUSTOMERS");
		for(int i =0; i<array.length;i++) {
			write.println(array[i].theSecret());
		}
		write.close();
		}
		catch(IOException IOE) {
			System.out.println(IOE.getMessage());
		}
	}

	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int index = 0;
		while(true) {
		int ans = 0 ;
		System.out.println("------------------------------");
		System.out.println("1/ Open a client ");
		System.out.println("2/ Adminstration ");
		System.out.println("3/ Sign in ");
		System.out.println("4/ Exit ");
		System.out.println("------------------------------");
		System.out.println("Choose an action: ");
		ans = sc.nextInt();
		if(ans == 1) {
			if(index == array.length-1) {
				IncreaseSizeArray(array);
			}
			System.out.println("Enter User Name: ");
			String UserName = sc.next();
			System.out.println("Enter Password: ");
			String Password = sc.next();
			while(true) {
			System.out.println("Confirm Password: ");
			String Password2 = sc.next();
			if(Password.equals(Password2)) {
				System.out.println("Correct !");
				break;
			}
			else {
				System.out.println("Try again");
			}
			}
			System.out.println("Enter your income: ");
			int income = sc.nextInt();
			System.out.println("Enter your name: ");
			String name = sc.next();
			System.out.println("Enter your tax (in %): ");
			int tax = sc.nextInt();
			ClientClass client1 = new ClientClass(income, name, tax, Password, UserName);
			array[index]= new ClientClass(client1);
			
			System.out.println(array[index].toString());
			try {
				PrintWriter writee = new PrintWriter(new FileOutputStream("ClientInfo.txt",true));
				writee.println(array[index].Admin());
				writee.close();
			}
			catch(IOException ie) {
				System.out.println(ie.getMessage());
			}
			index++;
			System.out.println("Enter any things to continue !");
			String nextt = sc.next();
			continue;
		}
		if(ans == 3) {
			while(true) {
			System.out.println("Enter User Name: ");
			String user = sc.next();
			boolean exist = false;
			for(int i=0;i<array.length;i++) {
				if(array[i].getUserName().equals(user)) {
					exist = true;
					System.out.println("Enter password: ");	
					String passw = sc.next();
					if(passw.equals(array[i].getPass()) ) {
						System.out.println("Password is correct ! ");
						exist = true;
						System.out.println(array[i].toString());
						break;
					}
				}
			}
			if(exist == false) {
				System.out.println("Username or password is wrong !");
				break;
			}
			else {
				break;
			}
		}
			System.out.println("Enter any things to continue !");
			String nextt = sc.next();
			continue;
		}
		if(ans == 2) {
			while(true) {
			System.out.println("Password: ");
			String code = sc.next();
			if(code.equals(Passs)) {
				System.out.println("All the data is writen to file \"ClientInfo.txt\"");
				break;
				
			}
			else {
				System.out.println("Wrong password, try again !");
				continue;
			}
			}	
		}
		if(ans == 4) {
			System.out.println("Thank you for using our service");
			break;
			
		}
		}
		sc.close();

	}

}
