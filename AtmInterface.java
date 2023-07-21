import java.util.*;

class Account {
	
	String userName;
	String pin;
	String password;
	String accountNo;
	float accountBalance = 200000f;
	int transactions = 0;
	String transactionHistory = "";
	
	public void userRegistration() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your Name-");
		this.userName = sc.nextLine();
		System.out.print("\nEnter Your Password-");
		this.password = sc.nextLine();
		System.out.print("\nEnter Your Account Number-");
		this.accountNo = sc.nextLine();
		System.out.print("\nEnter Your pin-");
		this.pin= sc.nextLine();
		System.out.println("\nRegistration completed..Go to login");
	}
	
	public void login(){
		boolean isLogin=false;
		Scanner sc=new Scanner(System.in);
		while(!isLogin){
			System.out.println("\nenter your username-");
			String u=sc.nextLine();
			if(u.equals(userName)){
				System.out.println("\nenter your password-");
				String p=sc.nextLine();
				if(p.equals(password)){
					System.out.println("\n---+++---login Sucessfully---++--");
					System.out.println("\n---!!!---WELCOME TO ATM INTERFACE---!!!!---");
					isLogin=true;
				}else{
					System.out.println("\nenter valid password\n");
				}

			}else{
					System.out.println("\nenter valid username\n");
			}

		}
	}
	public boolean userpin() {
		boolean flage=false;
		Scanner sc=new Scanner(System.in);
		String p=sc.nextLine();
		if(p.equals(pin)){
			System.out.println("\nCorrectly entered pin...\n");
			flage=true;
			return flage;
		}else{
			System.out.println("\nIncorrectly entered pin...\n");
			return flage;
		}
		
	}
	public void withdraw() {
		
		System.out.print("\nEnter amount to withdraw : ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			
			if ( accountBalance >= amount ) {
				transactions++;
				accountBalance -= amount;
				System.out.println("\nWithdraw Successfully");
				String str = amount + " Rs Withdrawed\n";
				transactionHistory = transactionHistory.concat(str);
				
			}
			else {
				System.out.println("\nInsufficient Balance.........");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void deposit() {
		
		System.out.print("\nEnter amount to deposit-");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try {
			if ( (amount+accountBalance) <= 200000f ) {
				transactions++;
				accountBalance += amount;
				System.out.println("\nSuccessfully Deposited");
				String str = amount + " Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else {
				System.out.println("\nSorry\nonly 200000 amount for withdraw ");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void transfer() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Receipent's Name-");
		String receipent = sc.nextLine();
		System.out.print("\nEnter amount to transfer-");
		float transferamount = sc.nextFloat();
		try {
			if ( accountBalance >= transferamount ) {
				if ( transferamount <= 50000f ) {
					transactions++;
					accountBalance -= transferamount;
					System.out.println("\nSuccessfully Transfered to " + receipent);
					String str = transferamount + " Rs transfered to " + receipent + "\n";
					transactionHistory = transactionHistory.concat(str);
				}
				else {
					System.out.println("\nSorry\nonly 50000 amout for transfer");
				}
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
		}
		catch ( Exception e) {
		}
	}
	
	public void transHistory() {
		if ( transactions == 0 ) {
			System.out.println("\nEmpty");
		}
		else {
			System.out.println("\n" + transactionHistory);
		}
	}

	public void checkAmount(){
		System.out.println("Account Balance:"+accountBalance);
	}

}

public class AtmInterface {

	public static boolean checkValidChoice(int limit,int value){
	boolean check=false;
	if(value<1 || value>limit){
		System.out.println("\n...invalid choice...\n");
		check=true;
		return check;
	}else{
		//System.out.println("\n...valid choice...\n");
		return check;
	}
} 
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("----choose your choice---");
		System.out.println("1.userRegistration \n2.Exit");
		System.out.println("enter the choice 1 or1 2-");
		int choice=s.nextInt();
		if(checkValidChoice(2,choice)){
			System.exit(0);
		}
		if ( choice == 1 ) {
			Account b1 = new Account();
			b1.userRegistration();
			System.out.println("\n---+++----login----++++---\n");
			b1.login();
		}
		else {
			System.exit(0);
		}	
			while(true) {
				Account b = new Account();
				System.out.println("\n1.EnterPin \n2.Exit");
				System.out.print("Enter Your Choice  1 or 2-");
				int ch=s.nextInt();
				if(checkValidChoice(2,ch)){
					System.exit(0);
				}
				if ( ch == 1 ) {
					if (!b.userpin()) {
						System.out.println("\n-----+++----LOGIN SUCCESSFULLY----+++-----\n");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nEnter Your Choice between 1 to 6 : ");
							int c=s.nextInt();
							if(checkValidChoice(5,choice)){
								System.exit(0);
							}
							switch(c) {
								case 1:
								b.withdraw();
								break;
								case 2:
								b.deposit();
								break;
								case 3:
								b.transfer();
								break;
								case 4:
								b.checkAmount();
								break;
								case 5:
								b.transHistory();
								break;
								case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		
	}
}