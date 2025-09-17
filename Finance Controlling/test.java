package Fianance;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class test {

	public static void main(String[] args) {
		int income = 200000;
		String name = "JT";
		int tax = 30;
		ClientClass Client1 = new ClientClass(income, name, tax, "jijo","Johnny");
		
		int income2 = 500000;
		String name2 = "JT2";
		int tax2 = 35;
		ClientClass Client2 = new ClientClass(income2, name2, tax2, "joker","Robber");
		
		try {
			PrintWriter write = new PrintWriter(new FileOutputStream("Clients.doc",true));
			write.println("LIST OF CUSTOMERS");
				write.println(Client1.Admin());
				write.println(Client2.Admin());
				write.close();
			}
			catch(IOException IOE) {
				System.out.println(IOE.getMessage());
				
			}

	}

}
